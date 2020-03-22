package com.josie.baselibrary.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.GlideDrawable
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import com.josie.baselibrary.R
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import android.graphics.Bitmap
import com.bumptech.glide.request.target.BitmapImageViewTarget



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
        Glide.with(context).load(url).placeholder(R.drawable.ic_github)
            .error(R.drawable.ic_github).centerCrop().into(
            object : SimpleTarget<GlideDrawable>() {
                override fun onResourceReady(
                    resource: GlideDrawable,
                    glideAnimation: GlideAnimation<in GlideDrawable>
                ) {
                    imageView.setImageDrawable(resource)
                }
            })
    }
    fun loadUrlRoundImage(context: Context, url: String, imageView: ImageView) {
        Glide.with(context).load(url).asBitmap().placeholder(R.drawable.ic_github)
            .error(R.drawable.ic_github).centerCrop()
            .into(object : BitmapImageViewTarget(imageView) {
                override fun setResource(resource: Bitmap) {
                    val circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.resources, resource)
                    circularBitmapDrawable.isCircular = true
                    imageView.setImageDrawable(circularBitmapDrawable)
                }
            })
    }

    fun loadImageBackground(context: Context, url: String, view: View) {
        Glide.with(context).load(url).placeholder(R.drawable.ic_github)
            .error(R.drawable.ic_github).centerCrop()
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