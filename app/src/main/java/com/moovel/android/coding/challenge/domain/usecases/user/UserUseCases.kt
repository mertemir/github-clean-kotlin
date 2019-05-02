package com.moovel.android.coding.challenge.domain.usecases.user

import android.arch.paging.DataSource
import com.moovel.android.coding.challenge.domain.entity.User
import com.moovel.android.coding.challenge.domain.pagination.GithubDataSourceFactory
import io.reactivex.disposables.CompositeDisposable

interface UserUseCases {

    fun getUsers(): GithubDataSourceFactory
}