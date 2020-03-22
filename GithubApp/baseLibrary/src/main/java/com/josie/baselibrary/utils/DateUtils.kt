package com.josie.baselibrary.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * @description :
 * created by josie at 2020/3/20
 */
object DateUtils {

    fun string2String(time:String): String {
        val utcTime = "2018-01-31T14:32:19Z"
        val df = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        df.timeZone = TimeZone.getTimeZone("UTC")
        val after = df.parse(utcTime)
        System.out.println(after)

        df.applyPattern("yyyy-MM-dd")
        df.timeZone = TimeZone.getDefault()
        println(df.format(after))
        return df.format(after)
    }


}