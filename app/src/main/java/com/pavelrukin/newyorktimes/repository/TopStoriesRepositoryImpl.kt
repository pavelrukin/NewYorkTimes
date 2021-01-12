package com.pavelrukin.newyorktimes.repository

import androidx.lifecycle.MutableLiveData
import com.pavelrukin.newyorktimes.NYTApp
import com.pavelrukin.newyorktimes.api.ApiHelper
import com.pavelrukin.newyorktimes.model.TopStoriesResponse
import com.pavelrukin.newyorktimes.utils.Resources
import com.pavelrukin.newyorktimes.utils.isConnected
import retrofit2.Response
import java.io.IOException


class TopStoriesRepositoryImpl(
    private val app: NYTApp,
    val apiHelper: ApiHelper,
) : TopStoriesRepository {
    private var topStoriesResponse: TopStoriesResponse? = null
    override val topStories: MutableLiveData<Resources<TopStoriesResponse>> = MutableLiveData()



    override suspend fun getTopStories() {
        topStories.postValue(Resources.Loading())
        try {
            if (app.applicationContext.isConnected){
                topStories.postValue(Resources.Loading())
                val response = apiHelper.getTopStories()
                topStories.postValue(handledTopStories(response))
            }else{
                topStories.postValue(Resources.Error("No internet connection"))

            }

        }catch (t:Throwable){
            when(t){
                is IOException -> topStories.postValue(Resources.Error("Network Failure"))
                else -> topStories.postValue(Resources.Error("Conversion Error ${t.localizedMessage}"))
            }
        }
    }

    private fun handledTopStories(response: Response<TopStoriesResponse>): Resources<TopStoriesResponse>? {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                if (topStoriesResponse == null) {
                    topStoriesResponse = resultResponse
                } else {
                    val oldList = topStoriesResponse?.topStoriesResults
                    val newList = resultResponse.topStoriesResults
                    oldList?.addAll(newList)
                }
                return Resources.Success(resultResponse)
            }
        }
        return Resources.Error(response.message())
    }


}