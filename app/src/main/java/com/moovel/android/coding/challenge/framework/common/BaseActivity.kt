package com.moovel.android.coding.challenge.framework.common

import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import com.moovel.android.coding.challenge.MoovelApp
import com.moovel.android.coding.challenge.di.AppComponent
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity(){

    val appComponent: AppComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (application as MoovelApp).appComponent
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


}