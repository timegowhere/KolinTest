package com.example.yanghq.kolintest

/**
 * Created by yanghq on 2017/12/6.
 * 1653942463@qq.com
 */
//data class Person(var name: String, var age: Int, var address: String)
public class Person {
    var name: String = "a1ec2f"
    get() = field.toUpperCase()
    set(value){

        println(value)
        field = "Name: $value"
    }
}



