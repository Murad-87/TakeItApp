package com.example.takeitapp.presentation.loginScreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.takeitapp.R
import com.example.takeitapp.utils.InputVisualTransformation

@Preview(showBackground = true)
@Composable
fun LoginScreen() {

    val context = LocalContext.current.applicationContext
    var loginNumber by remember {
        mutableStateOf("")
    }
    val maxCharLoginNumber = 10
    val focusManager = LocalFocusManager.current
    var remainingCharsLoginNumber by remember {
        mutableStateOf(maxCharLoginNumber)
    }
    var loginPassword by remember { mutableStateOf("") }
    val maxCharLoginPassword = 10
    var remainingCharsLoginPassword by remember { mutableStateOf(maxCharLoginPassword) }
    val mask = "+7 (000) 000-00-00"
    val transformer = InputVisualTransformation(mask = mask)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, end = 10.dp)
    ) {

        Surface(
            modifier = Modifier
                .size(240.dp)
                .border(1.dp, color = Color.Black, shape = CircleShape)

        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_take_it),
                contentDescription = "",
                modifier = Modifier
                    .size(240.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Поле для ввода номера LoginScreen
        OutlinedTextField(
            value = loginNumber,
            onValueChange = {
                if (it.length <= maxCharLoginNumber) {
                    loginNumber = it
                    remainingCharsLoginNumber = maxCharLoginNumber - it.length
                }
            },
            visualTransformation = transformer,
            leadingIcon = { Icon(imageVector = Icons.Default.Phone, contentDescription = "") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp),
            label = {
                Text(
                    text = "Номер",
                    fontSize = 16.sp,
                    style = TextStyle(color = Color.Black)
                )
            },
            placeholder = { Text(text = "Введите ваш номер") },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Number
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            textStyle = TextStyle.Default.copy(fontSize = 16.sp),
            maxLines = 1,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black
            ),
            trailingIcon = {
                val remainingTextNumber = "${remainingCharsLoginNumber}/${maxCharLoginNumber}"
                Box(contentAlignment = Alignment.BottomEnd) {
                    Text(
                        text = remainingTextNumber,
                        fontSize = 14.sp,
                        color = if (remainingCharsLoginNumber <= 0) Color.Red else Color.Black,
                        modifier = Modifier.widthIn(60.dp)
                    )
                }
            },
            shape = CircleShape
        )

        Spacer(modifier = Modifier.height(6.dp))

        // Поле для ввода пароля LoginScreen
        OutlinedTextField(
            value = loginPassword,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_password),
                    contentDescription = ""
                )
            },
            onValueChange = {
                if (it.length <= maxCharLoginPassword) {
                    loginPassword = it
                    remainingCharsLoginPassword = maxCharLoginPassword - it.length
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp),
            label = {
                Text(
                    text = "Пароль",
                    fontSize = 16.sp,
                    style = TextStyle(color = Color.Black),
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            textStyle = TextStyle.Default.copy(fontSize = 16.sp),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            maxLines = 1,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black
            ),
            trailingIcon = {
                val remainingTextPassword = "${remainingCharsLoginPassword}/${maxCharLoginPassword}"
                Box(contentAlignment = Alignment.BottomEnd) {
                    Text(
                        text = remainingTextPassword,
                        fontSize = 14.sp,
                        color = if (remainingCharsLoginPassword <= 0) Color.Red else Color.Black,
                        modifier = Modifier.widthIn(60.dp)
                    )
                }
            },
            shape = CircleShape
        )

        Spacer(modifier = Modifier.height(6.dp))

        Button(
            onClick = {
                if (loginNumber.isNotBlank() && loginPassword.isNotBlank()) {
                    // TODO реализовать переход на главный экран
                    Toast.makeText(
                        context, "Заходим в приложение",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        context, "Заполните все поля",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Cyan),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            shape = CircleShape,
        ) {
            Text(text = "Войти", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Забыли пароль?",
            style = TextStyle(textDecoration = TextDecoration.Underline, color = Color.Black),
            fontSize = 18.sp,
            modifier = Modifier.clickable {
                // TODO реализовать отправку нового пароля на номер
                Toast.makeText(
                    context, "Отправлен новый пароль",
                    Toast.LENGTH_SHORT
                ).show()
            }
        )
    }
}