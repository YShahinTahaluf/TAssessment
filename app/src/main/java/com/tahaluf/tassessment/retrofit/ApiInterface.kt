package com.tahaluf.tassessment.retrofit

import com.tahaluf.tassessment.models.University
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("search")
    fun getUniversities(@Query("country") country : String) : Call<List<University>>
}