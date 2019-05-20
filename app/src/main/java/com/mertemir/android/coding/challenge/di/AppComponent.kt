package com.mertemir.android.coding.challenge.di

import com.mertemir.android.coding.challenge.GithubApp
import com.mertemir.android.coding.challenge.di.module.AppModule
import com.mertemir.android.coding.challenge.di.module.DataModule
import com.mertemir.android.coding.challenge.framework.ui.login.BrowserActivity
import com.mertemir.android.coding.challenge.framework.ui.login.LoginActivity
import com.mertemir.android.coding.challenge.framework.ui.user.UserDetailActivity
import com.mertemir.android.coding.challenge.framework.ui.user.UserListActivity
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
    fun inject(app: GithubApp)
    fun inject(userListActivity: UserListActivity)
    fun inject(userDetailActivity: UserDetailActivity)
    fun inject(loginActivity: LoginActivity)
    fun inject(browserActivity: BrowserActivity)
}