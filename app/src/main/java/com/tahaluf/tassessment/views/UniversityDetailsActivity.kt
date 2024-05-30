package com.tahaluf.tassessment.views

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tahaluf.tassessment.R
import com.tahaluf.tassessment.databinding.ActivityUniversityDetailsBinding
import com.tahaluf.tassessment.models.University
import com.tahaluf.tassessment.view_models.UniversityViewModel
import com.tahaluf.tassessment.views.adapters.StringListAdapter

class UniversityDetailsActivity : ComponentActivity() {

    private val viewModel: UniversityViewModel by viewModels() { ViewModelProvider.AndroidViewModelFactory.getInstance(application) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityUniversityDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_university_details)
        binding.lifecycleOwner = this

        val university: University? = intent.getParcelableExtra("university")
        university?.let {
            binding.university = it

            binding.domainsRecyclerView.layoutManager = LinearLayoutManager(this)
            binding.domainsRecyclerView.adapter = StringListAdapter(it.domains)

            binding.webPagesRecyclerView.layoutManager = LinearLayoutManager(this)
            binding.webPagesRecyclerView.adapter = StringListAdapter(it.webPages)
        }
    }
}