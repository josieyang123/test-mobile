package com.josie.baselibrary.rx

/**
 * @description : Package exception of response, easy to display
 * created by josie at 2020/3/20
 */
class BaseException(val status: Int, val msg: String) : Throwable()