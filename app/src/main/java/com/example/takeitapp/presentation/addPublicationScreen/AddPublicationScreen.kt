package com.example.takeitapp.presentation.addPublicationScreen

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.takeitapp.R
import com.example.takeitapp.domain.model.TakeItEntity

@Composable
fun AddPublicationScreen(takeIt: TakeItEntity) {
    //val viewModel = hiltViewModel<AddPublicationViewModel>()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            //.background(color = Color.Cyan)
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
            .padding(8.dp),
    ) {
        AddPhoto()
        Spacer(modifier = Modifier.height(4.dp))
        AddInfoPublication(title = takeIt.title, description = takeIt.description)
        Spacer(modifier = Modifier.height(4.dp))
        AddAddress()
        Spacer(modifier = Modifier.height(4.dp))
        AddNumber()
        Spacer(modifier = Modifier.height(4.dp))
        AddButton()
    }
}

@Composable
fun AddPhoto() {
    val context = LocalContext.current.applicationContext
    val (selectedPhotos, setGalleryImages) = remember { mutableStateOf<List<Uri>>(emptyList()) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetMultipleContents(),
        onResult = { uris ->
            setGalleryImages(uris.take(2))
        }
    )
    Card(
        modifier = Modifier
            .clickable {
                launcher.launch("image/*")
                Toast
                    .makeText(context, "Добавить фото", Toast.LENGTH_SHORT)
                    .show()
            }
            .fillMaxWidth()
            .height(200.dp)
            .border(1.dp, color = Color.Black, RoundedCornerShape(4.dp)),
        elevation = 3.dp,
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .horizontalScroll(state = rememberScrollState()),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (selectedPhotos.isNotEmpty()) {
                selectedPhotos.forEach { photo ->
                    AsyncImage(
                        model = photo,
                        contentDescription = ""
                    )
                }
            } else {
                Image(
                    painter = painterResource(id = R.drawable.ic_add_photo),
                    contentDescription = ""
                )
                Text(text = "Добавить фото", fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun AddInfoPublication(title: String, description: String) {
    var titlePublicationText by remember { mutableStateOf("") }
    var descriptionText by remember { mutableStateOf("") }
    val maxChar = 20
    val maxCharDescription = 220
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
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
        )
        Spacer(modifier = Modifier.height(5.dp))
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
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
fun AddAddress() {
    var addressText by remember { mutableStateOf("") }
    Box() {
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
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun AddNumber() {
    var numberText by remember { mutableStateOf("") }
    val maxCharNumber = 11

    Box() {
        OutlinedTextField(
            value = numberText,
            onValueChange = { if (it.length <= maxCharNumber) numberText = it },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = {
                Text(
                    text = "Номер",
                    style = TextStyle(color = Color.Gray),
                    fontWeight = FontWeight.Bold,
                )
            },
            placeholder = { Text(text = "Номер для связи..") },
            textStyle = TextStyle.Default.copy(fontSize = 16.sp),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun AddButton() {
    val context = LocalContext.current
    Button(
        onClick = { Toast.makeText(context, "Публикация добавлена", Toast.LENGTH_SHORT).show() },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Text(text = "Опубликовать", fontSize = 18.sp)
    }
}
