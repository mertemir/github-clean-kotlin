package com.moovel.android.coding.challenge.framework.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moovel.android.coding.challenge.R
import com.moovel.android.coding.challenge.domain.entity.User
import com.moovel.android.coding.challenge.framework.ui.user.UserDetailActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.user_list_row.view.*

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    companion object {
        fun create(parent : ViewGroup): UserViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.user_list_row, parent, false)
            return UserViewHolder(view)
        }
    }

    fun bind(user: User?){
        user?.let {
            itemView.username.text = user.username
            itemView.date.text = user.registration_date?.subSequence(0,10)
            Picasso.get().load(user.avatar_url).resize(300,300).into(itemView.avatar)

            itemView.setOnClickListener {
                val intent = Intent(it.context, UserDetailActivity::class.java)
                intent.putExtra("user", user)
                it.context.startActivity(intent)
            }
        }
    }
}
