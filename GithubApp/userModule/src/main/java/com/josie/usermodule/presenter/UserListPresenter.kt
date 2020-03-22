package com.josie.usermodule.presenter

import com.josie.baselibrary.common.execute
import com.josie.baselibrary.presenter.BasePresenter
import com.josie.baselibrary.rx.BaseSubscriber
import com.josie.usermodule.data.protocol.SearchUserResp
import com.josie.usermodule.data.protocol.UserInfo
import com.josie.usermodule.presenter.view.UserListView
import com.josie.usermodule.service.UserService
import javax.inject.Inject
import javax.inject.Named

/**
 * @description : the MVP presenter of UserListActivity, call the methods of UserServiceImpl, and then Callback data to UserListView
 * created by josie at 2020/3/21
 */
class UserListPresenter @Inject constructor(): BasePresenter<UserListView>() {
    @Inject
    @field:[ Named("service") ]
    lateinit var userService: UserService

    /**
     * @description  get all users of github
     * @param page : page number
     * @return the list of user info
     */
    fun getAllUsers(page:Int){
        if (!checkNetWork())
            return
        userService.getAllUsers(page).execute(object : BaseSubscriber<MutableList<UserInfo>>(mView){
            override fun onNext(t: MutableList<UserInfo>) {
                mView.onGetAllUsersResult(t)
            }
        },lifecycleProvider)
    }

    /**
     * @description  search users by username
     * @param content : username, page : page number, per_page : the list size returned
     * @return
     */
    fun searchUsers(content:String,page:Int,per_page:Int){
        if (!checkNetWork())
            return
        mView.showLoading()
        userService.searchUsers(content,page,per_page).execute(object : BaseSubscriber<SearchUserResp>(mView){
            override fun onNext(t: SearchUserResp) {
                mView.onSearchUsersResult(t)
            }
        },lifecycleProvider)
    }

}