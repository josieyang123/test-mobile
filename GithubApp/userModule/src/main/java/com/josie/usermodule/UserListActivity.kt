package com.josie.usermodule

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.josie.baselibrary.arouter.RouterPath
import com.josie.baselibrary.ui.BaseActivity

/**
 * @description : The entrance of Usermodule
 * created by josie at 2020/3/20
 */
@Route(path = RouterPath.UserModule.PATH_USER)
class UserListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)
    }
}
