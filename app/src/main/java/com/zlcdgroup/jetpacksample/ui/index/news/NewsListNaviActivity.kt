package com.zlcdgroup.jetpacksample.ui.index.news

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zlcdgroup.jetpacksample.R
import kotlinx.android.synthetic.main.news_list_navi_activity.*
import java.util.*

/**
 * 新闻综合列表界面
 */
class NewsListNaviActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_list_navi_activity)

        val newsTypeList = listOf("guonei", "guoji", "yule", "keji", "caijing")
        val newsTypeTitle = listOf("国内", "国际", "娱乐", "科技", "财经")

        val fragmentList = LinkedList<NewsListFragment>()
        for (index in 0 until newsTypeList.size step 1) {

            val arguments = Bundle()
            arguments.putString("newsType", newsTypeList[index])
            arguments.putString("newsTypeTitle", newsTypeTitle[index])

            val newsListFragment = NewsListFragment.newInstance()
            newsListFragment.arguments = arguments
            fragmentList.add(newsListFragment)
        }

        replaceFrameLayout(fragmentList[0])

        bottomNavView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.news_guonei -> {
                    replaceFrameLayout(fragmentList[0])
                }
                R.id.news_guoji -> {
                    replaceFrameLayout(fragmentList[1])
                }
                R.id.news_yule -> {
                    replaceFrameLayout(fragmentList[2])
                }
                R.id.news_keji -> {
                    replaceFrameLayout(fragmentList[3])
                }
                R.id.news_caijing -> {
                    replaceFrameLayout(fragmentList[4])
                }
            }
            true
        }

    }

    private fun replaceFrameLayout(newsListFragment: NewsListFragment) {
        val transaction = supportFragmentManager.beginTransaction()
        for (fragment in supportFragmentManager.fragments) {
            transaction.hide(fragment)
        }

        if (newsListFragment.isAdded) {
            transaction.show(newsListFragment).commit()
        } else {
            transaction.add(R.id.frameLayout, newsListFragment).commit()
        }

    }

}
