package com.mertemir.android.coding.challenge.framework.ui.login

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.mertemir.android.coding.challenge.framework.common.BaseActivity

class LoginActivity : BaseActivity() {

    companion object {
        const val CLIENT_SECRET = "fdfe705f259e0108693a20c209ca026b33651aeb"
        const val CLIENT_ID = "5973220781fc95662981"
        const val REDIRECT_URI = "moovelapp://callback"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/login/oauth/authorize?client_id=$CLIENT_ID&redirect_uri=$REDIRECT_URI"))
        finish()
        startActivity(intent)

    }

}
