package com.qingkong.openweathermap.domain

import com.qingkong.openweathermap.bean.Forecast
import com.qingkong.openweathermap.bean.ForecastResult
import java.text.DateFormat
import java.util.*
import com.qingkong.openweathermap.domain.Forecast as ModelForecast

/**
 * Created by yanghq on 2017/12/11.
 * 1653942463@qq.com
 */
public class ForecastDataMapper{
    fun convertFromDataModel(forecast:ForecastResult):ForecastList{
        return ForecastList(forecast.city.name,forecast.city.country,convertForecastListToDomain(forecast.list))
    }
    private fun convertForecastListToDomain(list:List<Forecast>):List<ModelForecast>{
        return list.map {
            convertForecastItemToDomain(it)
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt),forecast.weather[0].description,forecast.temp.max.toInt(),forecast.temp.min.toInt(),
                generateIconUrl(forecast.weather[0].icon))
    }

    private fun generateIconUrl(iconCode: String): String {
        return "http://openweathermap.org/img/w/$iconCode.png"
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.FULL, Locale.getDefault())

        return df.format(date *1000)
    }
}