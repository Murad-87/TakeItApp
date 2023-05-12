package com.example.takeitapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.feature_home.presentation.homeScreen.HomeViewModel
import com.example.feature_home.presentation.homeScreen.MyHomeScreen
import com.example.feature_home.presentation.publicationDetailsScreen.PublicationDetailsScreen
import com.mytakeitapp.authentication_flow.presentation.loginScreen.LoginScreen
import com.mytakeitapp.authentication_flow.presentation.registrationScreen.RegistrationScreen
import com.mytakeitapp.authentication_flow.presentation.splashScreen.SplashScreenApp
import com.mytakeitapp.feature_add_publication.presentation.addPublicationScreen.AddPublicationScreen
import com.mytakeitapp.feature_add_publication.presentation.addPublicationScreen.AddPublicationViewModel
import com.mytakeitapp.feature_messages.presentation.messagesScreen.MessagesScreen
import com.mytakeitapp.feature_settings.presentation.aboutAppScreen.AboutAppScreen
import com.mytakeitapp.feature_settings.presentation.settingsScreen.UserSettingsScreen
import com.mytakeitapp.feature_user_publication.presentation.allPublicationUserScreen.AllPublicationUserScreen
import com.mytakeitapp.feature_user_publication.presentation.allPublicationUserScreen.AllPublicationUserViewModel
import com.mytakeitapp.feature_user_publication.presentation.userPublicationDetailsScreen.UserPublicationDetailsScreen

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
        composable("home_screen") {
            val viewModel = hiltViewModel<HomeViewModel>()
            MyHomeScreen(navController = navController, viewModel)
        }
        composable("add_screen") {
            val viewModel = hiltViewModel<AddPublicationViewModel>()
            AddPublicationScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable("all_user_publication") {
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