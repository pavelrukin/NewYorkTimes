package com.pavelrukin.newyorktimes.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.pavelrukin.newyorktimes.databinding.ItemTopStoriesBinding
import com.pavelrukin.newyorktimes.model.TopStoriesResponse

class TopStoriesAdapter():ListAdapter<TopStoriesResponse.TopStoriesResult,TopStoriesAdapter.TopStoriesViewHolder>(TopStoriesDiffUtilCallBack) {


   inner class TopStoriesViewHolder(private val binding: ItemTopStoriesBinding):RecyclerView.ViewHolder(binding.root) {
fun bindTopStories(topStories:TopStoriesResponse.TopStoriesResult){
    with(topStories){
        binding.apply {
            ivImagePost //todo image post
            tvTitlePost.text = title
        }
    }
}
    }

    override fun onBindViewHolder(holder: TopStoriesViewHolder, position: Int) {
        getItem(position)?.let { holder.bindTopStories(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopStoriesViewHolder {
        val binding = ItemTopStoriesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
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
     return oldItem  == newItem
    }

}
