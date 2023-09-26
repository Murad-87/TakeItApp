package com.example.feature_home.presentation.publicationDetailsScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PublicationDetailsScreen() {

    Scaffold (
        modifier = Modifier
    ) {innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding )
                .padding(horizontal = 10.dp, vertical = 8.dp)
        ) {
            Text(text = "Здесь будет детальная информация о публикации", fontSize = 20.sp)
        }
    }
}