package com.moovel.android.coding.challenge.di

import com.moovel.android.coding.challenge.MoovelApp
import com.moovel.android.coding.challenge.di.module.AppModule
import com.moovel.android.coding.challenge.di.module.DataModule
import com.moovel.android.coding.challenge.framework.ui.userdetail.UserDetailActivity
import com.moovel.android.coding.challenge.framework.ui.userlist.UserListActivity
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    DataModule::class,
    AndroidInjectionModule::class]
)
interface AppComponent {
    fun inject(app: MoovelApp)
    fun inject(userListActivity: UserListActivity)
    fun inject(userDetailActivity: UserDetailActivity)
}