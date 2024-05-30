package com.tahaluf.tassessment.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tahaluf.tassessment.models.University

@Database(entities = [University::class], version = 1)
abstract class UniversityDatabase : RoomDatabase() {
    abstract fun universityDao(): UniversityDAO
}