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
        val newsTypeTitle = listOf("国内新闻", "国际新闻", "娱乐新闻", "科技新闻", "财经新闻")

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
        transaction.replace(R.id.frameLayout, newsListFragment)
        transaction.commit()
    }

}
