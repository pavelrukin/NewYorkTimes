package com.pavelrukin.newyorktimes.di



import com.pavelrukin.newyorktimes.NYTApp
import com.pavelrukin.newyorktimes.api.ApiHelper
import com.pavelrukin.newyorktimes.api.ApiHelperImpl
import com.pavelrukin.newyorktimes.repository.TopStoriesRepository
import com.pavelrukin.newyorktimes.repository.TopStoriesRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    single <TopStoriesRepository>{ TopStoriesRepositoryImpl( app = androidContext() as NYTApp,apiHelper = get())}
  //  single { TopStoriesRemoteMediator(service = get(),database = get()) }
    single<ApiHelper>{ApiHelperImpl(api = get())}
}
