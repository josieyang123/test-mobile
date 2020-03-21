package com.josie.baselibrary.data.protocol

/**
 * @description :
 * created by josie at 2020/3/20
 */
class BaseResp<out T>(val status: Int, val message: String, val data: T) {
}