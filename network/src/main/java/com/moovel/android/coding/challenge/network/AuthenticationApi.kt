package com.moovel.android.coding.challenge.network

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthenticationApi{

    @Headers("Accept: application/json")
    @POST("login/oauth/access_token")
    @FormUrlEncoded
    fun getAccessToken(@Field("client_id") clientId : String,
                       @Field("client_secret") clientSecret : String,
                       @Field("code") code : String) : Call<AccessToken>
}

data class AccessToken(@SerializedName("access_token") val accessToken: String, @SerializedName("token_type") val tokenType : String)
