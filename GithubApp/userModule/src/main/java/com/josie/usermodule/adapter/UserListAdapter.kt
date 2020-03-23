package com.josie.usermodule.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.josie.baselibrary.common.loadUrl
import com.josie.baselibrary.common.loadUrlRound
import com.josie.baselibrary.ui.BaseRecyclerViewAdapter
import com.josie.usermodule.R
import com.josie.usermodule.data.protocol.UserInfo
import kotlinx.android.synthetic.main.item_user_list.view.*

/**
 * @description :
 * created by josie at 2020/3/21
 */
class UserListAdapter(context: Context) : BaseRecyclerViewAdapter<UserInfo, UserListAdapter.ViewHolder>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_user_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val model = dataList[position]
        holder.itemView.mAvatarItem.loadUrlRound(model.avatar_url)
        val max:Int=38
        var name=model.login+ " "+model.score
        if (name.length>max){
            name=model.login.substring(0,max-4-model.score.toString().length)+"..."+model.score
        }
        holder.itemView.mNameItem.text = name
        holder.itemView.mUrlItem.text = model.html_url
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}