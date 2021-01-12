package com.pavelrukin.newyorktimes.api

import com.pavelrukin.newyorktimes.model.TopStoriesResponse
import com.pavelrukin.newyorktimes.utils.Constants
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Query

interface ApiHelper {
    suspend fun getTopStories (): Response<TopStoriesResponse>
}