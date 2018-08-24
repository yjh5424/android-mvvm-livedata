package com.example.yunjunghyeon.demoapp_mvvm.base

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable


open class BaseViewModel : ViewModel(){

    private val composite = CompositeDisposable()

    override fun onCleared() {
        composite.clear()
        super.onCleared()
    }
}



