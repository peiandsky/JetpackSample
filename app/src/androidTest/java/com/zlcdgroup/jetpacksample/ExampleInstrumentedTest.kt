package com.zlcdgroup.jetpacksample


import androidx.test.InstrumentationRegistry.*
import androidx.test.runner.AndroidJUnit4
import com.zlcdgroup.jetpacksample.db.AppDatabase
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = getTargetContext()
        assertEquals("com.zlcdgroup.jetpacksample", appContext.packageName)
    }


    @Test
    fun testNewsDao()
    {
        val data=AppDatabase.instance.getNewsDataDao().getNewsDataList("国内").value
        assertNotNull(data)
        assertTrue(data!!.isNotEmpty())
    }
}
