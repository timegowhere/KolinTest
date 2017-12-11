package com.qingkong.openweathermap.Utils

import com.google.gson.Gson
import com.qingkong.openweathermap.bean.ForecastResult
import java.net.URL

/**
 * Created by yanghq on 2017/12/11.
 * 1653942463@qq.com
 */
public class ForecastRequest(val zipCode: String) {
    //http://api.openweathermap.org/data/2.5/forecast/daily?q=London&mode=json&units=metric&cnt=7&appid=13ade03601eb8eb756321a63a30e9ef3
    companion object {
        private val APP_ID = "13ade03601eb8eb756321a63a30e9ef3"

        private val HTTP_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7"
        val COMPLETE_URL = "$HTTP_URL&APPID=$APP_ID&q="
    }

    fun execute(): ForecastResult {

        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}
