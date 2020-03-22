package com.josie.usermodule.injection.component

import com.josie.baselibrary.injection.PerComponentScope
import com.josie.baselibrary.injection.component.ActivityComponent
import com.josie.usermodule.activity.UserDetailsActivity
import com.josie.usermodule.activity.UserListActivity
import com.josie.usermodule.injection.module.UserModule
import dagger.Component

/**
 * @description :
 * created by josie at 2020/3/21
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(UserModule::class))
interface UserComponent {
    fun inject(activity:UserListActivity)
    fun inject(activity:UserDetailsActivity)
}