package com.zlcdgroup.jetpacksample.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.zlcdgroup.jetpacksample.app.App
import com.zlcdgroup.jetpacksample.app.util.AppExecutors
import com.zlcdgroup.jetpacksample.ui.index.news.data.NewsData

@Database(entities = [NewsData::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)

abstract class AppDatabase : RoomDatabase() {

    abstract fun getNewsDataDao(): NewsDataDao

    companion object {
        private const val DB_NAME = "jetpack.db"

        val instance by lazy(AppDatabase::class.java) {
            Room.databaseBuilder(App.instance, AppDatabase::class.java, DB_NAME)
                .setQueryExecutor(AppExecutors.NETWORK_EXECUTOR)
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                    }

                    override fun onOpen(db: SupportSQLiteDatabase) {
                        super.onOpen(db)
                    }
                })
                .build()
        }
    }


}