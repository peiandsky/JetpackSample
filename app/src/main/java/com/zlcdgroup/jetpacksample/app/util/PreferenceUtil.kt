package com.zlcdgroup.jetpacksample.app.util

import android.content.SharedPreferences
import com.zlcdgroup.jetpacksample.app.App

object PreferenceUtil {

    val sp: SharedPreferences by lazy {
        App.instance.getSharedPreferences("app", 0)
    }

    fun saveSpInt(key: String, value: Int) = sp.edit().putInt(key, value).apply()

    fun getSpInt(key: String, defaultValue: Int = 0) = sp.getInt(key, defaultValue)

    fun saveSpLong(key: String, value: Long) = sp.edit().putLong(key, value).apply()

    fun getSpLong(key: String, defaultValue: Long = 0L) = sp.getLong(key, defaultValue)

    fun saveSpFloat(key: String, value: Float) = sp.edit().putFloat(key, value).apply()

    fun getSpFloat(key: String, defaultValue: Float = 0f) = sp.getFloat(key, defaultValue)

    fun saveSpBoolean(key: String, value: Boolean) = sp.edit().putBoolean(key, value).apply()

    fun getSpBoolean(key: String, defaultValue: Boolean = false) = sp.getBoolean(key, defaultValue)

    fun saveSpString(key: String, value: String) = sp.edit().putString(key, value).apply()

    fun getSpString(key: String, defaultValue: String = "") = sp.getString(key, defaultValue)!!
}