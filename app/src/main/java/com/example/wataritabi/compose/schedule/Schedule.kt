package com.example.wataritabi.compose.schedule

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ScheduleScreen() {
    val events = listOf(
        Event("9:00 AM", "朝のミーティング"),
        Event("10:30 AM", "クライアントとの電話"),
        Event("12:00 PM", "昼食休憩"),
        Event("2:00 PM", "プロジェクトの進捗報告"),
        Event("4:00 PM", "新規プロジェクトの検討"),
        Event("6:00 PM", "帰宅")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "今日の日程",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(8.dp)
        )
        ScheduleList(events = events)
    }
}


@Composable
fun ScheduleList(events: List<Event>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(events) { event ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = event.time)
                    Text(text = event.description)
                }
            }
        }
    }
}


data class Event(val time: String, val description: String)

@Preview
@Composable
fun ScheduleScreenPreview() {
    ScheduleScreen()
}
