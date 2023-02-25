package com.example.takeitapp.presentation

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.takeitapp.ui.bottom_navigation.MyBottomNavigation
import com.example.takeitapp.ui.bottom_navigation.MyNavGraph

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            MyBottomNavigation(navController = navController)
        }) {
        MyNavGraph(navHostController = navController)
    }
}