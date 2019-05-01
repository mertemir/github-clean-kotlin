package com.moovel.android.coding.challenge.data.local

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "users")
data class User(
        @PrimaryKey var id: Int,
        @ColumnInfo(name = "username") val username: String?,
        @ColumnInfo(name = "avatar_url") val avatar_url: String?,
        @ColumnInfo(name = "name") val name: String?,
        @ColumnInfo(name = "email") val email: String?,
        @ColumnInfo(name = "registration_date") val registration_date: String?,
        @ColumnInfo(name = "company") val company: String?,
        @ColumnInfo(name = "location") val location: String?,
        @ColumnInfo(name = "bio") val bio: String?)