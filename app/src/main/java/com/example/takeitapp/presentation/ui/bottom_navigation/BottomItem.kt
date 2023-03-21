package com.example.takeitapp.presentation.ui.bottom_navigation

import com.example.takeitapp.R

sealed class BottomItem(val title: String, val iconId: Int, val route: String) {
    object HomeScreen: BottomItem("Главная", R.drawable.ic_home, "home")
    object AddScreen: BottomItem("Добавить", R.drawable.ic_add, "add")
    object MyPublicationScreen: BottomItem("Мои", R.drawable.ic_my_publication, "my publication")
}
