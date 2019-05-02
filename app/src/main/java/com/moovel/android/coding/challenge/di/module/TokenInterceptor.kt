package com.moovel.android.coding.challenge.di.module

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TokenInterceptor @Inject constructor() : Interceptor {
    var token:String=""
    override fun intercept(chain: Interceptor.Chain): Response {

        val original = chain.request()

        val originalHttpUrl = original.url()
        val requestBuilder = original.newBuilder()
                .addHeader("Authorization", "Bearer $token")
                .url(originalHttpUrl)

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}