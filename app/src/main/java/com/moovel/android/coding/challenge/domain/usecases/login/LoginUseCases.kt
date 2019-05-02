package com.moovel.android.coding.challenge.domain.usecases.login

import com.moovel.android.coding.challenge.network.AccessToken
import retrofit2.Call

interface LoginUseCases {

    fun getAccessToken(clientId : String, secretId : String, code : String): Call<AccessToken>
    fun setAccessToken(accessToken: String)

}