package com.pavelrukin.newyorktimes.repository

import androidx.lifecycle.MutableLiveData
import com.pavelrukin.newyorktimes.model.TopStoriesResponse
import com.pavelrukin.newyorktimes.utils.Resources

interface TopStoriesRepository {
    val topStories: MutableLiveData<Resources<TopStoriesResponse>>
    suspend fun getTopStories()
}