package com.josie.baselibrary.rx

import com.josie.baselibrary.common.ResultCode
import com.josie.baselibrary.data.protocol.BaseResp
import com.josie.baselibrary.utils.LogUtils
import org.jetbrains.anko.AnkoLogger
import rx.Observable
import rx.functions.Func1

/**
 * @description : Package request
 * created by josie at 2020/3/20
 */
class BaseFuncBoolean<T> : Func1<BaseResp<T>, Observable<Boolean>>, AnkoLogger {
    override fun call(t: BaseResp<T>): Observable<Boolean> {
        LogUtils.base("call()")
        if (t.status != ResultCode.SUCCESS) {
            return Observable.error(BaseException(t.status, t.message))
        }
        return Observable.just(true)
    }
}