package com.moovel.android.coding.challenge.data.local

import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface UserDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user : User) : Long

    @Query("SELECT * FROM USERS")
    fun getAllUsers(): DataSource.Factory<Int,User>
}