package com.moovel.android.coding.challenge.data

import com.moovel.android.coding.challenge.di.module.TokenInterceptor
import com.moovel.android.coding.challenge.domain.repository.IRepository
import com.moovel.android.coding.challenge.network.AuthenticationApi
import com.moovel.android.coding.challenge.network.GithubApi
import com.moovel.android.coding.challenge.network.UserDetail
import com.moovel.android.coding.challenge.network.UserResponse
import io.reactivex.Single
import javax.inject.Inject

class Repository @Inject constructor(private val authenticationApi: AuthenticationApi, private val githubApi: GithubApi, private val tokenInterceptor: TokenInterceptor) : IRepository{

    override fun getAccessToken(clientId : String, secretId : String, code : String) = authenticationApi.getAccessToken(clientId, secretId, code)

    override fun setAccessToken(accessToken: String) { tokenInterceptor.token=accessToken }

    override fun getUserDetails(name: String): Single<UserDetail> = githubApi.getUserDetails(name)

}