package com.example.androidmviexample

import android.app.Application
import com.example.androidmviexample.di.appModule
import com.example.androidmviexample.storage.di.storageModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class AndroidMVIExampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AndroidMVIExampleApplication)
            modules(appModule, storageModule)
        }
    }
}
