package com.example.takeitapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.takeitapp.presentation.navigation.MyNavGraph
import com.example.takeitapp.presentation.ui.bottom_navigation.MyBottomNavigation
import com.example.takeitapp.presentation.ui.topbar.MyTopAppBar

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    var showBottomBar by rememberSaveable { mutableStateOf(false) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    var showTopAppBar by rememberSaveable { mutableStateOf(false) }

    showBottomBar = when (navBackStackEntry?.destination?.route) {
        "home" -> true
        "add" -> true
        "my publication" -> true
        else -> false
    }

//    showBottomBar = when (navBackStackEntry?.destination?.route) {
//        "splash_screen" -> false // on this screen bottom bar should be hidden
//        "login_screen" -> false // here too
//        "registration_screen" -> false // here too
//        "publication_details_screen" -> false // here too
//        "user_publication_details_screen" -> false // here too
//        else -> true // in all other cases show bottom bar
//         TODO этот вариант не подходит, так как при запуске мерцает и bottomNavView
//         TODO и TopAppBar
//    }

    showTopAppBar = when (navBackStackEntry?.destination?.route) {
        "home" -> true
        else -> false
    }

    Scaffold(
        topBar = {
            if (showTopAppBar) MyTopAppBar()
        },
        bottomBar = {
            if (showBottomBar) MyBottomNavigation(navController = navController)

        }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = innerPadding)
        ) {
            MyNavGraph(
                navController = navController,
            )
        }
    }
}