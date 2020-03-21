package com.josie.baselibrary.injection.component

import android.content.Context
import com.josie.baselibrary.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * @description : Dagger Component of App
 * created by josie at 2020/3/20
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun context(): Context
}
