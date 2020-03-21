package com.josie.baselibrary.utils

import android.util.Log

/**
 * @description :
 * created by josie at 2020/3/20
 */
object LogUtils {

    fun user(vararg s: String) {
        val sb1 = StringBuffer()
        for (s0 in s) {
            sb1.append("====$s0")
        }
        Log.d("User>>>>", getHeadSuffix() + "====" + sb1.toString())
    }

    fun base(vararg s: String) {
        val sb1 = StringBuffer()
        for (s0 in s) {
            sb1.append("====$s0")
        }
        Log.d("Base>>>>", getHeadSuffix() + "====" + sb1.toString())
    }

    fun error(vararg s: String) {
        val sb1 = StringBuffer()
        for (s0 in s) {
            sb1.append("====$s0")
        }
        Log.e("Error>>>>", getHeadSuffix() + "====" + sb1.toString())
    }

    fun d(vararg s: String) {
        val sb1 = StringBuffer()
        for (s0 in s) {
            sb1.append("====$s0")
        }
        Log.d("d>>>>", getHeadSuffix() + "====" + sb1.toString())
    }

    //Thread.currentThread().getStackTrace()返回的是一个StackTraceElement数组，内容为调用函数堆栈，并且以调用层级关系保存。
    //STACK_TRACE_INDEX = 3是因为Android是下标为3获取方法名， 纯Java是下标为2获取方法名。
    private val STACK_TRACE_INDEX = 4//用3会打印当前UtilTips相关信息,4会深入一级打印调取位置相关信息
    private val SUFFIX = ".java"
    fun getHeadSuffix(): String {
        try {
            //获取调用的函数堆栈信息
            val stackTrace = Thread.currentThread().stackTrace
            val targetElement = stackTrace[STACK_TRACE_INDEX]

            //获取类名
            var className = targetElement.className
            val classNameInfo =
                className.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            if (classNameInfo.size > 0) {
                className = classNameInfo[classNameInfo.size - 1] + SUFFIX
            }

            //获取内部类
            if (className.contains("$")) {
                className =
                    className.split("\\$".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[0] + SUFFIX
            }
            //获取当前方法名
            val methodName = targetElement.methodName

            //获取当前行号
            var lineNumber = targetElement.lineNumber

            if (lineNumber < 0) {
                lineNumber = 0
            }

            //输出信息
            val sb = StringBuffer()
            sb.append(methodName.substring(0, 1).toUpperCase())
            sb.append(methodName.substring(1))
            val methodNameShort = sb.toString()

            val sb1 = StringBuffer()
            sb1.append("[ (")
            sb1.append(className)
            sb1.append(":")
            sb1.append(lineNumber)
            sb1.append(")#")
            sb1.append("$methodNameShort()")
            sb1.append(" ] ")
            return sb1.toString()
        } catch (e: Exception) {
            return "[]"
        }

    }


}