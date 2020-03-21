package com.josie.baselibrary.common

import android.graphics.drawable.AnimationDrawable
import android.view.View
import android.widget.ImageView
import com.josie.baselibrary.R
import com.josie.baselibrary.data.protocol.BaseResp
import com.josie.baselibrary.rx.BaseFunc
import com.josie.baselibrary.rx.BaseFuncBoolean
import com.josie.baselibrary.rx.BaseSubscriber
import com.josie.baselibrary.utils.GlideUtils
import com.kennyc.view.MultiStateView
import com.trello.rxlifecycle.LifecycleProvider
import org.jetbrains.anko.find
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * @description : common methods
 * created by josie at 2020/3/20
 */
fun <T> Observable<T>.execute(
    subscriber: BaseSubscriber<T>,
    lifecycleProvider: LifecycleProvider<*>
) {
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

fun <T> Observable<BaseResp<T>>.convert(): Observable<T> {
    return this.flatMap(BaseFunc())
}

fun <T> Observable<BaseResp<T>>.convertBoolean(): Observable<Boolean> {
    return this.flatMap(BaseFuncBoolean())
}

fun ImageView.loadUrl(url: String) {
    GlideUtils.loadUrlImage(context, url, this)
}

fun MultiStateView.startLoading() {
    viewState = MultiStateView.VIEW_STATE_LOADING
    val loadingView = getView(MultiStateView.VIEW_STATE_LOADING)
    val animBackground = loadingView!!.find<View>(R.id.loading_anim_view).background
    (animBackground as AnimationDrawable).start()
}

fun View.setVisible(visible: Boolean) {
    this.visibility = if (visible) View.VISIBLE else View.GONE
}


