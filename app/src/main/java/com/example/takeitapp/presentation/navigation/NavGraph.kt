package com.example.takeitapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.takeitapp.presentation.aboutAppScreen.AboutAppScreen
import com.example.takeitapp.presentation.addPublicationScreen.AddPublicationScreen
import com.example.takeitapp.presentation.addPublicationScreen.AddPublicationViewModel
import com.example.takeitapp.presentation.allPublicationUserScreen.AllPublicationUserScreen
import com.example.takeitapp.presentation.allPublicationUserScreen.AllPublicationUserViewModel
import com.example.takeitapp.presentation.homeScreen.HomeViewModel
import com.example.takeitapp.presentation.homeScreen.MyHomeScreen
import com.example.takeitapp.presentation.loginScreen.LoginScreen
import com.example.takeitapp.presentation.messagesScreen.MessagesScreen
import com.example.takeitapp.presentation.publicationDetailsScreen.PublicationDetailsScreen
import com.example.takeitapp.presentation.registrationScreen.RegistrationScreen
import com.example.takeitapp.presentation.settingsScreen.UserSettingsScreen
import com.example.takeitapp.presentation.splashScreen.SplashScreenApp
import com.example.takeitapp.presentation.userPublicationDetailsScreen.UserPublicationDetailsScreen

@Composable
fun MyNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = NavigationScreens.SplashScreen.route
    ) {
        composable(route = NavigationScreens.SplashScreen.route) {
            SplashScreenApp(navController = navController)
        }
        composable("home") {
            val viewModel = hiltViewModel<HomeViewModel>()
            MyHomeScreen(navController = navController, viewModel)
        }
        composable("add") {
            val viewModel = hiltViewModel<AddPublicationViewModel>()
            AddPublicationScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable("my publication") {
            val viewModel = hiltViewModel<AllPublicationUserViewModel>()
            AllPublicationUserScreen(navController = navController, viewModel)
        }
        composable(route = NavigationScreens.RegistrationScreen.route) {
            RegistrationScreen(navController = navController)
        }
        composable(route = NavigationScreens.LoginScreen.route) {
            LoginScreen()
        }
        composable(route = NavigationScreens.PublicationDetailsScreen.route) {
            PublicationDetailsScreen()
        }
        composable(route = NavigationScreens.UserPublicationDetailsScreen.route) {
            UserPublicationDetailsScreen()
        }
        composable(route = NavigationScreens.UserSettingsScreen.route) {
            UserSettingsScreen()
        }
        composable(route = NavigationScreens.AboutAppScreen.route) {
            AboutAppScreen()
        }
        composable(route = NavigationScreens.MessagesScreen.route) {
            MessagesScreen()
        }
    }
}