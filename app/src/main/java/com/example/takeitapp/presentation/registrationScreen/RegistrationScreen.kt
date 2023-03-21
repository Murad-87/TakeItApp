package com.example.takeitapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.takeitapp.R

@Preview(showBackground = true)
@Composable
fun RegistrationScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Регистрация", fontSize = 26.sp, modifier = Modifier.padding(top = 10.dp))
        Spacer(modifier = Modifier.height(10.dp))
        AddPhotoRegistration()
        Spacer(modifier = Modifier.height(10.dp))
        AddInfoRegistration()
    }
}

@Composable
fun AddPhotoRegistration() {
    Box(
        modifier = Modifier
            .border(2.dp, color = Color.Black, shape = CircleShape)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_add_photo_registration),
            contentDescription = ""
        )
    }
}

@Composable
fun AddInfoRegistration() {
    var nameText by remember { mutableStateOf(TextFieldValue("")) }
    var numberText by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = nameText,
            leadingIcon = { Icon(imageVector = Icons.Default.Face, contentDescription = "") },
            onValueChange = { nameText = it },
            modifier = Modifier
                .fillMaxWidth(),
            label = { Text(text = "Имя", fontSize = 16.sp) },
            placeholder = { Text(text = "Введите ваше имя") },
            textStyle = TextStyle.Default.copy(fontSize = 16.sp)
        )
        Spacer(modifier = Modifier.height(6.dp))
        OutlinedTextField(
            value = numberText,
            leadingIcon = { Icon(imageVector = Icons.Default.Phone, contentDescription = "") },
            onValueChange = { numberText = it },
            modifier = Modifier
                .fillMaxWidth(),
            label = { Text(text = "Номер", fontSize = 16.sp) },
            placeholder = { Text(text = "Введите ваш номер") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            textStyle = TextStyle.Default.copy(fontSize = 16.sp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(text = "Сохранить", fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Зайти как гость",
            style = TextStyle(textDecoration = TextDecoration.Underline, color = Color.Blue),
            fontSize = 18.sp,
            modifier = Modifier.clickable { /*TODO пользователь заходит без возможности публиковать*/ }
        )
    }
}

