package com.zlcdgroup.jetpacksample.ui.index.ip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zlcdgroup.jetpacksample.R

class IpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ip_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, IpFragment.newInstance())
                .commitNow()
        }
    }

}
