package com.josie.usermodule.service.impl

import com.josie.baselibrary.common.convert
import com.josie.usermodule.data.protocol.SearchUserResp
import com.josie.usermodule.data.protocol.UserInfo
import com.josie.usermodule.data.repository.UserRepository
import com.josie.usermodule.service.UserService
import rx.Observable
import javax.inject.Inject

/**
 * @description : send requests to Server by Retrofit
 * created by josie at 2020/3/21
 */
class UserServiceImpl @Inject constructor(): UserService {
    @Inject
    lateinit var repository: UserRepository

    override fun getAllUsers(page:Int): Observable<MutableList<UserInfo>> {
        return repository.getAllUsers(page).convert()
    }

    override fun searchUsers(content:String,page:Int,per_page:Int): Observable<SearchUserResp> {
        return repository.searchUsers(content,page,per_page).convert()
    }

    override fun getUser(name:String): Observable<UserInfo> {
        return repository.getUser(name).convert()
    }
}