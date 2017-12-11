package com.qingkong.openweathermap.domain

import com.qingkong.openweathermap.Utils.ForecastRequest

/**
 * Created by yanghq on 2017/12/11.
 * 1653942463@qq.com
 */
class RequestForecastCommand(val zipCode:String) :Command<ForecastList>{
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode);
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}