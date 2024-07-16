package com.example.fitflex.presentation.workout.play

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitflex.domain.model.WorkoutEntity
import com.example.fitflex.domain.repository.WorkoutRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayWorkoutViewModel @Inject constructor(
    private val repository: WorkoutRepository
) : ViewModel() {
    private val _workoutData = MutableStateFlow<WorkoutEntity?>(null)
    val workoutData: StateFlow<WorkoutEntity?> = _workoutData

    val _remainingTime = MutableStateFlow<Int>(0)
    val _remainingAmount = MutableStateFlow<Int>(0)

    var workout = MutableStateFlow<WorkoutEntity?>(null)

    fun getWorkout(id: Int) = viewModelScope.launch {
        _workoutData.value = repository.getWorkoutById(id)
        workout.value = _workoutData.value
    }

    fun updateWorkout() = viewModelScope.launch {
        workout.value?.remAmount = _remainingAmount.value
        workout.value?.remDuration = _remainingTime.value
        workout.value?.let { repository.updateWorkout(it) }
    }
}