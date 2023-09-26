package com.mytakeitapp.common.utils

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mytakeitapp.common.R

@Composable
fun MyAlertDialog(
    title: String,
    message: String,
    onConfirm: () -> Unit,
    onCancel: () -> Unit,
    dialogState: MutableState<Boolean>,
) {
    AlertDialog(onDismissRequest = {
        dialogState.value = false
    },
        confirmButton = {
            TextButton(onClick = {
                onConfirm()
            }) {
                Text(
                    text = stringResource(id = R.string.confirm_button_yes_string),
                    style = TextStyle(color = Color.Black),
                    fontSize = 16.sp
                )
            }
        },
        dismissButton = {
            TextButton(onClick = {
                onCancel()
            }) {
                Text(
                    text = stringResource(id = R.string.dismiss_button_cancel_string),
                    style = TextStyle(color = Color.Black),
                    fontSize = 16.sp
                )
            }
        },
        title = {
            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
        },
        text = {
            Text(
                text = message,
                style = TextStyle(color = Color.Black)
            )
        }
    )
}