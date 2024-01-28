package com.mytakeitapp.authentication_flow.presentation.registrationScreen

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.mytakeitapp.authentication_flow.R
import com.mytakeitapp.common.utils.InputVisualTransformation
import com.mytakeitapp.common.utils.MyAlertDialog
import com.mytakeitapp.common.utils.NavigationScreens
import com.mytakeitapp.ui_kit.theme.DarkGray

@Composable
fun RegistrationScreen(navController: NavController) {

    val selectPhotoForRegistration = remember {
        mutableStateOf<Uri?>(null)
    }
    val nameText = remember { mutableStateOf("") }
    val emailText = remember { mutableStateOf("") }
    val passwordText = remember { mutableStateOf("") }
    val dialogState = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Регистрация", fontSize = 26.sp, modifier = Modifier.padding(top = 10.dp))
        Spacer(modifier = Modifier.height(10.dp))
        AddPhotoRegistration(selectPhotoForRegistration = selectPhotoForRegistration)
        Spacer(modifier = Modifier.height(10.dp))
        AddInfoRegistration(
            nameText = nameText,
            emailText = emailText,
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
            .clip(shape = CircleShape)
            .border(2.dp, color = Color.Black, shape = CircleShape)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(
                    color = Color.Black
                ),
                onClick = {
                    launcher.launch("image/*")
                    Toast
                        .makeText(context, "Выберите фото", Toast.LENGTH_SHORT)
                        .show()
                }
            ),
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
                    .fillMaxSize()
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun AddInfoRegistration(
    nameText: MutableState<String>,
    emailText: MutableState<String>,
    passwordText: MutableState<String>,
    dialogState: MutableState<Boolean>,
    navController: NavController
) {

    val context = LocalContext.current.applicationContext
    val focusManager = LocalFocusManager.current
    val maxCharEmail = 100
    val maxCharName = 15
    val maxCharPassword = 10
    var remainingCharsName by remember { mutableStateOf(maxCharName) }
    var remainingCharsEmail by remember { mutableStateOf(maxCharEmail) }
    var remainingCharsPassword by remember { mutableStateOf(maxCharPassword) }
    val mask = "+7 (000) 000-00-00"
    val transformer = InputVisualTransformation(mask = mask)
    var isVisibilityPasswordIcon by remember {
        mutableStateOf(true)
    }

    if (dialogState.value) {
        MyAlertDialog(
            title = stringResource(id = R.string.guest_dialog_title),
            message = stringResource(id = R.string.guest_dialog_message),
            onConfirm = {
                dialogState.value = false
                navController.navigate("home_screen") {
                    popUpTo(route = NavigationScreens.RegistrationScreen.route) {
                        inclusive = true
                    }
                }
            },
            onCancel = { dialogState.value = false },
            dialogState = dialogState
        )
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
                    text = stringResource(id = R.string.registration_name_label_string),
                    fontSize = 16.sp,
                    style = TextStyle(color = Color.Black),
                )
            },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.registration_name_placeholder_string)
                )
            },
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
            },
        )

        Spacer(modifier = Modifier.height(6.dp))

        // Поле для ввода email
        OutlinedTextField(
            value = emailText.value,
            onValueChange = {
                if (it.length <= maxCharEmail) {
                    emailText.value = it
                    remainingCharsEmail = maxCharEmail - it.length
                }
            },
            //visualTransformation = transformer,
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "") },
            modifier = Modifier
                .fillMaxWidth(),
            label = {
                Text(
                    text = stringResource(id = R.string.registration_number_label_string),
                    fontSize = 16.sp,
                    style = TextStyle(color = Color.Black)
                )
            },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.registration_number_placeholder_string)
                )
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Email
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
                val remainingTextEmail = "${remainingCharsEmail}/${maxCharEmail}"
                Box(contentAlignment = Alignment.BottomEnd) {
                    Text(
                        text = remainingTextEmail,
                        fontSize = 14.sp,
                        color = if (remainingCharsEmail <= 0) Color.Red else Color.Black,
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
                IconButton(onClick = { isVisibilityPasswordIcon = !isVisibilityPasswordIcon }) {
                    Icon(
                        painter = if (isVisibilityPasswordIcon) {
                            painterResource(id = R.drawable.password_visibility)
                        } else {
                            painterResource(id = R.drawable.ic_visibility_password_off)
                        },
                        contentDescription = ""
                    )
                }

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
                    text = stringResource(id = R.string.registration_password_label_string),
                    fontSize = 16.sp,
                    style = TextStyle(color = Color.Black),
                )
            },
            visualTransformation = if (isVisibilityPasswordIcon) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
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
                if ( emailText.value.isNotBlank() && passwordText.value.isNotBlank()) {
                    // TODO переход на экран MyHomeScreen
                    Toast.makeText(context, "Переход на галвный экран", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Заполните все поля", Toast.LENGTH_SHORT).show()
                }
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Cyan),
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Text(
                text = stringResource(id = R.string.registration_button_title_string),
                fontSize = 18.sp
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(id = R.string.registration_go_to_guest),
            style = TextStyle(textDecoration = TextDecoration.Underline, color = Color.Black),
            color = DarkGray,
            fontSize = 18.sp,
            modifier = Modifier.clickable (
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(
                    color = Color.Black
                ),
                onClick = {
                    dialogState.value = true
                }
            )
        )
    }
}