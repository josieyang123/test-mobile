package com.josie.baselibrary.rx

import com.josie.baselibrary.presenter.view.BaseView
import org.jetbrains.anko.AnkoLogger
import rx.Subscriber

/**
 * @description : Package callback
 * created by josie at 2020/3/20
 */
open class BaseSubscriber<T>(val baseView: BaseView) : Subscriber<T>(), AnkoLogger {
    override fun onNext(t: T) {
    }

    override fun onCompleted() {
        baseView.hideLoading()
    }

    override fun onError(e: Throwable?) {
        baseView.hideLoading()
        if (e is BaseException) {
            baseView.onError(e.msg)
        } else if (e is Exception) {
            baseView.onError(e.toString())
        }
    }

}