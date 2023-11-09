package com.example.wataritabi.data.repository

import com.example.wataritabi.data.dao.ScheduleDao
import com.example.wataritabi.domain.model.ScheduleModel
import com.example.wataritabi.domain.repository.ScheduleRepository
import kotlinx.coroutines.flow.Flow

class ScheduleRepositoryImpl(
    private val scheduleDao: ScheduleDao,
) : ScheduleRepository {
    override fun getAllSchedule(): Flow<List<ScheduleModel>> = scheduleDao.getAllSchedule()

    override suspend fun getSchedule(scheduleId: Int) =
        scheduleDao.getSchedule(scheduleId)

    override suspend fun insertSchedule(scheduleModel: ScheduleModel) =
        scheduleDao.insertSchedule(scheduleModel)

    override suspend fun updateSchedule(scheduleModel: ScheduleModel) =
        scheduleDao.updateSchedule(scheduleModel)

    override suspend fun deleteSchedule(scheduleModel: ScheduleModel) =
        scheduleDao.deleteSchedule(scheduleModel)
}