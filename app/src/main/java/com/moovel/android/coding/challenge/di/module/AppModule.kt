package com.moovel.android.coding.challenge.di.module

import com.moovel.android.coding.challenge.di.viewmodel.ViewModelModule
import com.moovel.android.coding.challenge.domain.pagination.GithubDataSourceFactory
import com.moovel.android.coding.challenge.domain.repository.IRepository
import com.moovel.android.coding.challenge.domain.usecases.login.LoginInteractor
import com.moovel.android.coding.challenge.domain.usecases.login.LoginUseCases
import com.moovel.android.coding.challenge.domain.usecases.user.UserInteractor
import com.moovel.android.coding.challenge.domain.usecases.user.UserUseCases
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideUserUseCases(githubDataSourceFactory: GithubDataSourceFactory) : UserUseCases = UserInteractor(githubDataSourceFactory)

    @Provides
    @Singleton
    fun provideLoginUseCases(repository: IRepository) : LoginUseCases = LoginInteractor(repository)
}