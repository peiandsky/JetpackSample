package com.zlcdgroup.jetpacksample.db

import androidx.room.TypeConverter
import java.math.BigDecimal
import java.util.*

/**
 * 数据库类型转换器
 */
object Converters {
    @JvmStatic
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @JvmStatic
    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

    @JvmStatic
    @TypeConverter
    fun stringToBig(intDecimal: Int): BigDecimal {
        return BigDecimal(intDecimal)
    }

    @JvmStatic
    @TypeConverter
    fun bigToString(bigDecimal: BigDecimal): Int {
        return bigDecimal.toInt()
    }


}