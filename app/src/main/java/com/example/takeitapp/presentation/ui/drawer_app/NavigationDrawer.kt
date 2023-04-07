package com.example.takeitapp.presentation.ui.drawer_app

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.takeitapp.R

@Composable
fun DrawerHeader() {
    Column(modifier = Modifier
        .background(color = Color.LightGray)
        .fillMaxWidth()
        .padding(horizontal = 14.dp, vertical = 8.dp),
    horizontalAlignment = Alignment.Start) {
        Image(
            painter = painterResource(id = R.drawable.ic_drawer_photo),
            contentDescription = "",
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
            .border(shape = CircleShape, border = BorderStroke(1.dp, color = Color.Black)),
        contentScale = ContentScale.Crop)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "User Name", fontSize = 16.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "+7 938-004-14-14", fontSize = 18.sp)
    }
}

@Composable
fun DrawerBody(
    items: List<DrawerMenuItem>,
    modifier: Modifier = Modifier,
    itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
    onItemClick: (DrawerMenuItem) -> Unit
) {
    LazyColumn(modifier) {
        items(items) {item ->  
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemClick(item)
                    }
                    .padding(horizontal = 14.dp, vertical = 8.dp)
            ) {
                Icon(imageVector = item.icon,
                    contentDescription = item.contentDescription)
                Spacer(modifier = Modifier.width(14.dp))
                Text(
                    text = item.title,
                    style = itemTextStyle,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}