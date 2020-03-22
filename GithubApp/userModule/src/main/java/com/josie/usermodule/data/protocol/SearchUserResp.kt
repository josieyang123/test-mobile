package com.josie.usermodule.data.protocol

/**
 * @description :
 * created by josie at 2020/3/21
 */
data class SearchUserResp(val total_count:Int,
                          val incomplete_results:Boolean,
                          val items:MutableList<UserInfo>,
                          val message:String,
                          val errors:MutableList<ErrorResp>,
                          val documentation_url:String)