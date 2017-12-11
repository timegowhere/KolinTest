package com.qingkong.openweathermap

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.qingkong.openweathermap.Utils.ForecastRequest
import com.qingkong.openweathermap.adapter.ForecastListAdapter
import com.qingkong.openweathermap.domain.Forecast
import com.qingkong.openweathermap.domain.RequestForecastCommand
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread


class MainActivity : AppCompatActivity(),ForecastListAdapter.OnItemClickListener {
    override fun invoke(forecast: Forecast) {
       toast(forecast.date)
        println(forecast.date)
    }

    private val forecastlist= listOf<String>(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycleView.layoutManager = LinearLayoutManager(this)



        doAsync {
            try {
                println(ForecastRequest.COMPLETE_URL)
//                val readText = URL(ForecastRequest.COMPLETE_URL).readText()
//                Log.e("晴空",readText)

//                val forecastResult = ForecastRequest("Xiamen").execute()
//                Log.e("晴空",forecastResult.toString())

//                val dataModel = ForecastDataMapper().convertFromDataModel(forecastResult)
                val dataModel = RequestForecastCommand("Xiamen").execute()
                Log.e("晴空",dataModel.toString())
                Log.e("晴空","size == "+dataModel.size())

                uiThread {
                    var adapter = ForecastListAdapter(dataModel.dailyForecast,{forecast -> toast(forecast.date) },{forecast -> onItemLongClick(forecast) })
//                    var adapter = ForecastListAdapter(dataModel.dailyForecast){forecast -> toast(forecast.date) }
//                    var adapter = ForecastListAdapter(dataModel.dailyForecast){toast(it.date)}

                        recycleView.adapter = adapter

                }
            }catch (e :Exception){
                println("出错")
                println(e.message)
            }


        }
    }
    fun onItemLongClick(forecast: Forecast):Boolean{
        toast(forecast.description)
        return true;
    }
}
