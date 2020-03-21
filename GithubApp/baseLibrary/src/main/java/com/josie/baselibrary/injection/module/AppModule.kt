package com.josie.baselibrary.injection.module

import android.content.Context
import com.josie.baselibrary.ui.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @description : Dagger Module of App
 * created by josie at 2020/3/20
 */
@Module
class AppModule(private val context: BaseApplication) {
    @Singleton
    @Provides
    fun provideContext(): Context {
        return this.context
    }
}
