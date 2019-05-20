package com.mertemir.android.coding.challenge.domain.usecases.login

import com.mertemir.android.coding.challenge.domain.repository.IRepository
import javax.inject.Inject

class LoginInteractor @Inject constructor(private val repository: IRepository): LoginUseCases {

    override fun getAccessToken(clientId: String, secretId: String, code: String) = repository.getAccessToken(clientId, secretId, code)

    override fun setAccessToken(accessToken: String) = repository.setAccessToken(accessToken)
}