package com.josie.usermodule.presenter.view

import com.josie.baselibrary.presenter.view.BaseView
import com.josie.usermodule.data.protocol.UserInfo

/**
 * @description : Responsible for data callback of UserDetailsActivity
 * created by josie at 2020/3/21
 */
interface UserDetailsView : BaseView {

    fun onGetUserResult(result: UserInfo)
}