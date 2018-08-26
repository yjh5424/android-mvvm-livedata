package com.example.yunjunghyeon.demoapp_mvvm.ui.main

import com.example.yunjunghyeon.demoapp_mvvm.base.BaseViewModel
import com.example.yunjunghyeon.demoapp_mvvm.network.UserDataRepositoryImpl
import javax.inject.Inject
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.yunjunghyeon.demoapp_mvvm.domain.model.Person
import com.example.yunjunghyeon.demoapp_mvvm.domain.model.Repo
import com.example.yunjunghyeon.demoapp_mvvm.domain.model.Response
import android.arch.lifecycle.LiveData
import com.example.yunjunghyeon.demoapp_mvvm.domain.model.Status
import io.reactivex.Observable
import com.example.yunjunghyeon.demoapp_mvvm.domain.model.Response.*
import rx.subjects.PublishSubject

class MainViewModel(val repositoryImpl: UserDataRepositoryImpl) : BaseViewModel(){

    val repositoriesOutStream = MutableLiveData<Response<List<Pair<Repo, List<Person>>>>>()

    fun loadRepositories(userName: String) {
        composite.add(repositoryImpl.getRepositories(userName)
                .doOnSubscribe { repositoriesOutStream.value!!.loading()  }
                .subscribe(
                        {
                            repositoriesOutStream.value!!.scuucess(it)
                        },
                        {
                            repositoriesOutStream.value!!.error(it)
                        }
                ))
    }

}