package com.santiagolozada.themovies.di

import com.santiagolozada.themovies.BuildConfig
import com.santiagolozada.themovies.data.network.ServiceApi
import com.santiagolozada.themovies.data.network.ServicesManager
import org.koin.dsl.module

val apiModule = module {
    factory { ServicesManager.getInstance(BuildConfig.API_URL).create(ServiceApi::class.java) }
}