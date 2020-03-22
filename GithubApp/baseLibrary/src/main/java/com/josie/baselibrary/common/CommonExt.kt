package com.josie.baselibrary.common

import android.view.View
import android.widget.ImageView
import com.josie.baselibrary.rx.BaseFunc
import com.josie.baselibrary.rx.BaseSubscriber
import com.josie.baselibrary.utils.GlideUtils
import com.trello.rxlifecycle.LifecycleProvider
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * @description : common methods
 * created by josie at 2020/3/20
 */
fun <T> Observable<T>.execute(subscriber: BaseSubscriber<T>, lifecycleProvider: LifecycleProvider<*>) {
    this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .compose(lifecycleProvider.bindToLifecycle())
        .subscribe(subscriber)
}

fun View.onClick(listener: View.OnClickListener): View {
    this.setOnClickListener(listener)
    return this
}

fun View.onClick(method: () -> Unit): View {
    this.setOnClickListener { method() }
    return this
}

fun <T> Observable<T>.convert(): Observable<T> {
    return this.flatMap(BaseFunc())
}

fun ImageView.loadUrl(url: String) {
    GlideUtils.loadUrlImage(context, url, this)
}
fun ImageView.loadUrlRound(url: String) {
    GlideUtils.loadUrlRoundImage(context, url, this)
}

fun View.setVisible(visible: Boolean) {
    this.visibility = if (visible) View.VISIBLE else View.GONE
}


