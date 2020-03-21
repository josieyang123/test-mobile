package com.josie.baselibrary.injection.component

import android.app.Activity
import android.content.Context
import com.josie.baselibrary.injection.ActivityScope
import com.josie.baselibrary.injection.module.ActivityModule
import com.josie.baselibrary.injection.module.LifecycleProviderModule
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Component

/**
 * @description : Dagger Component of Activity
 * created by josie at 2020/3/20
 */
@ActivityScope
@Component(
    dependencies = arrayOf(AppComponent::class), modules = arrayOf(
        ActivityModule::class,
        LifecycleProviderModule::class
    )
)
interface ActivityComponent {

    fun activity(): Activity
    fun context(): Context
    //fun fragment(): Fragment
    fun lifecycleProvider(): LifecycleProvider<*>
}
