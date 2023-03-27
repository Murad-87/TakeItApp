package com.example.takeitapp.presentation.registrationScreen

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.takeitapp.R
import com.example.takeitapp.utils.GuestDialog

@Composable
fun RegistrationScreen(navController: NavController) {

    val selectPhotoForRegistration = remember {
        mutableStateOf<Uri?>(null)
    }
    val nameText = remember { mutableStateOf("") }
    val numberText = remember { mutableStateOf("") }
    val passwordText = remember {
        mutableStateOf("")
    }
    val dialogState = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Регистрация", fontSize = 26.sp, modifier = Modifier.padding(top = 10.dp))
        Spacer(modifier = Modifier.height(10.dp))
        AddPhotoRegistration(selectPhotoForRegistration = selectPhotoForRegistration)
        Spacer(modifier = Modifier.height(10.dp))
        AddInfoRegistration(
            nameText = nameText,
            numberText = numberText,
            passwordText = passwordText,
            dialogState = dialogState,
            navController = navController
        )
    }
}

@Composable
fun AddPhotoRegistration(
    selectPhotoForRegistration: MutableState<Uri?>
) {

    val context = LocalContext.current.applicationContext
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        if (uri != null) {
            selectPhotoForRegistration.value = uri
        }
    }

    Surface(
        modifier = Modifier
            .size(240.dp)
            .border(2.dp, color = Color.Black, shape = CircleShape)
            .clickable {
                launcher.launch("image/*")
                Toast
                    .makeText(context, "Выберите фото", Toast.LENGTH_SHORT)
                    .show()
            },
    ) {
        if (selectPhotoForRegistration.value != null) {
            AsyncImage(
                model = selectPhotoForRegistration.value, contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.ic_add_photo_registration),
                contentDescription = "",
                modifier = Modifier
                    .size(240.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun AddInfoRegistration(
    nameText: MutableState<String>,
    numberText: MutableState<String>,
    passwordText: MutableState<String>,
    dialogState: MutableState<Boolean>,
    navController: NavController
) {

    val context = LocalContext.current.applicationContext
    val focusManager = LocalFocusManager.current
    val maxCharNumber = 11
    val maxCharName = 15
    val maxCharPassword = 10
    var remainingCharsName by remember { mutableStateOf(maxCharName) }
    var remainingCharsNumber by remember { mutableStateOf(maxCharNumber) }
    var remainingCharsPassword by remember { mutableStateOf(maxCharPassword) }

    if (dialogState.value) {
        GuestDialog(dialogState, navController)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //Поле для ввода имени
        OutlinedTextField(
            value = nameText.value,
            leadingIcon = { Icon(imageVector = Icons.Default.Face, contentDescription = "") },
            onValueChange = {
                if (it.length <= maxCharName) {
                    nameText.value = it
                    remainingCharsName = maxCharName - it.length
                }
            },
            modifier = Modifier
                .fillMaxWidth(),
            label = {
                Text(
                    text = "Имя",
                    fontSize = 16.sp,
                    style = TextStyle(color = Color.Black),
                )
            },
            placeholder = { Text(text = "Введите ваше имя") },
            maxLines = 1,
            textStyle = TextStyle.Default.copy(fontSize = 24.sp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Text
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            trailingIcon = {
                val remainingText = "${remainingCharsName}/${maxCharName}"
                Box(contentAlignment = Alignment.BottomEnd) {
                    Text(
                        text = remainingText,
                        fontSize = 14.sp,
                        color = if (remainingCharsName <= 0) Color.Red else Color.Black,
                        modifier = Modifier.widthIn(60.dp)
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(6.dp))

        // Поле для ввода номера
        OutlinedTextField(
            value = numberText.value,
            onValueChange = {
                if (it.length <= maxCharNumber) {
                    numberText.value = it
                    remainingCharsNumber = maxCharNumber - it.length
                }
            },
            leadingIcon = { Icon(imageVector = Icons.Default.Phone, contentDescription = "") },
            modifier = Modifier
                .fillMaxWidth(),
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
                val remainingTextNumber = "${remainingCharsNumber}/${maxCharNumber}"
                Box(contentAlignment = Alignment.BottomEnd) {
                    Text(
                        text = remainingTextNumber,
                        fontSize = 14.sp,
                        color = if (remainingCharsNumber <= 0) Color.Red else Color.Black,
                        modifier = Modifier.widthIn(60.dp)
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(6.dp))

        // Поле для ввода пароля
        OutlinedTextField(
            value = passwordText.value,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_password),
                    contentDescription = ""
                )
            },
            onValueChange = {
                if (it.length <= maxCharPassword) {
                    passwordText.value = it
                    remainingCharsPassword = maxCharPassword - it.length
                }
            },
            modifier = Modifier
                .fillMaxWidth(),
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
                val remainingTextPassword = "${remainingCharsPassword}/${maxCharPassword}"
                Box(contentAlignment = Alignment.BottomEnd) {
                    Text(
                        text = remainingTextPassword,
                        fontSize = 14.sp,
                        color = if (remainingCharsPassword <= 0) Color.Red else Color.Black,
                        modifier = Modifier.widthIn(60.dp)
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                if (nameText.value.isNotBlank() && numberText.value.isNotBlank()) {
                    // TODO переход на экран MyHomeScreen
                    Toast.makeText(context, "Переход на галвный экран", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Заполните все поля", Toast.LENGTH_SHORT).show()
                }
            },
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
            style = TextStyle(textDecoration = TextDecoration.Underline, color = Color.Black),
            fontSize = 18.sp,
            modifier = Modifier.clickable {
                dialogState.value = true
            }
        )
    }
}