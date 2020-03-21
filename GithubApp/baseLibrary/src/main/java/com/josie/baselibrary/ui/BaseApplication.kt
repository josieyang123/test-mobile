package com.josie.baselibrary.ui

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.josie.baselibrary.injection.component.AppComponent
import com.josie.baselibrary.injection.component.DaggerAppComponent
import com.josie.baselibrary.injection.module.AppModule

/**
 * @description : Base Application of App, do initialization work
 * created by josie at 2020/3/20
 */
open class BaseApplication : Application() {
    companion object {
        lateinit var context: Context
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initAppInjection()
        context = this

        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(this)
    }

    private fun initAppInjection() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}
