package com.pavelrukin.newyorktimes.api

import com.pavelrukin.newyorktimes.model.TopStoriesResponse
import com.pavelrukin.newyorktimes.utils.Constants.Constants.Companion.API_KEY
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface  NewsApi {
    @GET("svc/topstories/v2/home.json")
    suspend fun getTopStories (
        @Query("api-key")
        key: String = API_KEY
    ): Response<TopStoriesResponse>
}
