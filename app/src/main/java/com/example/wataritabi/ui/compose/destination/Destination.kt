package com.example.wataritabi.ui.compose.destination

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DestinationScreen() {
    var text by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("destination") },
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Row {
            Button(
                onClick = {},
                modifier = Modifier.padding(end = 16.dp)
            ) {
                Text(text = "add")
            }
            FilledTonalButton(onClick = {}) {
                Text(text = "cancel")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DestinationScreenPreview() {
    DestinationScreen()
}