package com.mertemir.android.coding.challenge.framework.ui.login

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.mertemir.android.coding.challenge.domain.usecases.login.LoginUseCases
import com.mertemir.android.coding.challenge.network.AccessToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val loginUseCases: LoginUseCases) : ViewModel(){

    val authorizedLiveData = MutableLiveData<Boolean>()

    fun getAccessToken(clientId: String, secretId : String, code : String) = loginUseCases.getAccessToken(clientId, secretId, code).enqueue(object : Callback<AccessToken> {
        override fun onFailure(call: Call<AccessToken>, t: Throwable) {
            authorizedLiveData.value = false

        }

        override fun onResponse(call: Call<AccessToken>, response: Response<AccessToken>) {
            loginUseCases.setAccessToken(response.body()!!.accessToken)
            authorizedLiveData.value = true
        }

    })
}