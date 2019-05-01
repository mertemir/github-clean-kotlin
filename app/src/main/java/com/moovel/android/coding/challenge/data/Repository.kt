package com.moovel.android.coding.challenge.data

import com.moovel.android.coding.challenge.data.local.UserDao
import com.moovel.android.coding.challenge.domain.repository.IRepository
import com.moovel.android.coding.challenge.network.GithubApi
import com.moovel.android.coding.challenge.network.UserDetail
import com.moovel.android.coding.challenge.network.UserResponse
import io.reactivex.Single
import javax.inject.Inject

class Repository @Inject constructor(private val githubApi: GithubApi, private val userDao: UserDao) : IRepository{

    override fun getUsers(page: Int): Single<UserResponse> = githubApi.getUsers(page)

    override fun getUserDetails(name: String): Single<UserDetail> = githubApi.getUserDetails(name)

}