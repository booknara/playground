package com.booknara.practice.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

public class JsonConverter {
  public static void main(String[] args) {

    String jsonString = "{'initialization' : '5', 'ptr' : '5', 'auto' : '5', 'back_button' : '5'}";
    Gson gson = new Gson();
    Type empMapType = new TypeToken<Map<String, String>>() {}.getType();
    Map<String, String> nameEmployeeMap = gson.fromJson(jsonString, empMapType);
    System.out.println("size: " + nameEmployeeMap.size());
    System.out.println("size: " + nameEmployeeMap.get("initialization"));
//    Assert.assertEquals(3, nameEmployeeMap.size());
//    Assert.assertEquals(Employee.class, nameEmployeeMap.get("Bob").getClass());
  }
}
