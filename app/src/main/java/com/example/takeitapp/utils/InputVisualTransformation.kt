package com.example.takeitapp.utils

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

private const val DEFAULT_MASK_CHAR = '0'

class InputVisualTransformation(
    private val mask: String,
    private val maskNumber: Char = DEFAULT_MASK_CHAR,
    private val shouldReverse: Boolean = false
) : VisualTransformation {

    private val maxLength = mask.count { it == maskNumber }

    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed = if (text.length > maxLength) text.take(maxLength) else text

        val annotatedString = buildAnnotatedString {
            if (trimmed.isEmpty()) return@buildAnnotatedString

            var maskIndex = 0
            var textIndex = 0
            while (textIndex < trimmed.length && maskIndex < mask.length) {
                if (mask[maskIndex] != maskNumber) {
                    val nextDigitIndex = mask.indexOf(maskNumber, maskIndex)
                    append(mask.substring(maskIndex, nextDigitIndex))
                    maskIndex = nextDigitIndex
                }
                append(
                    if (shouldReverse) {
                        trimmed.reversed()[textIndex++]
                    } else {
                        trimmed[textIndex++]
                    }
                )
                maskIndex++
            }
        }

        return TransformedText(
            if (shouldReverse) buildAnnotatedString { append(annotatedString.text.reversed()) } else annotatedString,
            InputOffsetMapper(mask, maskNumber)
        )
    }

    override fun equals(other: Any?): Boolean {
        return when {
            this === other -> true
            other !is InputVisualTransformation -> false
            mask != other.mask -> false
            maskNumber != other.maskNumber -> false
            else -> true
        }
    }

    override fun hashCode(): Int {
        return mask.hashCode()
    }
}

private class InputOffsetMapper(
    private val mask: String,
    private val numberChar: Char
) : OffsetMapping {

    override fun originalToTransformed(offset: Int): Int {
        var noneDigitCount = 0
        var i = 0
        while (i < offset + noneDigitCount) {
            if (mask[i++] != numberChar) noneDigitCount++
        }
        return offset + noneDigitCount
    }

    override fun transformedToOriginal(offset: Int): Int =
        offset - mask.take(offset).count { it != numberChar }
}