package com.example.fitflex.presentation.home

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
class HomeViewModel @Inject constructor(
    private val repository: WorkoutRepository
) : ViewModel() {
    private val _workoutList = MutableStateFlow<List<WorkoutEntity>>(emptyList())
    val workoutList: StateFlow<List<WorkoutEntity>> = _workoutList

    fun getWorkouts() = viewModelScope.launch {
        _workoutList.value = repository.getWorkouts()
    }
}