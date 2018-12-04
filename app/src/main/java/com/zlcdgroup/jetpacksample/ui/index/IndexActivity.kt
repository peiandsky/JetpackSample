package com.zlcdgroup.jetpacksample.ui.index

import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.zlcdgroup.jetpacksample.R
import com.zlcdgroup.jetpacksample.app.BaseActivity
import com.zlcdgroup.jetpacksample.app.util.PreferenceUtil
import com.zlcdgroup.jetpacksample.ui.index.book.BookListFragment
import com.zlcdgroup.jetpacksample.ui.index.gold.GoldFragment
import com.zlcdgroup.jetpacksample.ui.index.idcrad.IdcardFragment
import com.zlcdgroup.jetpacksample.ui.index.ip.IpFragment
import com.zlcdgroup.jetpacksample.ui.index.lottery.LotteryFragment
import com.zlcdgroup.jetpacksample.ui.index.news.NewsListFragment
import com.zlcdgroup.jetpacksample.ui.index.rate.RateFragment
import kotlinx.android.synthetic.main.index_activity.*
import org.jetbrains.anko.find
import org.jetbrains.anko.textResource
import org.jetbrains.anko.toast

/**
 * 对于数据较少的界面，无需使用数据绑定或者ViewModel，用简单的方式才更有效
 */
class IndexActivity : BaseActivity() {
    private val userNameKey = "UserName"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.index_activity)
        setSupportActionBar(toolbar)

        val view = navView.inflateHeaderView(R.layout.index_nav_header)
        view.find<TextView>(R.id.username).text = PreferenceUtil.getSpString(userNameKey, "")

        fab.setOnClickListener {
            toast("反馈建议")
        }
        val toggle = ActionBarDrawerToggle(
            this@IndexActivity, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener { item ->

            var fragment: Fragment? = null

            when (item.itemId) {
                R.id.nav_news -> {
                    fragment = NewsListFragment.newInstance()
                    toolBarTitle.textResource = R.string.menu_news
                }
                R.id.nav_book -> {
                    fragment = BookListFragment.newInstance()
                    toolBarTitle.textResource = R.string.menu_book
                }
                R.id.nav_idcard -> {
                    fragment = IdcardFragment.newInstance()
                    toolBarTitle.textResource = R.string.menu_idcard
                }
                R.id.nav_lottery -> {
                    fragment = LotteryFragment.newInstance()
                    toolBarTitle.textResource = R.string.menu_lottery
                }
                R.id.nav_gold -> {
                    fragment = GoldFragment.newInstance()
                    toolBarTitle.textResource = R.string.menu_gold
                }
                R.id.nav_rate -> {
                    fragment = RateFragment.newInstance()
                    toolBarTitle.textResource = R.string.menu_rate
                }
                R.id.nav_ip -> {
                    fragment = IpFragment.newInstance()
                    toolBarTitle.textResource = R.string.menu_ip
                }
            }

            fragment?.let {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragmentContainer, fragment)
                transaction.commit()
            }

            drawerLayout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }

    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.index, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}
