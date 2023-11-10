package com.example.wataritabi.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wataritabi.domain.model.ScheduleModel

@Composable
fun DayHeader(scheduleModel: ScheduleModel) {
    Card(
        modifier = Modifier
            .padding(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(
                text = scheduleModel.scheduleDate,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}