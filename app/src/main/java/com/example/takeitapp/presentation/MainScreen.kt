package com.example.takeitapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.takeitapp.presentation.navigation.MyNavGraph
import com.example.takeitapp.presentation.ui.bottom_navigation.MyBottomNavigation
import com.example.takeitapp.presentation.ui.drawer_app.DrawerBody
import com.example.takeitapp.presentation.ui.drawer_app.DrawerHeader
import com.example.takeitapp.presentation.ui.drawer_app.DrawerMenuItem
import com.example.takeitapp.presentation.ui.topbar.MyTopAppBar
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    var showBottomBar by rememberSaveable { mutableStateOf(false) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    var showTopAppBar by rememberSaveable { mutableStateOf(false) }
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    showBottomBar = when (navBackStackEntry?.destination?.route) {
        "home_screen" -> true
        "add_screen" -> true
        "all_user_publication" -> true
        else -> false
    }

    showTopAppBar = when (navBackStackEntry?.destination?.route) {
        "home_screen" -> true
        else -> false
    }

    Scaffold(
        scaffoldState = scaffoldState,
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            DrawerHeader()
            DrawerBody(
                items = listOf(
                    DrawerMenuItem(
                        id = "messages",
                        title = "Сообщения",
                        contentDescription = "Go to screen messages",
                        icon = Icons.Default.Email
                    ),
                    DrawerMenuItem(
                        id = "settings",
                        title = "Настройки",
                        contentDescription = "Переход на экран настроек",
                        icon = Icons.Default.Settings
                    ),
                    DrawerMenuItem(
                        id = "about_app",
                        title = "О приложении",
                        contentDescription = "Информация о приложении",
                        icon = Icons.Default.Info
                    ),
                ),
                onItemClick = {
                    when (it.id) {
                        "settings" -> navController.navigate("user_settings_screen")
                        "about_app" -> navController.navigate("about_app_screen")
                        "messages" -> navController.navigate("messages_screen")
                    }
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                })
        },
        topBar = {
            if (showTopAppBar) MyTopAppBar(
                onNavigationItemClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
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