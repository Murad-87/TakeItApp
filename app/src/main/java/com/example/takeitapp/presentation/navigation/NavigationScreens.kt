package com.example.takeitapp.presentation.navigation

sealed class NavigationScreens(val route: String) {
    object RegistrationScreen : NavigationScreens("registration_screen")
    object PublicationDetailsScreen : NavigationScreens("publication_details_screen")
    object UserPublicationDetailsScreen : NavigationScreens("user_publication_details_screen")
}
