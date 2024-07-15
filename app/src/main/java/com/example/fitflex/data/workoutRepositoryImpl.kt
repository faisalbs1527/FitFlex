package com.example.fitflex.data

import com.example.fitflex.domain.model.WorkoutEntity
import com.example.fitflex.domain.repository.WorkoutRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WorkoutRepositoryImpl @Inject constructor(
    private val db: AppDatabase
) : WorkoutRepository {
    override suspend fun getWorkouts(): List<WorkoutEntity> = withContext(Dispatchers.IO) {
        return@withContext db.workoutDao().getWorkouts()
    }

    override suspend fun insertDummyData(workoutEntity: WorkoutEntity) =
        withContext(Dispatchers.IO) {
            db.workoutDao().insert(workoutEntity)
        }
}