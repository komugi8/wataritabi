package com.example.wataritabi.domain.repository

import com.example.wataritabi.domain.model.ScheduleModel
import kotlinx.coroutines.flow.Flow

interface ScheduleRepository {
    fun getAllSchedule(): Flow<List<ScheduleModel>>

    fun getSchedule(scheduleId: Int): Flow<ScheduleModel?>

    suspend fun insertSchedule(scheduleModel: ScheduleModel)

    suspend fun updateSchedule(scheduleModel: ScheduleModel)

    suspend fun deleteSchedule(scheduleModel: ScheduleModel)
}