package com.zlcdgroup.jetpacksample.ui.index.rate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zlcdgroup.jetpacksample.R

class RateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rate_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, RateFragment.newInstance())
                .commitNow()
        }
    }

}
