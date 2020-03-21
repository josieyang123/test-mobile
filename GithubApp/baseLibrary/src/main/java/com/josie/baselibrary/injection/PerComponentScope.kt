package com.josie.baselibrary.injection

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

/**
 * @description :
 * created by josie at 2020/3/20
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class PerComponentScope
