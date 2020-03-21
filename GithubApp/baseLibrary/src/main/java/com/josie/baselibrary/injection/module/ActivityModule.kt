package com.josie.baselibrary.injection.module

import android.app.Activity
import com.josie.baselibrary.injection.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * @description : Dagger Module of Activity
 * created by josie at 2020/3/20
 */
@Module
class ActivityModule(private val activity: Activity) {
    @ActivityScope
    @Provides
    fun providesActivity(): Activity {
        return this.activity
    }
}