package com.zlcdgroup.jetpacksample.app.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager

class SuperRecycleView : RecyclerView {

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, 0)

//    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
//        //拦截与ViewPager冲突的事件
//        var parent: ViewParent = this.parent
//        while (parent !is ViewPager) {
//            parent = parent.parent
//        }
//        parent.requestDisallowInterceptTouchEvent(true)
//        return super.dispatchTouchEvent(ev)
//    }


}