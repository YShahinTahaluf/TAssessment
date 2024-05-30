package com.tahaluf.tassessment.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tahaluf.tassessment.Application
import com.tahaluf.tassessment.R
import com.tahaluf.tassessment.databinding.MainActivityBinding
import com.tahaluf.tassessment.db.UniversityDatabase
import com.tahaluf.tassessment.models.University
import com.tahaluf.tassessment.ui.theme.TAssessmentTheme
import com.tahaluf.tassessment.view_models.UniversityViewModel
import com.tahaluf.tassessment.views.adapters.UniversitiesRecyclerAdapter

class MainActivity : ComponentActivity(), UniversitiesRecyclerAdapter.OnItemClickListener {

    private val viewModel: UniversityViewModel by viewModels() { ViewModelProvider.AndroidViewModelFactory.getInstance(application) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: MainActivityBinding = DataBindingUtil.setContentView(this, R.layout.main_activity)

//        val database = (application as Application).universityDatabase

        binding.lifecycleOwner = this


        val adapter = UniversitiesRecyclerAdapter(viewModel, this)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewModel.universities.observe(this, Observer { universities ->
            universities?.let {
                adapter.notifyDataSetChanged()
            }
        })
    }

    override fun onItemClick() {
        Log.v("CLICKTAG", "ITEM CLICKED")
        val intent = Intent(this, UniversityDetailsActivity::class.java)
        intent.putExtra("university", viewModel.selectedUniversity.value)
        startActivity(intent)
    }
}

