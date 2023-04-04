package com.example.takeitapp.presentation.navigation

sealed class NavigationScreens(val route: String) {
    object SplashScreen : NavigationScreens(route = "splash_screen")
    object LoginScreen : NavigationScreens(route = "login_screen")
    object RegistrationScreen : NavigationScreens(route = "registration_screen")
    object PublicationDetailsScreen : NavigationScreens(route = "publication_details_screen")
    object UserPublicationDetailsScreen : NavigationScreens(route = "user_publication_details_screen")
    object UserSettingsScreen : NavigationScreens(route = "user_settings_screen")
    object AboutAppScreen : NavigationScreens(route = "about_app_screen")
    object MessagesScreen : NavigationScreens(route = "messages_screen")
}
