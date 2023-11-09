package com.example.wataritabi.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wataritabi.domain.model.ScheduleModel
import com.example.wataritabi.domain.repository.ScheduleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val scheduleRepository: ScheduleRepository,
) : ViewModel() {
    val scheduleList = scheduleRepository.getAllSchedule()

    var schedule by mutableStateOf(ScheduleModel(0, "", "", "", "", "", ""))
        private set

    fun getSchedule(scheduleId: Int) = viewModelScope.launch {
        schedule = scheduleRepository.getSchedule(scheduleId)
    }

    fun addSchedule(scheduleModel: ScheduleModel) = viewModelScope.launch {
        scheduleRepository.insertSchedule(scheduleModel)
    }

    fun updateSchedule(scheduleModel: ScheduleModel) = viewModelScope.launch {
        scheduleRepository.updateSchedule(scheduleModel)
    }

    fun deleteSchedule(scheduleModel: ScheduleModel) = viewModelScope.launch {
        scheduleRepository.deleteSchedule(scheduleModel)
    }
}