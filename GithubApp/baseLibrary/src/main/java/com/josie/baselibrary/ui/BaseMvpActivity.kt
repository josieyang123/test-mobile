package com.josie.baselibrary.ui

import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.josie.baselibrary.R
import com.josie.baselibrary.injection.component.ActivityComponent
import com.josie.baselibrary.injection.component.DaggerActivityComponent
import com.josie.baselibrary.injection.module.ActivityModule
import com.josie.baselibrary.injection.module.LifecycleProviderModule
import com.josie.baselibrary.presenter.BasePresenter
import com.josie.baselibrary.presenter.view.BaseView
import com.josie.baselibrary.widget.ProgressLoading
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * @description : BaseMvpActivity of MVP
 * created by josie at 2020/3/20
 */
abstract class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {
    @Inject
    lateinit var mPresenter: T
    lateinit var activityComponent: ActivityComponent
    private lateinit var mLoadingDialog: ProgressLoading

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor=resources.getColor(R.color.colorPrimary)
        initActivityInjection()
        injectComponent()
        mLoadingDialog = ProgressLoading.create(this)
        ARouter.getInstance().inject(this)
    }

    override fun onStart() {
        super.onStart()
        window.setBackgroundDrawable(null)
    }

    protected abstract fun injectComponent()

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder()
            .appComponent((application as BaseApplication).appComponent)
            .activityModule(ActivityModule(this))
            .lifecycleProviderModule(LifecycleProviderModule(this))
            .build()
    }

    override fun showLoading() {
        mLoadingDialog.showLoading()
    }

    override fun hideLoading() {
        mLoadingDialog.hideLoading()
    }

    override fun onError(text: String) {
        toast(text)
    }
}