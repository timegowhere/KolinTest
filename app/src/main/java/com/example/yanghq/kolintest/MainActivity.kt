package com.example.yanghq.kolintest

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.UiThread
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import java.net.URL

class MainActivity : AppCompatActivity(), ForecastListAdapter.OnItemOnClickListener {
    override fun OnClickEvent(position: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        Toast.makeText(this,"position=="+position,Toast.LENGTH_SHORT).show()
        test()
        toast("position == "+position)
    }
    public class Request(val url: String) {
        public fun run() {
            println("开始请求数据")
            val forecastJsonStr = URL(url).readText()
            Log.d(javaClass.simpleName, forecastJsonStr)
        }
    }
    fun request( url: String) {
        val forecastJsonStr = URL(url).readText()
        Log.e("晴空","forecastJsonStr=="+forecastJsonStr)
        println(forecastJsonStr)

    }
    private val items = listOf(
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
//        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ForecastListAdapter(items)
        recyclerView.adapter = adapter
        adapter.onClicklistener = this

    }
    fun test(){
        val str = "http://api.m.mtime.cn/PageSubArea/TrailerList.api"
        doAsync {
//            Request(str).run()
            request(str)
            uiThread {
                toast("异步线程")
            }
        }
//        async {
//            request(str)
//            uiThread {
//                toast("异步线程")
//            }
//        }

    }




}
