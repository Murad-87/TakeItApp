package com.mytakeitapp.ui_kit.ui.topbar

import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.unit.dp

@Composable
fun MyTopAppBar(
    onNavigationItemClick: () -> Unit
) {

    TopAppBar(
        title = {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                Alignment.CenterStart
            ) {
                Text(text = "Take it")
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
        backgroundColor = Color(0xFF71E9F8),
        contentColor = Color(0xFF000000),
        actions = {
        }
    )
}