package com.example.wataritabi.ui.view.schedule

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.wataritabi.domain.model.ScheduleModel
import com.example.wataritabi.ui.viewmodel.ScheduleViewModel

@Composable
fun ScheduleScreen(
    viewModel: ScheduleViewModel = hiltViewModel(),
) {
    val scheduleList = viewModel.scheduleList.collectAsState(
        initial = emptyList()
    )
//    val events = listOf(
//        Event("9:00 AM", "朝のミーティング"),
//        Event("10:30 AM", "クライアントとの電話"),
//        Event("12:00 PM", "昼食休憩"),
//        Event("2:00 PM", "プロジェクトの進捗報告"),
//        Event("4:00 PM", "新規プロジェクトの検討"),
//        Event("6:00 PM", "帰宅")
//    )
//    viewModel.addSchedule(
//        ScheduleModel(
//            0,
//            "hoge",
//            "2023/10/01",
//            "10:00",
//            "東京駅",
//            "東京駅",
//            "東京駅"
//        )
//    )
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "Add"
                )
            }
        }
    ) { padding ->
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
            EventCards(events = scheduleList.value)
        }
    }
}


@Composable
fun EventCards(events: List<ScheduleModel>) {
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
                    Text(text = event.scheduleTime)
                    Text(text = event.scheduleMemo)
                }
            }
        }
    }
}


data class Event(val time: String, val description: String)

@Preview(showBackground = true)
@Composable
fun ScheduleScreenPreview() {
    ScheduleScreen()
}
