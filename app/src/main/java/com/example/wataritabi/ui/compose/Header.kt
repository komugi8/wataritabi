package com.example.wataritabi.ui.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.East
import androidx.compose.material.icons.rounded.West
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Header(date: String) {
    Row {
        Text(
            text = date,
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        )
        Icon(
            imageVector = Icons.Rounded.West,
            contentDescription = null
        )
        Icon(
            imageVector = Icons.Rounded.East,
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    Header("Saturday 20, May 2023")
}