package com.moovel.android.coding.challenge.framework.ui.userlist

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.moovel.android.coding.challenge.R
import com.moovel.android.coding.challenge.framework.common.BaseActivity
import com.moovel.android.coding.challenge.framework.ui.UserViewModel

class UserListActivity : BaseActivity() {

    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)

        setContentView(R.layout.activity_user_list)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(UserViewModel::class.java)

    }
}
