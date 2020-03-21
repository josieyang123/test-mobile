package com.josie.baselibrary.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.GlideDrawable
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import com.josie.baselibrary.R

/**
 * @description :
 * created by josie at 2020/3/20
 */
object GlideUtils {
    fun loadImage(context: Context, url: String, imageView: ImageView) {
        Glide.with(context).load(url).centerCrop().into(imageView)
    }

    fun loadImageFitCenter(context: Context, url: String, imageView: ImageView) {
        Glide.with(context).load(url).fitCenter().into(imageView)
    }

    fun loadUrlImage(context: Context, url: String, imageView: ImageView) {
        Glide.with(context).load(url).placeholder(R.drawable.icon_error_red)
            .error(R.drawable.icon_error_red).centerCrop().into(
            object : SimpleTarget<GlideDrawable>() {
                override fun onResourceReady(
                    resource: GlideDrawable,
                    glideAnimation: GlideAnimation<in GlideDrawable>
                ) {
                    imageView.setImageDrawable(resource)
                }
            })
    }

    fun loadImageBackground(context: Context, url: String, view: View) {
        Glide.with(context).load(url).placeholder(R.drawable.icon_error_red)
            .error(R.drawable.icon_error_red).centerCrop()
            .into(object : SimpleTarget<GlideDrawable>() {
                override fun onResourceReady(
                    resource: GlideDrawable?,
                    glideAnimation: GlideAnimation<in GlideDrawable>?
                ) {
                    view.setBackgroundDrawable(resource)
                }

            })
    }
}