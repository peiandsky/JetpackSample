package com.zlcdgroup.jetpacksample.ui.index

import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.zlcdgroup.jetpacksample.R
import com.zlcdgroup.jetpacksample.app.BaseActivity
import com.zlcdgroup.jetpacksample.app.util.PreferenceUtil
import kotlinx.android.synthetic.main.index_activity.*
import org.jetbrains.anko.find
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
            when (item.itemId) {
                R.id.nav_news -> {
                }
                R.id.nav_book -> {

                }
                R.id.nav_idcard -> {

                }
                R.id.nav_lottery -> {

                }
                R.id.nav_gold -> {

                }
                R.id.nav_rate -> {

                }
                R.id.nav_ip -> {

                }
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
