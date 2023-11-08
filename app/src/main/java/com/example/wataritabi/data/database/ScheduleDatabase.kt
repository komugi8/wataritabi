package com.example.wataritabi.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.wataritabi.data.dao.ScheduleDao
import com.example.wataritabi.domain.model.ScheduleModel

@Database(
    entities = [ScheduleModel::class],
    version = 1,
    exportSchema = false
)
abstract class ScheduleDatabase : RoomDatabase() {
    abstract fun scheduleDao(): ScheduleDao
}