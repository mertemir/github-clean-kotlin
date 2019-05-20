package com.mertemir.android.coding.challenge.framework.ui.user

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.mertemir.android.coding.challenge.domain.entity.User
import com.mertemir.android.coding.challenge.domain.pagination.GithubDataSource
import com.mertemir.android.coding.challenge.domain.pagination.PaginationState
import com.mertemir.android.coding.challenge.domain.usecases.user.UserUseCases
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

private const val PAGE_SIZE = 10
private const val INITIAL_LOAD_SIZE_HINT = 10

class UserViewModel @Inject constructor(private val userUseCases: UserUseCases) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    lateinit var userList: LiveData<PagedList<User>>

    fun initializeList() {

        val config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(INITIAL_LOAD_SIZE_HINT)
                .setPageSize(PAGE_SIZE)
                .build()

        userList = LivePagedListBuilder<Int,User>(userUseCases.getUsers(), config).build()

    }

    fun getState(): LiveData<PaginationState> = Transformations.switchMap<GithubDataSource,
            PaginationState>(userUseCases.getUsers().githubDataSourceLiveData, GithubDataSource::state)

    fun listIsEmpty(): Boolean {
        return userList.value?.isEmpty() ?: true
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}