package com.booknara.practice.gson

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class JsonConverterTest {
    @Before
    fun setup() {
    }

    @Test
    fun test1() {
        println("test1")
        val jsonString = "{'apple' : '5', 'banana' : '5', 'citrus' : '5', 'durian' : '5'}"
        val gson = Gson()
        val fruitType = object : TypeToken<Map<String?, String?>?>() {}.type
        val fruitMap = gson.fromJson<Map<String, String>>(jsonString, fruitType)
        //    System.out.println("size: " + fruitMap.size());
        //    System.out.println("size: " + fruitMap.get("apple"));
        Assert.assertEquals(4, fruitMap.size.toLong())
    }

    @After
    fun teardown() {
    }
}
