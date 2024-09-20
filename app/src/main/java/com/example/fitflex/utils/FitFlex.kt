package com.example.fitflex.utils

import android.app.Application
import com.example.fitflex.data.AppDatabase
import com.example.fitflex.data.WorkoutRepositoryImpl
import com.example.fitflex.domain.repository.WorkoutRepository
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltAndroidApp
class FitFlex : Application() {
//    override fun onCreate() {
//        super.onCreate()
//
//        val dummyData = listOf(
//            DummyData.First,
//            DummyData.Second,
//            DummyData.Third,
//            DummyData.Fourth,
//            DummyData.Fifth
//        )
//        val repository: WorkoutRepository = WorkoutRepositoryImpl(AppDatabase.invoke(this))
//        CoroutineScope(Dispatchers.IO).launch {
//            dummyData.forEach { data ->
//                println(data)
//                repository.insertDummyData(data)
//            }
//        }
//    }
}