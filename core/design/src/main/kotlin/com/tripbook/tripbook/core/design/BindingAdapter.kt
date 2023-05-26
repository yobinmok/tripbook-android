package com.tripbook.tripbook.core.design

import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("imgUri", "defaultImg")
    fun setImageUri(imageView: ImageView, uri: Uri?, default: Boolean) {
        if (default) {
            imageView.setImageURI((uri))
        } else {
            Glide.with(imageView.context)
                .load(uri)
                .circleCrop()
                .into(imageView)
        }
    }

    @JvmStatic
    @BindingAdapter("marginBottom")
    fun setButtonMarginBottom(view: View, dimen: Float) {
        (view.layoutParams as ViewGroup.MarginLayoutParams).let {
            it.bottomMargin = dimen.toInt()
            view.layoutParams = it
        }
    }
}
