package com.mertemir.android.coding.challenge.domain.usecases.login

import com.mertemir.android.coding.challenge.network.AccessToken
import retrofit2.Call

interface LoginUseCases {

    fun getAccessToken(clientId : String, secretId : String, code : String): Call<AccessToken>
    fun setAccessToken(accessToken: String)

}