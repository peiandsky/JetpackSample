package com.zlcdgroup.jetpacksample.ui.adapters

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("visibleGone")
fun View.visibleGone(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("setImageUrl")
fun setImageUrl(imageView: ImageView, imageUrl: String) {
    Picasso.get().load(imageUrl).into(imageView)
}