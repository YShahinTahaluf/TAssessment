package com.tahaluf.tassessment.views.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tahaluf.tassessment.databinding.RowUniversityBinding
import com.tahaluf.tassessment.models.University
import com.tahaluf.tassessment.view_models.UniversityViewModel
import com.tahaluf.tassessment.views.UniversityDetailsActivity

class UniversitiesRecyclerAdapter(
    private val viewModel: UniversityViewModel,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<UniversitiesRecyclerAdapter.UniversityViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RowUniversityBinding.inflate(layoutInflater, parent, false)
        return UniversityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UniversityViewHolder, position: Int) {
        val selectedUniversity = viewModel.universities.value?.get(position)
        selectedUniversity?.let { nonNullUniversity ->
            holder.bind(nonNullUniversity)
            holder.itemView.setOnClickListener {
                viewModel.selectUniversity(nonNullUniversity)
                listener.onItemClick()
            }
        }
    }

    override fun getItemCount(): Int {
        return viewModel.universities.value?.size ?: 0
    }

    class UniversityViewHolder(private val binding: RowUniversityBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(university: University) {
            binding.university = university
            binding.executePendingBindings()
        }
    }

}