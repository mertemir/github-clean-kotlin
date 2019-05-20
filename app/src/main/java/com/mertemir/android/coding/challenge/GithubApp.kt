package com.mertemir.android.coding.challenge

import android.app.Application
import com.mertemir.android.coding.challenge.di.AppComponent
import com.mertemir.android.coding.challenge.di.DaggerAppComponent
import com.mertemir.android.coding.challenge.di.module.AppModule
import com.mertemir.android.coding.challenge.di.module.DataModule

class GithubApp : Application(){

    val appComponent: AppComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerAppComponent
                .builder()
                .appModule(AppModule())
                .dataModule(DataModule())
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        this.injectMembers()
    }

    private fun injectMembers() = appComponent.inject(this)

}