package com.example.takeitapp.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.takeitapp.presentation.ui.bottom_navigation.MyBottomNavigation
import com.example.takeitapp.presentation.ui.bottom_navigation.MyNavGraph

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    var showBottomBar by rememberSaveable { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    showBottomBar = when (navBackStackEntry?.destination?.route) {
        "splash_screen" -> false // on this screen bottom bar should be hidden
        "login_screen" -> false // here too
        "registration_screen" -> false // here too
        "publication_details_screen" -> false // here too
        "user_publication_details_screen" -> false // here too
        else -> true // in all other cases show bottom bar
    }

    Scaffold(
        modifier = modifier,
        bottomBar = {
            if (showBottomBar) MyBottomNavigation(navController = navController)

        }) {innerPadding ->
        MyNavGraph(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}