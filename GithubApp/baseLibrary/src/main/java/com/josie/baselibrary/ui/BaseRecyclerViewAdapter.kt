package com.josie.baselibrary.ui

import android.content.Context
import android.support.v7.widget.RecyclerView

/**
 * @description : Base adapter of RecyclerView
 * created by josie at 2020/3/20
 */
abstract class BaseRecyclerViewAdapter<T, VH : RecyclerView.ViewHolder>(var mContext: Context) :
    RecyclerView.Adapter<VH>() {
    var dataList: MutableList<T> = mutableListOf()
    var mOnItemClickListener: OnItemClickListener<T>? = null

    fun setData(d: MutableList<T>) {
        dataList = d
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.setOnClickListener {
            if (mOnItemClickListener != null) {
                mOnItemClickListener!!.onItemClick(dataList[position], position)
            }
        }
    }

    interface OnItemClickListener<in T> {
        fun onItemClick(item: T, position: Int)
    }

    fun setOnItemClickListener(l: OnItemClickListener<T>) {
        this.mOnItemClickListener = l
    }
}