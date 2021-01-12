package com.pavelrukin.newyorktimes

import android.app.Application
import com.pavelrukin.newyorktimes.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class NYTApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@NYTApp)
            modules(
                apiModule,retrofitModule,repositoryModule,viewModelModule
            )
        }
    }
}