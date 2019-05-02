package com.moovel.android.coding.challenge.framework.ui.user

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.moovel.android.coding.challenge.R
import com.moovel.android.coding.challenge.domain.entity.User
import com.moovel.android.coding.challenge.framework.common.BaseActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_user_detail.*
import org.jetbrains.anko.email
import android.graphics.Color
import android.graphics.Paint


class UserDetailActivity : BaseActivity() {

    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)

        setContentView(R.layout.activity_user_detail)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(UserViewModel::class.java)

        val user = intent.extras.getParcelable("user") as User

        Picasso.get().load(user.avatar_url).resize(300,300).into(avatar)

        name.text = user.name ?: "-"
        email.text = user.email ?: "-"
        company.text = user.company ?: "-"
        location.text = user.location ?: "-"
        bio.text = user.bio ?: "-"
        followers.text = user.followers ?: "-"

        if (email.text != "-")
        {
            email.paintFlags = email.paintFlags or Paint.UNDERLINE_TEXT_FLAG
            email.setTextColor(Color.BLUE)
            email.setOnClickListener { user.email?.let { email(it) } }
        }

    }
}
