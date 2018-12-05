package com.zlcdgroup.jetpacksample.ui.adapters

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.squareup.picasso.Picasso
import org.jetbrains.anko.runOnUiThread

@BindingAdapter("visibleGone")
fun View.visibleGone(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("setImageUrl")
fun setImageUrl(imageView: ImageView, imageUrl: String) {
    Picasso.get().load(imageUrl).into(imageView)
}

@BindingAdapter("setRefreshState")
fun setRefreshState(refreshLayout: SwipeRefreshLayout, refreshState: Int) {
    refreshLayout.context.runOnUiThread {
        when (refreshState) {
            1 -> {
                refreshLayout.isRefreshing = true
            }
            else -> {
                refreshLayout.isRefreshing = false
            }
        }

    }
}

