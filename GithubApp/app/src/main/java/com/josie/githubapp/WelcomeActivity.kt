package com.josie.githubapp

import android.os.Bundle
import com.josie.baselibrary.ui.BaseActivity
import com.josie.usermodule.activity.UserListActivity
import org.jetbrains.anko.startActivity

/**
 * @description : The entrance of the whole app
 * created by josie at 2020/3/20
 */
class WelcomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_welcome)
        startActivity<UserListActivity>()
        finish()
    }
}
