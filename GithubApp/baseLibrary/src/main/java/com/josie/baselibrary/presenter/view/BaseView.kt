package com.josie.baselibrary.presenter.view

/**
 * @description : BaseView of MVP
 * created by josie at 2020/3/20
 */
interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onError(text: String)
}