package com.josie.usermodule.presenter.view

import com.josie.baselibrary.presenter.view.BaseView
import com.josie.usermodule.data.protocol.SearchUserResp
import com.josie.usermodule.data.protocol.UserInfo

/**
 * @description : Responsible for data callback of UserListActivity
 * created by josie at 2020/3/21
 */
interface UserListView : BaseView {

    fun onGetAllUsersResult(result: MutableList<UserInfo>)
    fun onSearchUsersResult(result: SearchUserResp)
}