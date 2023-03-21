package com.example.takeitapp.presentation.allPublicationUserScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.takeitapp.R

@Composable
fun AllPublicationUserScreen() {
    val list = remember {
        List(30) { "Publication ${it + 1}" }.toMutableStateList()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn {
            items(list) { item ->
                ItemPublicationUser(text = item)
            }
        }
    }
}

@Composable
fun ItemPublicationUser(text: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(8.dp),
        elevation = 2.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_simple_publication),
                contentDescription = "",
                modifier = Modifier
                    .background(color = Color.Yellow)
                    .align(Alignment.CenterVertically)
                    .weight(0.5f)
                    .fillMaxSize(1f),
                contentScale = ContentScale.Fit
            )
            Text(
                text = text,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .align(Alignment.Top)
                    .weight(0.5f)
            )
        }
    }
}