package com.josie.usermodule.data.repository

import com.josie.baselibrary.data.net.RetrofitFactory
import com.josie.usermodule.data.api.UserApi
import com.josie.usermodule.data.protocol.SearchUserResp
import com.josie.usermodule.data.protocol.UserInfo
import rx.Observable
import javax.inject.Inject

/**
 * @description :
 * created by josie at 2020/3/21
 */
class UserRepository @Inject constructor(){

    fun getAllUsers(page:Int): Observable<MutableList<UserInfo>>{
        var map= HashMap<String,String>()
        map.put("since",page.toString())
        return  RetrofitFactory.instance.create(UserApi::class.java).getAllUsers(map)
    }
    fun searchUsers(content:String,page:Int,per_page:Int): Observable<SearchUserResp>{
        var map= HashMap<String,String>()
        map.put("q",content)
        map.put("page",page.toString())
        map.put("per_page",per_page.toString())
        return RetrofitFactory.instance.create(UserApi::class.java).searchUsers(map)
    }
    fun getUser(name:String): Observable<UserInfo>{
        return RetrofitFactory.instance.create(UserApi::class.java).getUser(name)
    }
}