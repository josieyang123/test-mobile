package com.josie.baselibrary.rx

import com.josie.baselibrary.data.protocol.BaseResp
import rx.Observable
import rx.functions.Func1

/**
 * @description : Package request
 * created by josie at 2020/3/20
 */
class BaseFunc<T> : Func1<T, Observable<T>> {
    override fun call(t: T): Observable<T> {
        return Observable.just(t)
    }
}