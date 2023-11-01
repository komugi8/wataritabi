package com.example.wataritabi.view.destination

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wataritabi.navigation.BottomBarScreen
import com.example.wataritabi.viewmodel.MapViewModel
import com.google.android.libraries.places.api.Places

@Composable
fun DestinationScreen(
    navController: NavController,
    mv: MapViewModel,
) {
    val context = LocalContext.current
    val placesClient = Places.createClient(context)
    var query by remember {
        mutableStateOf("")
    }
    Column {
        TextField(
            value = query,
            onValueChange = {
                query = it
                mv.searchPlaces(it, placesClient)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = null
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        LazyColumn {
            items(mv.locationAutofill) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable {
                            mv.addDestination(it)
                            mv.getLocation(it, placesClient)
                            navController.navigate(BottomBarScreen.Map.route)
                        }
                ) {
                    Text(text = it.primaryText)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DestinationScreenPreview() {
    //DestinationScreen()
}