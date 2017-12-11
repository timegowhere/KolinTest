package com.qingkong.openweathermap

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.qingkong.openweathermap.domain.Forecast
import com.qingkong.openweathermap.domain.ForecastList

/**
 * Created by yanghq on 2017/12/8.
 * 1653942463@qq.com
 */

class ForecastListAdapter(private val forecastList: List<Forecast>): RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return forecastList.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val forecase  = forecastList[position]
        holder!!.textView.text = "${forecase.date}-${forecase.description}-${forecase.high}/${forecase.low}"
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val tv = TextView(parent?.context)
        return ViewHolder(tv)
    }

    class ViewHolder(val textView:TextView):RecyclerView.ViewHolder(textView)

}