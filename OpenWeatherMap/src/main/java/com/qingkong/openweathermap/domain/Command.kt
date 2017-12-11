package com.qingkong.openweathermap.domain

/**
 * Created by yanghq on 2017/12/11.
 * 1653942463@qq.com
 */
public interface Command<T>{
    fun execute():T
}