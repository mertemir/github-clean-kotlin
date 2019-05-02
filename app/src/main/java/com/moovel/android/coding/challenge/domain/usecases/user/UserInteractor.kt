package com.moovel.android.coding.challenge.domain.usecases.user

import com.moovel.android.coding.challenge.domain.pagination.GithubDataSourceFactory
import javax.inject.Inject

class UserInteractor @Inject constructor(private val githubDataSourceFactory: GithubDataSourceFactory) : UserUseCases {

    override fun getUsers() = githubDataSourceFactory

}