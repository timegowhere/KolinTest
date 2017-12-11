package com.qingkong.openweathermap.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.qingkong.openweathermap.R
import com.qingkong.openweathermap.domain.Forecast
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

/**
 * Created by yanghq on 2017/12/8.
 * 1653942463@qq.com
 */

class ForecastListAdapter(private val forecastList: List<Forecast>, val onItemClick:(Forecast)->Unit, val onItemLongClick: (Forecast) -> Boolean) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return forecastList.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
//        val forecase  = forecastList[position]
//        holder!!.textView.text = "${forecase.date}-${forecase.description}-${forecase.high}/${forecase.low}"
//        with(forecastList[position]){
//            holder!!.textView.text="$date-$description-$high/$low"
//            holder?.setDataToView(iconUrl,date,description,high,low)
//        }
        holder?.setDataToView(forecastList[position])

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
//        val tv = TextView(parent?.context)
//        return ViewHolder(tv)

        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(itemView,onItemClick, onItemLongClick)
    }

    public interface OnItemClickListener {
        operator fun invoke(forecast: Forecast)
    }

    class ViewHolder(itemView: View, val onItemClick: (Forecast) -> Unit, val onItemLongClick: (Forecast) -> Boolean) : RecyclerView.ViewHolder(itemView) {
        private val iconView: ImageView
        private val dateView: TextView
        private val descriptionView: TextView
        private val maxTemperatureView: TextView
        private val minTemperatureView: TextView

        init {
            iconView = itemView.find(R.id.icon)
            dateView = itemView.find(R.id.date)
            descriptionView = itemView.find(R.id.description)
            maxTemperatureView = itemView.find(R.id.maxTemperature)
            minTemperatureView = itemView.find(R.id.minTemperature)

        }


        fun setDataToView(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.context).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = high.toString()
                minTemperatureView.text = low.toString()
                itemView.setOnClickListener {
                    //                    onItemClick?.invoke(forecast)
                    onItemClick(forecast)
                }


                itemView.setOnLongClickListener{
                    onItemLongClick(forecast)
                }
            }
        }
    }


}