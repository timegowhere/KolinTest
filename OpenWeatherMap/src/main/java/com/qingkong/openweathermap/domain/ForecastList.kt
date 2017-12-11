package com.qingkong.openweathermap.domain

/**
 * Created by yanghq on 2017/12/11.
 * 1653942463@qq.com
 */
data class ForecastList(val city:String,val country:String,val dailyForecast:List<Forecast>)
data class Forecast(val date:String,val description:String,val high:Int,val low:Int)