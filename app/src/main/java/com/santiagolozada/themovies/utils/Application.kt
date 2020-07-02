package com.santiagolozada.themovies.utils

import com.santiagolozada.themovies.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class Application: android.app.Application() {
    private val listModulesKoin = listOf(
        apiModule,
        repositoryModule,
        useCaseModule,
        viewModelModule,
        dbModule
    )

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@Application)
            modules(listModulesKoin)
        }
    }

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }
}