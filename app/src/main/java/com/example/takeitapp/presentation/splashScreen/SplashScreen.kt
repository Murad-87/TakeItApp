package com.example.takeitapp.presentation.splashScreen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.takeitapp.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreenApp(navController: NavController) {
    var startAnimate by remember {
        mutableStateOf(false)
    }
    val alphaAnimation = animateFloatAsState(
        targetValue = if (startAnimate) 1f else 0f,
        animationSpec = tween(durationMillis = 2500)
    )
    LaunchedEffect(key1 = true) {
        startAnimate = true
        delay(2500)
        navController.navigate("registration_screen")
    }
    Splash(alpha = alphaAnimation.value)
}

@Composable
fun Splash(alpha: Float) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .size(180.dp)
                .alpha(alpha),
            painter = painterResource(id = R.drawable.ic_take_it),
            contentDescription = null
        )
        Text(
            text = "Забирай это..", fontSize = 26.sp,
            modifier = Modifier.alpha(alpha)
        )
    }
}