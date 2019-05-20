package com.mertemir.android.coding.challenge.domain.pagination

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.PageKeyedDataSource
import com.mertemir.android.coding.challenge.domain.entity.User
import com.mertemir.android.coding.challenge.domain.repository.IRepository
import javax.inject.Inject

class GithubDataSource @Inject constructor(private val repository: IRepository) : PageKeyedDataSource<Int, User>() {

    var state: MutableLiveData<PaginationState> = MutableLiveData()

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, User>) {
        updateState(PaginationState.LOADING)
        repository.fetchUsers(1,params.requestedLoadSize)
                .subscribe(
                        { response ->
                            val users = arrayListOf<User>()
                            response.results.forEachIndexed { index, user ->
                            repository.fetchUserDetails(user.username)
                                    .subscribe(
                                            {users.add(User(user.id.toInt(),user.username,user.avatar_url,it.name,it.email,it.registration_date,it.company,it.location,it.bio,it.followers))
                                                if (index == response.results.size-1)
                                                    callback.onResult(users,null,2)},{updateState(PaginationState.ERROR)}) }
                        },{updateState(PaginationState.ERROR)}
                )

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        updateState(PaginationState.LOADING)
        repository.fetchUsers(params.key,params.requestedLoadSize)
                .subscribe(
                        { response ->
                            val users = arrayListOf<User>()
                            response.results.forEachIndexed { index, user ->
                                repository.fetchUserDetails(user.username)
                                        .subscribe(
                                                {users.add(User(user.id.toInt(),user.username,user.avatar_url,it.name,it.email,it.registration_date,it.company,it.location,it.bio,it.followers))
                                                    if (index == response.results.size-1)
                                                        callback.onResult(users,params.key + 1)},{updateState(PaginationState.ERROR)}) }
                        },{updateState(PaginationState.ERROR)}
                )

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
    }

    private fun updateState(state: PaginationState) {
        this.state.postValue(state)
    }
}