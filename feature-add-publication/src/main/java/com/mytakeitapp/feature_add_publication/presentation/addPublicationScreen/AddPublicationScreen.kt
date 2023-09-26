package com.mytakeitapp.feature_add_publication.presentation.addPublicationScreen

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.mytakeitapp.common.utils.InputVisualTransformation
import com.mytakeitapp.feature_add_publication.domain.model.AddPublicationEntity
import com.mytakeitapp.ui_kit.R
import com.mytakeitapp.ui_kit.theme.ColorTextField

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

    val maxCharNumber = 10
    val focusManager = LocalFocusManager.current
    val maxChar = 20
    val maxCharDescription = 220
    val mask = "+7 (000) 000-00-00"
    val transformer = InputVisualTransformation(mask = mask)

    Scaffold { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(state = rememberScrollState())
                    .padding(start = 20.dp, end = 20.dp, top = 10.dp),
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
                            Text(
                                text = stringResource(id = R.string.add_photo_string),
                                fontSize = 16.sp
                            )
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
                            text = stringResource(id = R.string.publication_title_string),
                            style = TextStyle(color = Color.Gray),
                            fontWeight = FontWeight.Bold,
                        )
                    },
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.publication_title_placeholder_string)
                        )
                    },
                    textStyle = TextStyle.Default.copy(fontSize = 24.sp),
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done,
                        keyboardType = KeyboardType.Text
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    ),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = ColorTextField,
                        cursorColor = Color.Black
                    )
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
                        onValueChange = {
                            if (it.length <= maxCharDescription) descriptionText = it
                        },
                        label = {
                            Text(
                                text = stringResource(id = R.string.publication_description_label_string),
                                style = TextStyle(color = Color.Gray),
                                fontWeight = FontWeight.Bold,
                            )
                        },
                        placeholder = {
                            Text(
                                text = stringResource(id = R.string.publication_description_placeholder_string)
                            )
                        },
                        textStyle = TextStyle.Default.copy(fontSize = 16.sp),
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Done,
                            keyboardType = KeyboardType.Text
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = { focusManager.clearFocus() }
                        ),
                        modifier = Modifier.fillMaxSize(),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = ColorTextField,
                            cursorColor = Color.Black
                        )
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                // Поле для адреса
                OutlinedTextField(
                    value = addressText,
                    onValueChange = { addressText = it },
                    label = {
                        Text(
                            text = stringResource(id = R.string.publication_address_label_string),
                            style = TextStyle(color = Color.Gray),
                            fontWeight = FontWeight.Bold,
                        )
                    },
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.publication_address_placeholder_string)
                        )
                    },
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
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = ColorTextField,
                        cursorColor = Color.Black
                    )
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Поле для номера телефона
                OutlinedTextField(
                    value = numberText,
                    onValueChange = { if (it.length <= maxCharNumber) numberText = it },
                    singleLine = true,
                    label = {
                        Text(
                            text = stringResource(id = R.string.publication_number_label_string),
                            style = TextStyle(color = Color.Gray),
                            fontWeight = FontWeight.Bold,
                        )
                    },
                    visualTransformation = transformer,
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.publication_number_placeholder_string)
                        )
                    },
                    textStyle = TextStyle.Default.copy(fontSize = 16.sp),
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done,
                        keyboardType = KeyboardType.Number
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = ColorTextField,
                        cursorColor = Color.Black
                    )
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                //Кнопка для добавления
                Button(
                    onClick = {
                        if (selectedPhotos != null && titlePublicationText.isNotBlank() && descriptionText.isNotBlank()
                            && addressText.isNotBlank() && numberText.isNotBlank()
                        ) {
                            val publication = AddPublicationEntity(
                                null,
                                titlePublicationText,
                                selectedPhotos.toString(),
                                descriptionText,
                                addressText,
                                numberText,
                            )
                            viewModel.insertData(publication)
                            navController.navigate("all_user_publication")
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
                ) {
                    Text(
                        text = stringResource(id = R.string.publication_button_title_string),
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}