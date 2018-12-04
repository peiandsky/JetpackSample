package com.zlcdgroup.jetpacksample.ui.index.book

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zlcdgroup.jetpacksample.R

class BookListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_list_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, BookListFragment.newInstance())
                .commitNow()
        }
    }

}
