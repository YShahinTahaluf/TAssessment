package com.tahaluf.tassessment
import android.app.Application
import androidx.room.Room
import com.tahaluf.tassessment.db.UniversityDatabase

class Application : Application() {

    lateinit var universityDatabase: UniversityDatabase

    override fun onCreate() {
        super.onCreate()
        universityDatabase = Room.databaseBuilder(
            applicationContext,
            UniversityDatabase::class.java,
            "university_database"
        ).build()
    }
}