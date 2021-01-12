package com.pavelrukin.newyorktimes.di


import com.pavelrukin.newyorktimes.ui.news.TopStoriesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        TopStoriesViewModel(repository = get())
    }

}