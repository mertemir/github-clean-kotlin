package com.mertemir.android.coding.challenge.domain.usecases.user

import com.mertemir.android.coding.challenge.domain.pagination.GithubDataSourceFactory

interface UserUseCases {

    fun getUsers(): GithubDataSourceFactory
}