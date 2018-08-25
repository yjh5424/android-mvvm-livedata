package com.example.yunjunghyeon.demoapp_mvvm.ui.main

import com.example.yunjunghyeon.demoapp_mvvm.base.BaseViewModel
import com.example.yunjunghyeon.demoapp_mvvm.network.UserDataRepositoryImpl
import javax.inject.Inject
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.yunjunghyeon.demoapp_mvvm.domain.model.Person
import com.example.yunjunghyeon.demoapp_mvvm.domain.model.Repo
import com.example.yunjunghyeon.demoapp_mvvm.domain.model.Response
import com.example.yunjunghyeon.demoapp_mvvm.domain.model.Status
import io.reactivex.Observable
import com.example.yunjunghyeon.demoapp_mvvm.domain.model.Response.*

class MainViewModel(val repositoryImpl: UserDataRepositoryImpl) : BaseViewModel(){
    val response = MutableLiveData<Response<List<Pair<Repo, List<Person>>>>>()

    fun loadRepositories(userName: String) :  MutableLiveData<Response<List<Pair<Repo, List<Person>>>>> {
        repositoryImpl.getRepositories(userName)
                .doOnSubscribe { response.value!!.loading()  }
                .subscribe(
                        {
                            response.value!!.scuucess(it)
                        },
                        {
                            response.value!!.error(it)
                        }
                )

        return response
    }

}