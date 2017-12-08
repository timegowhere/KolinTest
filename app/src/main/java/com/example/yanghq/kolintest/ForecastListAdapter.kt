package com.example.yanghq.kolintest

import android.graphics.drawable.Drawable
import android.support.v7.widget.DrawableUtils
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.w3c.dom.Text

/**
 * Created by yanghq on 2017/12/7.
 * 1653942463@qq.com
 */
class ForecastListAdapter(val itemList: List<String>): RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    var onClicklistener:OnItemOnClickListener? = null

    interface OnItemOnClickListener{
        fun OnClickEvent( position: Int)
    }
    override fun getItemCount(): Int {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return itemList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val view = TextView(parent.context)
        view.textSize = 20f
        view.gravity = Gravity.CENTER

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        holder.textView.text = itemList[position]
//        holder.textView .setOnClickListener(View.OnClickListener { onClicklistener?.OnClickEvent(position) })
        holder.textView.setOnClickListener { println("position==="+position)  }
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView){
           }
}