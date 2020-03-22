package com.josie.usermodule.data.api

import com.josie.usermodule.data.protocol.SearchUserResp
import com.josie.usermodule.data.protocol.UserInfo
import retrofit2.http.*
import rx.Observable


/**
 * @description : The api of github users
 * created by josie at 2020/3/21
 */
interface UserApi {

    //get all users of github
    @GET("users")
    fun getAllUsers(@QueryMap map: Map<String, String>):Observable<MutableList<UserInfo>>

    //search users by username
    @GET("search/users")
    fun searchUsers(@QueryMap map: Map<String, String>):Observable<SearchUserResp>

    //get user info by username
    @GET("users/{username}")
    fun getUser(@Path("username") name:String):Observable<UserInfo>

}