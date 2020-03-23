package com.josie.baselibrary.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * @description :
 * created by josie at 2020/3/20
 */
object DateUtils {

    fun date2Str(time:String): String {
        val df = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        df.timeZone = TimeZone.getTimeZone("UTC")
        val after = df.parse(time)
        df.applyPattern("yyyy-MM-dd")
        df.timeZone = TimeZone.getDefault()
        return df.format(after)
    }


}