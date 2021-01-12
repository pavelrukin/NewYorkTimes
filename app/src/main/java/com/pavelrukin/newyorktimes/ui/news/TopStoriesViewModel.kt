package com.pavelrukin.newyorktimes.ui.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavelrukin.newyorktimes.model.TopStoriesResponse

import com.pavelrukin.newyorktimes.repository.TopStoriesRepository
import com.pavelrukin.newyorktimes.utils.Resources
import kotlinx.coroutines.launch

class TopStoriesViewModel(val repository: TopStoriesRepository) : ViewModel() {
init {
    getTopStories()
}
    val topStories: MutableLiveData<Resources<TopStoriesResponse>> = repository.topStories

    fun getTopStories() = viewModelScope.launch {
        repository.getTopStories()
    }
}