package com.tahaluf.tassessment.view_models

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tahaluf.tassessment.db.UniversityRepository
import com.tahaluf.tassessment.models.University
import com.tahaluf.tassessment.retrofit.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UniversityViewModel(application: Application) : AndroidViewModel(application) {

    val UAE = "United Arab Emirates"

//    private val repository = UniversityRepository(database)

    private val _universities = MutableLiveData<List<University>>()
    val universities: LiveData<List<University>> get() = _universities

    private val _selectedUniversity = MutableLiveData<University>()
    val selectedUniversity: LiveData<University> get() = _selectedUniversity

    init {
        Log.v("ASSEST", " CALLING FETCH.................")
        fetchUniversities()
    }

    fun selectUniversity(university: University) {
        _selectedUniversity.value = university
    }

    fun fetchUniversities() {
        val call: Call<List<University>> = RetrofitClient.api.getUniversities(UAE)
        call.enqueue(object : Callback<List<University>> {
            override fun onResponse(call: Call<List<University>>, response: Response<List<University>>) {
                if (response.isSuccessful) {
                    _universities.postValue(response.body())
                } else {
                    // Handle unsuccessful response
                    Log.e("ASSEST_Error", "Response is not Successful")
                }
            }
            override fun onFailure(call: Call<List<University>>, t: Throwable) {
                // Handle network failure
                Log.e("ASSEST_Error", t.message.toString())
            }
        })
    }
}