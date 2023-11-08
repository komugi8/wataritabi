package com.example.wataritabi.di

import android.content.Context
import androidx.room.Room
import com.example.wataritabi.data.dao.ScheduleDao
import com.example.wataritabi.data.database.ScheduleDatabase
import com.example.wataritabi.data.repository.ScheduleRepositoryImpl
import com.example.wataritabi.domain.repository.ScheduleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ScheduleProvider {
    @Provides
    fun provideScheduleDb(
        @ApplicationContext context: Context,
    ) = Room.databaseBuilder(
        context,
        ScheduleDatabase::class.java,
        "SCHEDULE_DATABASE"
    ).build()

    @Provides
    fun provideScheduleDao(
        db: ScheduleDatabase,
    ) = db.scheduleDao()

    @Provides
    fun provideScheduleRepository(
        scheduleDao: ScheduleDao,
    ): ScheduleRepository = ScheduleRepositoryImpl(
        scheduleDao = scheduleDao
    )
}