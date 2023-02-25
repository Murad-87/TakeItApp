package com.example.takeitapp.ui.bottom_navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun MyBottomNavigation(
    navController: NavController
) {
    val listItems = listOf(
        BottomItem.HomeScreen,
        BottomItem.AddScreen,
        BottomItem.MyPublicationScreen
    )
    BottomNavigation(backgroundColor = Color.White) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRout = backStackEntry?.destination?.route
        listItems.forEach { item ->
            BottomNavigationItem(
                selected = currentRout == item.route,
                onClick = {
                          navController.navigate(item.route)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconId),
                        contentDescription = "Icon home"
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 9.sp
                    )
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Gray
            )
        }
    }
}