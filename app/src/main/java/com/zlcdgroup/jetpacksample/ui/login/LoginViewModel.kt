package com.zlcdgroup.jetpacksample.ui.login

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    val username = ObservableField<String>()
    val errorMssage = ObservableField<String>()
    val password = ObservableField<String>()
    val rememberPassword = ObservableBoolean()

}