package com.pavelrukin.newyorktimes.api

import com.pavelrukin.newyorktimes.model.TopStoriesResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response

class ApiHelperImpl(private val api: NewsApi):ApiHelper {
    override suspend fun getTopStories(): Response<TopStoriesResponse> = api.getTopStories()
}