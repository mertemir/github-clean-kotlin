package com.mertemir.android.coding.challenge.domain.repository

import com.mertemir.android.coding.challenge.network.AccessToken
import com.mertemir.android.coding.challenge.network.UserDetail
import com.mertemir.android.coding.challenge.network.UserResponse
import io.reactivex.Single
import retrofit2.Call

interface IRepository {

    fun getAccessToken(clientId: String, secretId: String, code: String): Call<AccessToken>

    fun fetchUsers(page : Int, pageSize : Int) : Single<UserResponse>

    fun fetchUserDetails(name : String): Single<UserDetail>

    fun setAccessToken(accessToken: String)

}