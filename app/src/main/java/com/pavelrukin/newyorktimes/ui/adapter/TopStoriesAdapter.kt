package com.pavelrukin.newyorktimes.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pavelrukin.newyorktimes.databinding.ItemTopStoriesBinding
import com.pavelrukin.newyorktimes.model.TopStoriesResponse

import com.squareup.picasso.Picasso

class TopStoriesAdapter(private val clickListener: (TopStoriesResponse.TopStoriesResult) -> Unit) :
    ListAdapter<TopStoriesResponse.TopStoriesResult, TopStoriesAdapter.TopStoriesViewHolder>(
        TopStoriesDiffUtilCallBack) {


    inner class TopStoriesViewHolder( val binding: ItemTopStoriesBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: TopStoriesViewHolder, position: Int) {
        val topStories = getItem(position)
        holder.binding.topStories = topStories
        holder.itemView.setOnClickListener { clickListener(topStories) }
        holder.binding.testUrl = topStories.multimedia[1].url
        holder.binding.executePendingBindings()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopStoriesViewHolder {
        val binding =
            ItemTopStoriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TopStoriesViewHolder(binding)
    }
}

object TopStoriesDiffUtilCallBack : DiffUtil.ItemCallback<TopStoriesResponse.TopStoriesResult>() {
    override fun areItemsTheSame(
        oldItem: TopStoriesResponse.TopStoriesResult,
        newItem: TopStoriesResponse.TopStoriesResult,
    ): Boolean {
        return oldItem.url == newItem.url
    }

    override fun areContentsTheSame(
        oldItem: TopStoriesResponse.TopStoriesResult,
        newItem: TopStoriesResponse.TopStoriesResult,
    ): Boolean {
        return oldItem == newItem
    }

}
