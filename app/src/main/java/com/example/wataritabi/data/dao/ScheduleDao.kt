package com.example.wataritabi.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.wataritabi.domain.model.ScheduleModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ScheduleDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSchedule(schedule: ScheduleModel)

    @Update
    suspend fun updateSchedule(schedule: ScheduleModel)

    @Delete
    suspend fun deleteSchedule(schedule: ScheduleModel)

    @Query("SELECT * FROM schedule_table ORDER BY scheduleTime ASC")
    fun getAllSchedule(): Flow<List<ScheduleModel>>

    @Query("SELECT * FROM schedule_table WHERE scheduleId = :scheduleId")
    fun getSchedule(scheduleId: Int): Flow<ScheduleModel>
}