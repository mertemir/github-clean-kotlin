package com.mertemir.android.coding.challenge.framework.common

import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import com.mertemir.android.coding.challenge.GithubApp
import com.mertemir.android.coding.challenge.di.AppComponent
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity(){

    val appComponent: AppComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (application as GithubApp).appComponent
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


}