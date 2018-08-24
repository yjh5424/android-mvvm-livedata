package com.yjh.project.commitprogress.di.app

import android.app.Application
import com.example.yunjunghyeon.demoapp_mvvm.di.module.AppComponent
import com.example.yunjunghyeon.demoapp_mvvm.di.module.AppModule
import com.example.yunjunghyeon.demoapp_mvvm.di.module.DaggerAppComponent
import com.example.yunjunghyeon.demoapp_mvvm.di.module.NetworkModule

class App : Application() {

    companion object {
        //platformStatic allow access it from java code
        @JvmStatic lateinit var component: AppComponent
        val BASE_URL="https://api.github.com/"
        val CLIENT_ID="37bc54f3e519696e6481"
        val CLIENT_SECRET="096479e54c7c370d7aa27b56ec873803e96feb4c"
        val redirect_uri="commitprogress://callback"

    }

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule(BASE_URL))
                .build()
    }
}