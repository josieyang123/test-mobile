package com.josie.baselibrary.arouter

/**
 * @description :constants of ARouter
 * created by josie at 2020/3/20
 */
object RouterPath {
    //宿主
    class App {
        companion object {
            const val PATH_MAIN = "/app/main"
        }
    }

    //用户模块
    class User {
        companion object {
            const val PATH_USER = "/userModule/list"
        }
    }
}