package com.mytakeitapp.feature_user_publication.presentation.allPublicationUserScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.mytakeitapp.common.utils.MyAlertDialog
import com.mytakeitapp.feature_user_publication.domain.model.UserPublicationEntity
import com.mytakeitapp.ui_kit.R

@Composable
fun AllPublicationUserScreen(
    navController: NavController,
    viewModel: AllPublicationUserViewModel,
) {

    val observedState by viewModel.allPublicationUser.collectAsState()
    val dialogState = remember { mutableStateOf(false) }
    val selectedItem = remember { mutableStateOf<UserPublicationEntity?>(null) }

    if (observedState.isNotEmpty()) {
        LazyColumn(
            contentPadding = PaddingValues(6.dp)
        ) {
            items(observedState) { item ->
                ItemPublicationUser(
                    item,
                    navController,
                    dialogState,
                    selectedItem
                )
            }
        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.all_publication_user_no_publications),
                fontSize = 18.sp
            )
        }
    }

    if (dialogState.value && selectedItem.value != null) {
        MyAlertDialog(
            title = "Удаление",
            message = "Вы действительно хотите удалить эту публикацию?",
            onConfirm = {
                viewModel.deletePublication(selectedItem.value!!)
                selectedItem.value = null
                dialogState.value = false
            },
            onCancel = { dialogState.value = false },
            dialogState = dialogState
        )
    }
}

@Composable
fun ItemPublicationUser(
    item: UserPublicationEntity,
    navController: NavController,
    dialogState: MutableState<Boolean>,
    selectedItem: MutableState<UserPublicationEntity?>
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(4.dp)
            .clickable {
                navController.navigate("user_publication_details_screen")
            },
        elevation = 2.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
        ) {
            Image(
                painter = rememberAsyncImagePainter(item.imageUrl),
                contentDescription = "",
                modifier = Modifier
                    .background(color = Color.Cyan)
                    .align(Alignment.CenterVertically)
                    .weight(0.5f)
                    .fillMaxSize(1f),
                contentScale = ContentScale.Fit
            )
            Text(
                text = item.title,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .align(Alignment.Top)
                    .weight(0.5f)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_for_card_menu),
                contentDescription = "",
                modifier = Modifier.clickable {
                    dialogState.value = true
                    selectedItem.value = item
                }
            )
        }
    }
}