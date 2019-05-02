package com.moovel.android.coding.challenge.framework.adapter

import android.support.v7.util.DiffUtil
import com.moovel.android.coding.challenge.domain.entity.User

class UserDiffUtilCallback: DiffUtil.ItemCallback<User>() {

    override fun areItemsTheSame(oldUser: User, newUser: User): Boolean {
        return oldUser.id == newUser.id
    }

    override fun areContentsTheSame(oldUser: User, newUser: User): Boolean {
        return oldUser.username == newUser.username
                && oldUser.avatar_url == newUser.avatar_url
                && oldUser.registration_date == newUser.registration_date
    }
}