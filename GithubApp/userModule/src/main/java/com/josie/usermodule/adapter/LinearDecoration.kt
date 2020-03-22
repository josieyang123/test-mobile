package com.josie.usermodule.adapter

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * @description :
 * created by josie at 2020/3/22
 */
class LinearDecoration(val horizontalSpace: Int, val verticalSpace: Int) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.left = horizontalSpace
        outRect.right = horizontalSpace
        outRect.top = verticalSpace
    }
}