package com.example.wataritabi.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SCHEDULE_TABLE")
data class ScheduleModel(
    @PrimaryKey(autoGenerate = true)
    val scheduleId: Int = 0,
    val scheduleName: String,
    val scheduleDate: String,
    val scheduleTime: String,
    val schedulePlace: String,
    val scheduleMemo: String,
    val schedulePhoto: String,
)