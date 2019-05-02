package com.moovel.android.coding.challenge.domain.entity

import android.os.Parcel
import android.os.Parcelable

data class User(
        var id: Int,
        val username: String?,
        val avatar_url: String?,
        val name: String?,
        val email: String?,
        val registration_date: String?,
        val company: String?,
        val location: String?,
        val bio: String?) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(username)
        parcel.writeString(avatar_url)
        parcel.writeString(name)
        parcel.writeString(email)
        parcel.writeString(registration_date)
        parcel.writeString(company)
        parcel.writeString(location)
        parcel.writeString(bio)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}