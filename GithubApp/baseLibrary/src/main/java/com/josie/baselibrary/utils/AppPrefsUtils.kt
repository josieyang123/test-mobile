package com.josie.baselibrary.utils

import android.content.Context
import android.content.SharedPreferences
import com.josie.baselibrary.common.BaseConstant
import com.josie.baselibrary.ui.BaseApplication

/**
 * @description :
 * created by josie at 2020/3/20
 */
object AppPrefsUtils {
    var sp: SharedPreferences =
        BaseApplication.context.getSharedPreferences(BaseConstant.SP_TABLE, Context.MODE_PRIVATE)
    var ed: SharedPreferences.Editor

    init {
        ed = sp.edit()
    }

    fun putBoolean(key: String, value: Boolean) {
        ed.putBoolean(key, value)
        ed.commit()
    }

    fun getBoolean(key: String): Boolean {
        return sp.getBoolean(key, false)
    }

    fun putString(key: String, value: String) {
        ed.putString(key, value)
        ed.commit()
    }

    fun getString(key: String): String? {
        return sp.getString(key, "")
    }

    fun putLong(key: String, value: Long) {
        ed.putLong(key, value)
        ed.commit()
    }

    fun getLong(key: String): Long {
        return sp.getLong(key, 0)
    }

    fun putInt(key: String, value: Int) {
        ed.putInt(key, value)
        ed.commit()
    }

    fun getInt(key: String): Int {
        return sp.getInt(key, 0)
    }

    fun putStringSet(key: String, set: Set<String>) {
        val localSet = getStringSet(key)?.toMutableSet()
        localSet?.addAll(set)
        ed.putStringSet(key, localSet)
        ed.commit()
    }

    fun getStringSet(key: String): MutableSet<String>? {
        val set = setOf<String>()
        return sp.getStringSet(key, set)
    }

    fun remove(key: String) {
        ed.remove(key)
        ed.commit()
    }
}