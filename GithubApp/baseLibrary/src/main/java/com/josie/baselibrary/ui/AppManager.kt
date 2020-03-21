package com.josie.baselibrary.ui

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

/**
 * @description : collect Activity
 * created by josie at 2020/3/20
 */
class AppManager private constructor() {
    companion object {
        val instance: AppManager by lazy { AppManager() }
    }

    private val activityStack: Stack<Activity> = Stack()

    fun addActivity(activity: Activity) {
        activityStack.add(activity)
    }

    fun finishActivity(activity: Activity) {
        activity.finish()
        activityStack.remove(activity)
    }

    fun currentActivity(): Activity {
        return activityStack.lastElement()
    }

    fun finishAllActivity() {
        for (activity in activityStack) {
            activity.finish()
        }
        activityStack.clear()
    }

    fun exitApp(context: Context) {
        finishAllActivity()
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.killBackgroundProcesses(context.packageName)
        System.exit(0)
        for (activity in activityStack) {
            activity.finish()
        }
        activityStack.clear()
    }
}