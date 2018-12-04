package com.zlcdgroup.jetpacksample.ui.login

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.zlcdgroup.jetpacksample.R

import com.zlcdgroup.jetpacksample.app.BaseActivity
import com.zlcdgroup.jetpacksample.app.util.PreferenceUtil
import com.zlcdgroup.jetpacksample.databinding.LoginActivityBinding
import com.zlcdgroup.jetpacksample.ui.index.IndexActivity
import org.jetbrains.anko.startActivity

/**
 * 登录界面
 */
class LoginActivity : BaseActivity() {
    private val rememberPasswordKey = "RememberPassword"
    private val userNameKey = "UserName"
    private val passwordKey = "Password"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        //读取保存的用户名和密码
        initLoginViewModel(loginViewModel)

        val loginActivityBinding = DataBindingUtil.setContentView<LoginActivityBinding>(this, R.layout.login_activity)
        loginActivityBinding.viewmodel = loginViewModel

        loginActivityBinding.run {
            btnLogin.setOnClickListener {
                attemptLogin(loginViewModel)
            }
            remember.setOnClickListener {
                PreferenceUtil.saveSpBoolean(rememberPasswordKey, remember.isChecked)
            }
        }
    }

    private fun initLoginViewModel(loginViewModel: LoginViewModel) {
        val rememberPasswordBoolean = PreferenceUtil.getSpBoolean(rememberPasswordKey, false)
        loginViewModel.rememberPassword.set(rememberPasswordBoolean)

        val userName = PreferenceUtil.getSpString(userNameKey, "")
        loginViewModel.username.set(userName)

        if (rememberPasswordBoolean) {
            val password = PreferenceUtil.getSpString(passwordKey, "")
            loginViewModel.password.set(password)
        }

    }

    private fun attemptLogin(loginViewModel: LoginViewModel) {
        loginViewModel.run {
            if (username.get().isNullOrEmpty() || password.get().isNullOrEmpty()) {
                loginViewModel.errorMssage.set("请输入用户名或密码")
                return
            }
            loginViewModel.errorMssage.set("")
        }

        //登录成功需要存储用户数据
        PreferenceUtil.saveSpString(userNameKey, loginViewModel.username.get() ?: "")
        PreferenceUtil.saveSpBoolean(rememberPasswordKey, loginViewModel.rememberPassword.get())
        if (loginViewModel.rememberPassword.get()) {
            PreferenceUtil.saveSpString(passwordKey, loginViewModel.password.get() ?: "")
        }

        toIndex()

    }

    private fun toIndex() {
        startActivity<IndexActivity>()
        finish()
    }


}
