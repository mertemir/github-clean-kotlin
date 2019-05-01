package com.moovel.android.coding.challenge

import android.app.Application
import com.moovel.android.coding.challenge.di.AppComponent
import com.moovel.android.coding.challenge.di.DaggerAppComponent
import com.moovel.android.coding.challenge.di.module.AppModule
import com.moovel.android.coding.challenge.di.module.DataModule

class MoovelApp : Application(){

    val appComponent: AppComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerAppComponent
                .builder()
                .appModule(AppModule())
                .dataModule(DataModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        this.injectMembers()
    }

    private fun injectMembers() = appComponent.inject(this)

}