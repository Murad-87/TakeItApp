package com.example.takeitapp.presentation.ui.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.takeitapp.domain.model.TakeItEntity
import com.example.takeitapp.presentation.addPublicationScreen.AddPublicationScreen
import com.example.takeitapp.presentation.addPublicationScreen.AddPublicationViewModel
import com.example.takeitapp.presentation.allPublicationUserScreen.AllPublicationUserScreen
import com.example.takeitapp.presentation.homeScreen.MyHomeScreen
import com.example.takeitapp.presentation.navigation.NavigationScreens
import com.example.takeitapp.presentation.registrationScreen.RegistrationScreen
import com.example.takeitapp.presentation.splashScreen.SplashScreenApp

@Composable
fun MyNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = NavigationScreens.SplashScreen.route
    ) {
        composable(route = NavigationScreens.SplashScreen.route) {
            SplashScreenApp(navController = navController)
        }
        composable("home") {
            MyHomeScreen()
        }
        composable("add") {
            val viewModel = hiltViewModel<AddPublicationViewModel>()
            AddPublicationScreen(
                TakeItEntity(
                    publicationId = 0,
                    title = "",
                    imageUrl = "",
                    description = "",
                    address = "",
                    number = ""
                ),
                viewModel = viewModel
            )
        }
        composable("my publication") {
            AllPublicationUserScreen()
        }
        composable(route = NavigationScreens.RegistrationScreen.route) {
            RegistrationScreen(navController = navController)
        }
        composable(route = NavigationScreens.LoginScreen.route) {

        }
        composable(route = NavigationScreens.PublicationDetailsScreen.route) {

        }
        composable(route = NavigationScreens.UserPublicationDetailsScreen.route) {

        }
    }
}