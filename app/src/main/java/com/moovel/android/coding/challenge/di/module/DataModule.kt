package com.moovel.android.coding.challenge.di.module

import android.arch.persistence.room.Room
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.moovel.android.coding.challenge.MoovelApp
import com.moovel.android.coding.challenge.data.local.UserDao
import com.moovel.android.coding.challenge.data.local.UserDatabase
import com.moovel.android.coding.challenge.network.GithubApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

const val GITHUB_API_ENDPOINT = "https://api.github.com/"

@Module
class DataModule(private val moovelApp : MoovelApp){

    @Singleton
    @Provides
    internal fun provideGson(): Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
    }

    @Singleton
    @Provides
    internal fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Singleton
    @Provides
    internal fun provideMovieApi(gson: Gson, client: OkHttpClient): GithubApi {

        val retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl(GITHUB_API_ENDPOINT)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        return retrofit.create(GithubApi::class.java)
    }

    @Singleton
    @Provides
    fun provideUserDatabase() : UserDatabase = Room.databaseBuilder(moovelApp, UserDatabase::class.java, "User-DB").allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun provideUserDao(userDatabase: UserDatabase): UserDao = userDatabase.getUserDao()

}


