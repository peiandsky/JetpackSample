package com.zlcdgroup.jetpacksample.ui.adapters

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("visibleGone")
fun View.visibleGone(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}