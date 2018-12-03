package com.zlcdgroup.jetpacksample.ui.welcome

import android.os.Bundle
import android.os.Handler
import androidx.databinding.Observable
import androidx.lifecycle.ViewModelProviders
import com.zlcdgroup.jetpacksample.R
import com.zlcdgroup.jetpacksample.app.BaseActivity
import com.zlcdgroup.jetpacksample.ui.login.LoginActivity
import org.jetbrains.anko.startActivity

/**
 * 欢迎界面
 * 一般情况下，在该界面会获取一些信息，准备初始化程序
 */
class WelcomeActivity : BaseActivity() {
    //欢迎界面停留时间
    private val waitTimeMills: Long = 2000

    private lateinit var viewModel: WelcomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_activity)
        viewModel = ViewModelProviders.of(this).get(WelcomeViewModel::class.java)
        viewModel.changeToLogin.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                toLogin()
            }
        })

        val handler = Handler()
        handler.postDelayed({
            viewModel.changeToLogin.set(true)
        }, waitTimeMills)


    }

    private fun toLogin() {
        startActivity<LoginActivity>()
        finish()
    }

    override fun onBackPressed() {

    }
}
