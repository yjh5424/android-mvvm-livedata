package com.example.yunjunghyeon.demoapp_mvvm.network


import com.example.yunjunghyeon.demoapp_mvvm.domain.model.Person
import com.example.yunjunghyeon.demoapp_mvvm.domain.model.Repo
import io.reactivex.Single

interface UserDataRepository{
    fun getUserProfile(userName : String) : Single<Person>
    fun getRepositories(userName: String) : Single<List<Pair<Repo, List<Person>>>>
}