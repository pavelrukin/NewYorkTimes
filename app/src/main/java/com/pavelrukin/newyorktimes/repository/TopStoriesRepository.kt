package com.pavelrukin.newyorktimes.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingData
import com.pavelrukin.newyorktimes.model.TopStoriesResponse
import com.pavelrukin.newyorktimes.utils.Resources
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface TopStoriesRepository {
    val topStories: MutableLiveData<Resources<TopStoriesResponse>>
    suspend fun getTopStories()
}