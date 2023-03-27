package com.example.takeitapp.utils

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun GuestDialog(
    dialogState: MutableState<Boolean>,
    navController: NavController
) {
    AlertDialog(onDismissRequest = {
        dialogState.value = false
    },
        confirmButton = {
            TextButton(onClick = {
                dialogState.value = false
                navController.navigate("home")
            }) {
                Text(
                    text = "Продолжить",
                    style = TextStyle(color = Color.Black),
                    fontSize = 16.sp
                )
            }
        },
        dismissButton = {
            TextButton(onClick = {
                dialogState.value = false
            }) {
                Text(
                    text = "Отмена",
                    style = TextStyle(color = Color.Black),
                    fontSize = 16.sp
                )
            }
        },
        title = {
            Text(
                text = "Без регистрации",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
        },
        text = {
            Text(
                text = "Вы не сможете выкладывать свои публикации",
                style = TextStyle(color = Color.Black)
            )
        }
    )
}