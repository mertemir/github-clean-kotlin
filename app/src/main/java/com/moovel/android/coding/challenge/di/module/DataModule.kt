package com.moovel.android.coding.challenge.di.module

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.moovel.android.coding.challenge.data.Repository
import com.moovel.android.coding.challenge.domain.repository.IRepository
import com.moovel.android.coding.challenge.network.AuthenticationApi
import com.moovel.android.coding.challenge.network.GithubApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import okhttp3.logging.HttpLoggingInterceptor

const val GITHUB_API_ENDPOINT = "https://api.github.com/"

@Module
class DataModule{

    @Singleton
    @Provides
    internal fun provideGson(): Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
    }

    @Singleton
    @Provides
    internal fun provideOkHttpClient(tokenInterceptor: TokenInterceptor): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.HEADERS
        return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(tokenInterceptor)
                .build()
    }

    @Singleton
    @Provides
    internal fun provideGithubApi(gson: Gson, client: OkHttpClient): GithubApi {

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
    internal fun provideAuthenticationApi(client: OkHttpClient): AuthenticationApi {

        val retrofit= Retrofit.Builder()
                .client(client)
                .baseUrl("https://github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit.create(AuthenticationApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(authenticationApi: AuthenticationApi, githubApi: GithubApi, tokenInterceptor: TokenInterceptor) : IRepository = Repository(authenticationApi,githubApi, tokenInterceptor)

}


