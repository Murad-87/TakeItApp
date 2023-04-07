package com.example.takeitapp.presentation.ui.bottom_navigation

import com.example.takeitapp.R

sealed class BottomItem(val title: String, val iconId: Int, val route: String) {
    object HomeScreen : BottomItem("Главная", R.drawable.ic_home, "home_screen")
    object AddScreen : BottomItem("Добавить", R.drawable.ic_add, "add_screen")
    object MyPublicationScreen :
        BottomItem("Мои", R.drawable.ic_my_publication, "all_user_publication")
}
