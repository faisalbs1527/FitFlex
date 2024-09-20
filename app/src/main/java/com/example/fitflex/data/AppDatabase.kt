package com.example.fitflex.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.fitflex.data.dao.WorkoutDao
import com.example.fitflex.domain.model.WorkoutEntity
import com.example.fitflex.utils.DummyData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
            ).addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    val dummyData = listOf(
                        DummyData.First,
                        DummyData.Second,
                        DummyData.Third,
                        DummyData.Fourth,
                        DummyData.Fifth
                    )
                    CoroutineScope(Dispatchers.IO).launch {
                        dummyData.forEach { data ->
                            invoke(context).workoutDao().insert(data)
                        }
                    }
                }
            }).build()
        }
    }
}