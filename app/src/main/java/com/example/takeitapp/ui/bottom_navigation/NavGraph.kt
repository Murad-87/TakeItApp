package com.example.takeitapp.ui.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.takeitapp.presentation.AddPublicationScreen
import com.example.takeitapp.presentation.AllPublicationUserScreen
import com.example.takeitapp.presentation.MyHomeScreen

@Composable
fun MyNavGraph(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = "home") {
        composable("home") {
            MyHomeScreen()
        }
        composable("add") {
            AddPublicationScreen()
        }
        composable("my publication") {
            AllPublicationUserScreen()
        }
    }
}