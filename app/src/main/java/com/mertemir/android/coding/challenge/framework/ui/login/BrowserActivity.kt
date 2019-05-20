package com.mertemir.android.coding.challenge.framework.ui.login

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import com.mertemir.android.coding.challenge.framework.common.BaseActivity
import com.mertemir.android.coding.challenge.framework.ui.user.UserListActivity

class BrowserActivity : BaseActivity() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appComponent.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)
        observeViewModel()

        val uri = intent.data

        if (uri != null && uri.toString().startsWith(LoginActivity.REDIRECT_URI))
        {
            val code = uri.getQueryParameter("code")
            viewModel.getAccessToken(LoginActivity.CLIENT_ID, LoginActivity.CLIENT_SECRET, code)

        }
    }

    private fun observeViewModel() {
        viewModel.authorizedLiveData.observe(this, Observer {
            if (it==true)
            {
                finish()
                startActivity(Intent(this, UserListActivity::class.java))
            }
        })

    }
}
