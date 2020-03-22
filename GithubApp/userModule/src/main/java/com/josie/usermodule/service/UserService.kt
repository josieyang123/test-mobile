package com.josie.usermodule.service

import com.josie.usermodule.data.protocol.SearchUserResp
import com.josie.usermodule.data.protocol.UserInfo
import rx.Observable

/**
 * @description :
 * created by josie at 2020/3/21
 */
interface UserService {
    fun getAllUsers(page:Int): Observable<MutableList<UserInfo>>
    fun searchUsers(content:String,page:Int,per_page:Int): Observable<SearchUserResp>
    fun getUser(name:String): Observable<UserInfo>
}