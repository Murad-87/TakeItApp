package com.mytakeitapp.ui_kit.ui.topbar

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MyTopAppBar(
    title: String,
    titleSize: TextUnit = TextUnit.Unspecified,
    onNavigationItemClick: () -> Unit,
    navController: NavController? = null,
    elevation: Dp = 0.dp,
    backgroundColor: Color = Color(0xFF71E9F8),
) {

    TopAppBar(
        title = {
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxWidth(),
                Alignment.CenterStart
            ) {
                Text(
                    text = title,
                    fontSize = titleSize,
                    color = Color.Black,
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = onNavigationItemClick) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Toggle drawer"
                )
            }
        },
        backgroundColor = backgroundColor,
        contentColor = Color(0xFF000000),
        elevation = elevation,
        actions = {
        }
    )
}