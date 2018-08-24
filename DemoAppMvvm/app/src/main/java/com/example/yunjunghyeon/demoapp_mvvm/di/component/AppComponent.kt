package com.example.yunjunghyeon.demoapp_mvvm.di.module

import com.yjh.project.commitprogress.di.app.App
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        modules = [(AppModule::class),(NetworkModule::class)]
)
interface AppComponent{

}