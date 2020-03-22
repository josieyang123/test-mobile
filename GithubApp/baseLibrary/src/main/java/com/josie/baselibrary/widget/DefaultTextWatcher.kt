package com.josie.baselibrary.widget

import android.text.Editable
import android.text.TextWatcher

/**
 * User:yangzhichao
 * Date:2020/1/2
 * Description:
 */
open class DefaultTextWatcher:TextWatcher {
    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }
}
