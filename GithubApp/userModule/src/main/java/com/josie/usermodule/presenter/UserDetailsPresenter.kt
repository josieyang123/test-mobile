package com.josie.usermodule.presenter

import com.josie.baselibrary.common.execute
import com.josie.baselibrary.presenter.BasePresenter
import com.josie.baselibrary.rx.BaseSubscriber
import com.josie.usermodule.data.protocol.UserInfo
import com.josie.usermodule.presenter.view.UserDetailsView
import com.josie.usermodule.service.UserService
import javax.inject.Inject
import javax.inject.Named

/**
 * @description : the MVP presenter of UserDetailsActivity, call the methods of UserServiceImpl, and then Callback data to UserDetailsView
 * created by josie at 2020/3/21
 */
class UserDetailsPresenter @Inject constructor(): BasePresenter<UserDetailsView>() {
    @Inject
    @field:[ Named("service") ]
    lateinit var userService: UserService

    //get user info by username
    /**
     * @description  get user info by username
     * @param name : username
     * @return the user info
     */
    fun getUser(name:String){
        if (!checkNetWork())
            return
        mView.showLoading()
        userService.getUser(name).execute(object : BaseSubscriber<UserInfo>(mView){
            override fun onNext(t: UserInfo) {
                mView.onGetUserResult(t)
            }
        },lifecycleProvider)
    }

}