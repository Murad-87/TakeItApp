package com.example.takeitapp.presentation.homeScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.takeitapp.domain.model.TestMoviesEntity


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyHomeScreen(
    navController: NavController,
    viewModel: HomeViewModel
) {

    val observedState by viewModel.allMovies.collectAsState()

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
            items(observedState.take(30)) { item ->
                ItemPublication(item = item, navController = navController)
            }
        }
    }
}

@Composable
fun ItemPublication(
    item: TestMoviesEntity,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .size(200.dp)
            .padding(4.dp)
            .clickable {
                // TODO реализовать переход на детальный экран
            },
        elevation = 2.dp
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.background(color = Color.LightGray)
        ) {
            Image(
                painter = rememberAsyncImagePainter(item.image?.medium),
                contentDescription = "",
                modifier = Modifier
                    .background(color = Color.Cyan)
                    .fillMaxSize()
                    .weight(1f),
                contentScale = ContentScale.FillBounds
            )
            item.name?.let {
                Text(
                    text = it,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(2.dp)
                )
            }
        }
    }
}