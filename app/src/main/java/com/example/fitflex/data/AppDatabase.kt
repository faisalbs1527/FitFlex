package com.example.fitflex.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fitflex.data.dao.WorkoutDao
import com.example.fitflex.domain.model.WorkoutEntity

@Database(
    entities = [WorkoutEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun workoutDao(): WorkoutDao

    companion object {
        operator fun invoke(context: Context) = buildDatabase(context)

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "FitFlex.db"
            ).build()
        }
    }
}