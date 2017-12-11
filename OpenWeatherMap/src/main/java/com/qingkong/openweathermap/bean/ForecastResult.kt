package com.qingkong.openweathermap.bean

/**
 * Created by yanghq on 2017/12/11.
 * 1653942463@qq.com
 */
data class ForecastResult(val city: City,val list:List<Forecast>)

/*{
    "id": 1790645,
    "name": "Xiamen",
    "coord": {
    "lon": 118.0819,
    "lat": 24.4798
},
    "country": "CN",
    "population": 0
}*/
data class City(val id: Long, val name: String, val coord: Coord, val country: String, val population: Int)

data class Coord(val lon: Float, val lat: Float)

/*
{
    "dt": 1512964800,
    "temp": {
    "day": 20.32,
    "min": 12.18,
    "max": 20.4,
    "night": 12.18,
    "eve": 17.33,
    "morn": 18
},
    "pressure": 1023.93,
    "humidity": 76,
    "weather": [
    {
        "id": 800,
        "main": "Clear",
        "description": "sky is clear",
        "icon": "01d"
    }
    ],
    "speed": 8.06,
    "deg": 42,
    "clouds": 0
}*/
data class Forecast(val dt:Long,val temp:Temp,val pressure:Float,val humidity:Int,val weather:List<Weather>,val speed:Float,val deg:Int,val clouds:Int,val rain: Float)
data class Temp(val day:Float,val min:Float,val max:Float,val night:Float,val eve:Float,val morn:Float)
data class Weather(val id:Int,val main:String,val description:String,val icon:String)
