package com.josie.baselibrary.presenter

import android.content.Context
import com.josie.baselibrary.R
import com.josie.baselibrary.presenter.view.BaseView
import com.josie.baselibrary.utils.NetWorkUtils
import com.trello.rxlifecycle.LifecycleProvider
import javax.inject.Inject

/**
 * @description : BasePresenter of MVP
 * created by josie at 2020/3/20
 */
open class BasePresenter<T : BaseView> {
    lateinit var mView: T
    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>

    @Inject
    lateinit var context: Context

    fun checkNetWork(): Boolean {
        if (NetWorkUtils.isNetWorkAvailable(context)) {
            return true
        }
        mView.onError(context.resources.getString(R.string.net_error))
        return false
    }
}