package com.booknara.practice.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

public class JsonConverter {
  public static void main(String[] args) {
    String jsonString = "{'apple' : '5', 'banana' : '5', 'citrus' : '5', 'durian' : '5'}";
    Gson gson = new Gson();
    Type fruitType = new TypeToken<Map<String, String>>() {}.getType();
    Map<String, String> fruitMap = gson.fromJson(jsonString, fruitType);
    System.out.println("size: " + fruitMap.size());
    System.out.println("size: " + fruitMap.get("apple"));
//    Assert.assertEquals(3, fruitMap.size());
//    Assert.assertEquals(Employee.class, fruitMap.get("banana").getClass());
  }
}
