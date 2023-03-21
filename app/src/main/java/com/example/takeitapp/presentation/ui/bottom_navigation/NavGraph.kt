package com.example.takeitapp.presentation.ui.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.takeitapp.domain.model.TakeItEntity
import com.example.takeitapp.presentation.addPublicationScreen.AddPublicationScreen
import com.example.takeitapp.presentation.allPublicationUserScreen.AllPublicationUserScreen
import com.example.takeitapp.presentation.homeScreen.MyHomeScreen

@Composable
fun MyNavGraph(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = "home") {
        composable("home") {
            MyHomeScreen()
        }
        composable("add") {
            AddPublicationScreen(
                TakeItEntity(
                    publicationId = 0,
                    title = "",
                    imageUrl = "",
                    description = "",
                    address = "",
                    number = ""
                )
            )
        }
        composable("my publication") {
            AllPublicationUserScreen()
        }
    }
}