package com.josie.baselibrary.injection.module

import com.trello.rxlifecycle.LifecycleProvider
import dagger.Module
import dagger.Provides

/**
 * @description : Dagger Module of Lifecycle
 * created by josie at 2020/3/20
 */
@Module
class LifecycleProviderModule(private val lifecycleProvider: LifecycleProvider<*>) {
    @Provides
    fun providesLifecycleProvider(): LifecycleProvider<*> {
        return this.lifecycleProvider
    }
}