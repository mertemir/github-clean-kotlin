package com.moovel.android.coding.challenge.domain.pagination

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import com.moovel.android.coding.challenge.domain.entity.User
import javax.inject.Inject

class GithubDataSourceFactory @Inject constructor(private val dataSource: GithubDataSource) : DataSource.Factory<Int, User>(){

    val githubDataSourceLiveData = MutableLiveData<GithubDataSource>()

    override fun create(): DataSource<Int, User> {
        githubDataSourceLiveData.postValue(dataSource)
        return dataSource
    }

}