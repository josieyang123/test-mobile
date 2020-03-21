package com.josie.baselibrary.ui

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import com.trello.rxlifecycle.components.support.RxAppCompatActivity
import org.jetbrains.anko.find

/**
 * @description : Base class of Activity
 * created by josie at 2020/3/20
 */
open class BaseActivity : RxAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppManager.instance.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.finishActivity(this)
    }

    val contentView: View
        get() {
            val content = find<FrameLayout>(android.R.id.content)
            return content.getChildAt(0)
        }
}