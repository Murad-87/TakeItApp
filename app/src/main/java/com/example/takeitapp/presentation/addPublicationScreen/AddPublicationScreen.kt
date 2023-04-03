package com.example.takeitapp.presentation.addPublicationScreen

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.takeitapp.R
import com.example.takeitapp.domain.model.TakeItEntity

@Composable
fun AddPublicationScreen(
    navController: NavController,
    viewModel: AddPublicationViewModel
) {

    var selectedPhotos by remember { mutableStateOf<Uri?>(null) }
    var titlePublicationText by remember { mutableStateOf("") }
    var descriptionText by remember { mutableStateOf("") }
    var addressText by remember { mutableStateOf("") }
    var numberText by remember { mutableStateOf("") }
    val context = LocalContext.current.applicationContext

    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
            if (uri != null) {
                selectedPhotos = uri
                context.contentResolver.takePersistableUriPermission(
                    uri,
                    Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
                )
            }
        }

    val maxCharNumber = 11
    val focusManager = LocalFocusManager.current
    val maxChar = 20
    val maxCharDescription = 220

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            //.background(color = Color.Cyan)
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
            .padding(vertical = 6.dp, horizontal = 10.dp),
    ) {

        // Добаление фото
        Card(
            modifier = Modifier
                .clickable {
                    launcher.launch(arrayOf("image/*"))
                    Toast
                        .makeText(context, "Выберите фото", Toast.LENGTH_SHORT)
                        .show()
                }
                .fillMaxWidth()
                .height(200.dp)
                .border(1.dp, color = Color.Black, RoundedCornerShape(4.dp)),
            elevation = 2.dp,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .horizontalScroll(state = rememberScrollState()),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                if (selectedPhotos != null) {
                    AsyncImage(
                        model = selectedPhotos,
                        contentDescription = "",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                    )
                } else {
                    Image(
                        painter = painterResource(id = R.drawable.ic_add_photo),
                        contentDescription = ""
                    )
                    Text(text = "Добавить фото", fontSize = 16.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        // Поле для названия
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            value = titlePublicationText,
            onValueChange = { if (it.length <= maxChar) titlePublicationText = it },
            label = {
                Text(
                    text = "Название",
                    style = TextStyle(color = Color.Gray),
                    fontWeight = FontWeight.Bold,
                )
            },
            placeholder = { Text(text = "Название предмета...") },
            textStyle = TextStyle.Default.copy(fontSize = 24.sp),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Text
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
        )

        Spacer(modifier = Modifier.height(5.dp))

        // Поле для описания
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
        ) {
            OutlinedTextField(
                value = descriptionText,
                onValueChange = { if (it.length <= maxCharDescription) descriptionText = it },
                label = {
                    Text(
                        text = "Описание",
                        style = TextStyle(color = Color.Gray),
                        fontWeight = FontWeight.Bold,
                    )
                },
                placeholder = { Text(text = "Добавить описание..") },
                textStyle = TextStyle.Default.copy(fontSize = 16.sp),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Text
                ),
                keyboardActions = KeyboardActions(
                    onDone = { focusManager.clearFocus() }
                ),
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        // Поле для адреса
        OutlinedTextField(
            value = addressText,
            onValueChange = { addressText = it },
            label = {
                Text(
                    text = "Адрес",
                    style = TextStyle(color = Color.Gray),
                    fontWeight = FontWeight.Bold,
                )
            },
            placeholder = { Text(text = "Указать адрес..") },
            textStyle = TextStyle.Default.copy(fontSize = 16.sp),
            modifier = Modifier.fillMaxWidth(),
            maxLines = 2,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Text
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Поле для номера телефона
        OutlinedTextField(
            value = numberText,
            onValueChange = { if (it.length <= maxCharNumber) numberText = it },
            singleLine = true,
            label = {
                Text(
                    text = "Номер",
                    style = TextStyle(color = Color.Gray),
                    fontWeight = FontWeight.Bold,
                )
            },
            placeholder = { Text(text = "Номер для связи..") },
            textStyle = TextStyle.Default.copy(fontSize = 16.sp),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Number
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(4.dp))

        //Кнопка для добавления
        Button(
            onClick = {
                if (titlePublicationText.isNotBlank() && descriptionText.isNotBlank()
                    && addressText.isNotBlank() && numberText.isNotBlank()
                ) {
                    val publication = TakeItEntity(
                        null,
                        titlePublicationText,
                        selectedPhotos.toString(),
                        descriptionText,
                        addressText,
                        numberText,
                    )
                    viewModel.insertData(publication)
                    navController.navigate("my publication")
                    Toast
                        .makeText(context, "Публикация добавлена", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast
                        .makeText(context, "Заполните все поля", Toast.LENGTH_SHORT)
                        .show()
                }
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Cyan),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(text = "Опубликовать", fontSize = 18.sp)
        }
    }
}