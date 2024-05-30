package com.tahaluf.tassessment.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tahaluf.tassessment.databinding.ItemStringBinding

class StringListAdapter(private val items: List<String>) :
    RecyclerView.Adapter<StringListAdapter.StringViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemStringBinding.inflate(inflater, parent, false)
        return StringViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class StringViewHolder(private val binding: ItemStringBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.text = item
            binding.executePendingBindings()
        }
    }
}