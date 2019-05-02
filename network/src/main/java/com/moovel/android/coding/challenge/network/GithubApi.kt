package com.moovel.android.coding.challenge.network

import com.google.gson.annotations.SerializedName
import io.reactivex.Single
import retrofit2.http.*

interface GithubApi{

    @GET("search/users?q=language%3Akotlin")
    fun getUsers(@Query("page") page : Int, @Query("per_page") pageSize : Int) : Single<UserResponse>

    @GET("users/{name}")
    fun getUserDetails( @Path("name") name : String) : Single<UserDetail>

}

data class UserResponse(@SerializedName("items") val results: List<User>)

data class User(
        @SerializedName("login") val username: String,
        @SerializedName("id") val id: String,
        @SerializedName("avatar_url") val avatar_url: String
)

data class UserDetail(
        @SerializedName("name") val name : String,
        @SerializedName("company") val company : String,
        @SerializedName("location") val location : String,
        @SerializedName("email") val email : String,
        @SerializedName("bio") val bio : String,
        @SerializedName("followers") val followers : String,
        @SerializedName("created_at") val registration_date : String
)