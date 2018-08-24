package com.example.yunjunghyeon.demoapp_mvvm.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.yunjunghyeon.demoapp_mvvm.ui.main.MainViewModel
import com.example.yunjunghyeon.demoapp_mvvm.ui.setting.SettingViewModel

class ViewModelFactory : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when(modelClass){
            MainViewModel::class.java-> modelClass as T
            else -> modelClass as T
        }
    }
}