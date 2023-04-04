package com.example.takeitapp.presentation.allPublicationUserScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.takeitapp.domain.model.TakeItEntity

@Composable
fun AllPublicationUserScreen(
    navController: NavController,
    viewModel: AllPublicationUserViewModel
) {

    val observedState by viewModel.allPublicationUser.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (observedState != null) {
            LazyColumn(
                contentPadding = PaddingValues(6.dp)
            ) {
                items(observedState) { item ->
                    ItemPublicationUser(item = item, navController = navController)
                }
            }
        } else {
            Text(text = "У вас еще нет своих публикаций.")
        }
    }
}

@Composable
fun ItemPublicationUser(
    item: TakeItEntity,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(4.dp)
            .clickable {
                navController.navigate("user_publication_details_screen")
            },
        elevation = 2.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
        ) {
            Image(
                painter = rememberAsyncImagePainter(item.imageUrl),
                contentDescription = "",
                modifier = Modifier
                    .background(color = Color.Cyan)
                    .align(Alignment.CenterVertically)
                    .weight(0.5f)
                    .fillMaxSize(1f),
                contentScale = ContentScale.Fit
            )
            Text(
                text = item.title,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .align(Alignment.Top)
                    .weight(0.5f)
            )
        }
    }
}