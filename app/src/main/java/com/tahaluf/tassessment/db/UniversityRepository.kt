package com.tahaluf.tassessment.db

import com.tahaluf.tassessment.models.University
import com.tahaluf.tassessment.retrofit.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call

class UniversityRepository(private val database: UniversityDatabase) {

    suspend fun storeDataToRoom(entities: List<University>)  {
        database.universityDao().insertUniversities(entities)
    }

    suspend fun fetchDataFromRoom(): List<University> {
        return withContext(Dispatchers.IO) {
            database.universityDao().getAllUniversities()
        }
    }
}