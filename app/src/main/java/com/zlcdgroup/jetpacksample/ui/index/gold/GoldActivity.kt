package com.zlcdgroup.jetpacksample.ui.index.gold

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zlcdgroup.jetpacksample.R

class GoldActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gold_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, GoldFragment.newInstance())
                .commitNow()
        }
    }

}
