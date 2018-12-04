package com.zlcdgroup.jetpacksample.ui.index.idcrad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zlcdgroup.jetpacksample.R

class IDCardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.idcard_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, IdcardFragment.newInstance())
                .commitNow()
        }
    }

}
