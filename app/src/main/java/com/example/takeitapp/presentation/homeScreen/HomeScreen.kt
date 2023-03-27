package com.example.takeitapp.presentation.homeScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.takeitapp.R


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyHomeScreen() {
    val list = remember {
        List(42) { "Publication ${it + 1}" }.toMutableStateList()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            //.background(color = Color.Red)
    ) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(count = 2),
            contentPadding = PaddingValues(6.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(list) { item ->
                ItemPublication(text = item)
            }
        }
    }
}

@Composable
fun ItemPublication(text: String) {
    Card(
        modifier = Modifier
            .size(150.dp)
            .padding(4.dp),
        elevation = 2.dp
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(R.drawable.ic_simple_publication),
                contentDescription = "",
                modifier = Modifier
                    .background(color = Color.Cyan)
                    .weight(1f)
                    .fillMaxSize(1f),
                contentScale = ContentScale.Fit
            )
            Text(text = text, fontSize = 16.sp)
        }
    }
}