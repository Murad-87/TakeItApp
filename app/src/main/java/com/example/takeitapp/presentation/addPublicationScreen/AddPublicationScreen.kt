package com.example.takeitapp.presentation.addPublicationScreen

import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import coil.compose.AsyncImage
import com.example.takeitapp.R
import com.example.takeitapp.domain.model.TakeItEntity

@Composable
fun AddPublicationScreen(takeItEntity: TakeItEntity, viewModel: AddPublicationViewModel) {

    val selectedPhotos = remember { mutableStateOf<Uri?>(null) }
    val titlePublicationText = remember { mutableStateOf("") }
    val descriptionText = remember { mutableStateOf("") }
    val addressText = remember { mutableStateOf("") }
    val numberText = remember { mutableStateOf("") }
    val context = LocalContext.current.applicationContext

//    val setGalleryImages = remember { mutableStateOf<List<Uri>>(emptyList()) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            //.background(color = Color.Cyan)
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
            .padding(8.dp),
    ) {
        PhotoSelector(selectedPhotos = selectedPhotos)
        Spacer(modifier = Modifier.height(4.dp))
        Description(
            titlePublicationText = titlePublicationText,
            descriptionText = descriptionText
        )
        Spacer(modifier = Modifier.height(4.dp))
        Address(addressText = addressText)
        Spacer(modifier = Modifier.height(4.dp))
        Number(numberText = numberText)
        Spacer(modifier = Modifier.height(4.dp))
        AddButton(onClick = {
            if (titlePublicationText.value.isNotBlank() && descriptionText.value.isNotBlank()
                && addressText.value.isNotBlank() && numberText.value.isNotBlank()
            ) {
                viewModel.saveData(takeItEntity)
                Log.d("TEST", "${viewModel.saveData(takeItEntity)}")
                Toast
                    .makeText(context, "Публикация добавлена", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast
                    .makeText(context, "Заполните все поля", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}

@Composable
fun PhotoSelector(
    selectedPhotos: MutableState<Uri?>
) {
    val context = LocalContext.current.applicationContext
    //  val setGalleryImages by remember { mutableStateOf<List<Uri>>(emptyList()) }
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {uri ->
        if (uri != null) {
            selectedPhotos.value = uri
        }
    }
    Card(
        modifier = Modifier
            .clickable {
                launcher.launch("image/*")
                Toast
                    .makeText(context, "Выберите фото", Toast.LENGTH_SHORT)
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
            if (selectedPhotos.value != null) {
                AsyncImage(
                    model = selectedPhotos.value,
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
}

@Composable
fun Description(
    titlePublicationText: MutableState<String>,
    descriptionText: MutableState<String>
) {
    val focusManager = LocalFocusManager.current
    val maxChar = 20
    val maxCharDescription = 220
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            value = titlePublicationText.value,
            onValueChange = { if (it.length <= maxChar) titlePublicationText.value = it },
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
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
        ) {
            OutlinedTextField(
                value = descriptionText.value,
                onValueChange = { if (it.length <= maxCharDescription) descriptionText.value = it },
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
    }
}

@Composable
fun Address(addressText: MutableState<String>) {

    OutlinedTextField(
        value = addressText.value,
        onValueChange = { addressText.value = it },
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
    )
}

@Composable
fun Number(numberText: MutableState<String>) {
    val maxCharNumber = 11

    OutlinedTextField(
        value = numberText.value,
        onValueChange = { if (it.length <= maxCharNumber) numberText.value = it },
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

@Composable
fun AddButton(
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick.invoke() },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Text(text = "Опубликовать", fontSize = 18.sp)
    }
}