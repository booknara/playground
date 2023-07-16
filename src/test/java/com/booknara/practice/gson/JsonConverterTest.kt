package com.booknara.practice.gson

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class JsonConverterTest {
  private val gson = Gson()

  @Before
  fun setup() {
  }

  @Test
  fun test1() {
    val jsonString = "{'apple' : '5', 'banana' : '5', 'citrus' : '5', 'durian' : '5'}"
    val fruitType = object : TypeToken<Map<String?, String?>?>() {}.type
    val fruitMap = gson.fromJson<Map<String, String>>(jsonString, fruitType)
    Assert.assertEquals(4, fruitMap.size.toLong())
  }

  @Test
  fun test2() {
    val jsonString = "{'apple' : '5', 'banana' : '10', 'citrus' : '15', 'durian' : '20'}"
    val model = gson.fromJson(jsonString, Model1::class.java)
    Assert.assertEquals(model.apple, "5")
    Assert.assertEquals(model.banana, "10")
  }

  @Test
  fun test3() {
    val jsonString = """{"id":1,"description":"Test"}""";
    val model = gson.fromJson(jsonString, Model2::class.java)
    Assert.assertEquals(model.id, 1)
    Assert.assertEquals(model.description, "Test")
  }

  @Test
  fun test4() {
    val jsonString = "[ 100, 500, 300, 200, 400 ]";
    val model = gson.fromJson(jsonString, Model3::class.java)
    Assert.assertEquals(model.size, 5)
    Assert.assertEquals(model[1]::class, Int::class)
  }

  @Test
  fun test5() {
    val jsonString = """
      [
        {
          color: "red",
          value: "#f00"
        },
        {
          color: "green",
          value: "#0f0"
        },
        {
          color: "blue",
          value: "#00f"
        },
        {
          color: "cyan",
          value: "#0ff"
        },
        {
          color: "magenta",
          value: "#f0f"
        },
        {
          color: "yellow",
          value: "#ff0"
        },
        {
          color: "black",
          value: "#000"
        }
      ]      
    """.trimIndent()
    val model = gson.fromJson(jsonString, Model4::class.java)
    Assert.assertEquals(model.size, 7)
    Assert.assertEquals(model[1].color::class, String::class)
    Assert.assertEquals(model[1].value::class, String::class)
  }

  @Test
  fun test6() {
    val jsonString = """
      {
        color: "red",
        value: "#f00"
      }
    """.trimIndent()
    val model = gson.fromJson(jsonString, Color::class.java)
    Assert.assertEquals(model::class, Color::class)
  }

  @Test
  fun test7() {
    val jsonString = """
      {
      	"id": "0001",
      	"type": "donut",
      	"name": "Cake",
      	"ppu": 0.55,
      	"batters":
      		{
      			"batter":
      				[
      					{ "id": "1001", "type": "Regular" },
      					{ "id": "1002", "type": "Chocolate" },
      					{ "id": "1003", "type": "Blueberry" },
      					{ "id": "1004", "type": "Devil's Food" }
      				]
      		},
      	"topping":
      		[
      			{ "id": "5001", "type": "None" },
      			{ "id": "5002", "type": "Glazed" },
      			{ "id": "5005", "type": "Sugar" },
      			{ "id": "5007", "type": "Powdered Sugar" },
      			{ "id": "5006", "type": "Chocolate with Sprinkles" },
      			{ "id": "5003", "type": "Chocolate" },
      			{ "id": "5004", "type": "Maple" }
      		]
      }
    """.trimIndent()
    val model = gson.fromJson(jsonString, Model5::class.java)
    Assert.assertEquals(model::class, Model5::class)
  }

  @Test
  fun test8() {
    val jsonString = """
      [
      	{
      		"id": "0001",
      		"type": "donut",
      		"name": "Cake",
      		"ppu": 0.55,
      		"batters":
      			{
      				"batter":
      					[
      						{ "id": "1001", "type": "Regular" },
      						{ "id": "1002", "type": "Chocolate" },
      						{ "id": "1003", "type": "Blueberry" },
      						{ "id": "1004", "type": "Devil's Food" }
      					]
      			},
      		"topping":
      			[
      				{ "id": "5001", "type": "None" },
      				{ "id": "5002", "type": "Glazed" },
      				{ "id": "5005", "type": "Sugar" },
      				{ "id": "5007", "type": "Powdered Sugar" },
      				{ "id": "5006", "type": "Chocolate with Sprinkles" },
      				{ "id": "5003", "type": "Chocolate" },
      				{ "id": "5004", "type": "Maple" }
      			]
      	},
      	{
      		"id": "0002",
      		"type": "donut",
      		"name": "Raised",
      		"ppu": 0.55,
      		"batters":
      			{
      				"batter":
      					[
      						{ "id": "1001", "type": "Regular" }
      					]
      			},
      		"topping":
      			[
      				{ "id": "5001", "type": "None" },
      				{ "id": "5002", "type": "Glazed" },
      				{ "id": "5005", "type": "Sugar" },
      				{ "id": "5003", "type": "Chocolate" },
      				{ "id": "5004", "type": "Maple" }
      			]
      	},
      	{
      		"id": "0003",
      		"type": "donut",
      		"name": "Old Fashioned",
      		"ppu": 0.55,
      		"batters":
      			{
      				"batter":
      					[
      						{ "id": "1001", "type": "Regular" },
      						{ "id": "1002", "type": "Chocolate" }
      					]
      			},
      		"topping":
      			[
      				{ "id": "5001", "type": "None" },
      				{ "id": "5002", "type": "Glazed" },
      				{ "id": "5003", "type": "Chocolate" },
      				{ "id": "5004", "type": "Maple" }
      			]
      	}
      ]
    """.trimIndent()
    val model = gson.fromJson(jsonString, Model6::class.java)
    Assert.assertEquals(model::class, Model6::class)
  }

  @Test
  fun test9() {
    val jsonString = """
      {
      	"id": "0001",
      	"type": "donut",
      	"name": "Cake",
      	"image":
      		{
      			"url": "images/0001.jpg",
      			"width": 200,
      			"height": 200
      		},
      	"thumbnail":
      		{
      			"url": "images/thumbnails/0001.jpg",
      			"width": 32,
      			"height": 32
      		}
      }
    """.trimIndent()
    val model = gson.fromJson(jsonString, Model7::class.java)
    Assert.assertEquals(model::class, Model7::class)
    Assert.assertEquals(model.image::class, Image::class)
    Assert.assertEquals(model.thumbnail::class, Image::class)
  }

  @Test
  fun test10() {
    val jsonString = """
      {
      	"items":
      		{
      			"item":
      				[
      					{
      						"id": "0001",
      						"type": "donut",
      						"name": "Cake",
      						"ppu": 0.55,
      						"batters":
      							{
      								"batter":
      									[
      										{ "id": "1001", "type": "Regular" },
      										{ "id": "1002", "type": "Chocolate" },
      										{ "id": "1003", "type": "Blueberry" },
      										{ "id": "1004", "type": "Devil's Food" }
      									]
      							},
      						"topping":
      							[
      								{ "id": "5001", "type": "None" },
      								{ "id": "5002", "type": "Glazed" },
      								{ "id": "5005", "type": "Sugar" },
      								{ "id": "5007", "type": "Powdered Sugar" },
      								{ "id": "5006", "type": "Chocolate with Sprinkles" },
      								{ "id": "5003", "type": "Chocolate" },
      								{ "id": "5004", "type": "Maple" }
      							]
      					}
      				]
      		}
      }
    """.trimIndent()
    val model = gson.fromJson(jsonString, Model8::class.java)
    Assert.assertEquals(model::class, Model8::class)
    Assert.assertEquals(model.items.item[0]::class, Model5::class)
  }

  @After
  fun teardown() {
  }
}
