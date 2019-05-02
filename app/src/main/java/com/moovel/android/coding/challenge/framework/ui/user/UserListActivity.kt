package com.moovel.android.coding.challenge.framework.ui.user

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.moovel.android.coding.challenge.R
import com.moovel.android.coding.challenge.domain.pagination.PaginationState
import com.moovel.android.coding.challenge.framework.common.BaseActivity
import com.moovel.android.coding.challenge.framework.adapter.UserListAdapter
import kotlinx.android.synthetic.main.activity_user_list.*

class UserListActivity : BaseActivity() {

    private lateinit var viewModel: UserViewModel
    private val userListAdapter = UserListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)

        setContentView(R.layout.activity_user_list)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(UserViewModel::class.java)
        initializeAdapter()
    }

    private fun initializeAdapter() {
        userList.layoutManager = LinearLayoutManager(this)
        userList.adapter = userListAdapter
        viewModel.initializeList()
        viewModel.userList.observe(this, Observer { userListAdapter.submitList(it) })
        viewModel.getState().observe(this, Observer { state ->
            progress_bar.visibility = if (viewModel.listIsEmpty() && state == PaginationState.LOADING) View.VISIBLE else View.GONE
            if (!viewModel.listIsEmpty()) {
                userListAdapter.setState(state ?: PaginationState.DONE)
            }
        })
    }

}
