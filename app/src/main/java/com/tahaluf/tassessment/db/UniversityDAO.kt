package com.tahaluf.tassessment.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tahaluf.tassessment.models.University

@Dao
interface UniversityDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUniversities(universities: List<University>)

    @Query("SELECT * FROM universities")
    suspend fun getAllUniversities(): List<University>
}