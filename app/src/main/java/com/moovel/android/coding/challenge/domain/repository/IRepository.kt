package com.moovel.android.coding.challenge.domain.repository

import com.moovel.android.coding.challenge.network.User
import com.moovel.android.coding.challenge.network.UserDetail
import com.moovel.android.coding.challenge.network.UserResponse
import io.reactivex.Single

interface IRepository {

    fun getUsers(page : Int): Single<UserResponse>

    fun getUserDetails(name : String): Single<UserDetail>

}