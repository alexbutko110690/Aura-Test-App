package com.abutsko.auratestapp

import android.app.Application
import android.os.StrictMode
import com.abutsko.auratestapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            StrictMode.enableDefaults()
            System.setProperty("kotlinx.coroutines.debug", "on")
        }

        startKoin {
            androidLogger()
            androidContext(androidContext = this@App)

            modules(
                appModule
            )
        }
    }
}