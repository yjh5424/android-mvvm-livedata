package com.example.yunjunghyeon.demoapp_mvvm.network


import com.example.yunjunghyeon.demoapp_mvvm.domain.model.AccessToken
import io.reactivex.Single
import javax.inject.Inject

class UserTokenUseCase constructor(@Inject val githubTokenApiClient: GithubTokenApiClient) : UserTokenRepository {

    override fun getAccessToken(clientId : String,clientSecret : String,code : String,redirectUri : String,state : String) : Single<AccessToken> = githubTokenApiClient.getAccessToken(
            clientId,
            clientSecret,
            code,
            redirectUri,
            state
    )
}