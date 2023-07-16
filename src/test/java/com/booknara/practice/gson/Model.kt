package com.booknara.practice.gson

data class Model1(val apple: String, val banana: String, val citrus: String, val durian: String)

data class Model2(val id: Int, val description: String)

class Model3 : ArrayList<Int>()

class Model4 : ArrayList<Color>()

data class Color(val color: String, val value: String)

data class Model5(
  val id: String,
  val type: String,
  val name: String,
  val ppu: Double,
  val batters: Batters,
  val topping: List<Topping>,
)

data class Batters(val batter: List<Batter>)

data class Batter(val id: String, val type: String)

data class Topping(val id: String, val type: String)

class Model6 : ArrayList<Model5>()

data class Model7(
  val id: String,
  val type: String,
  val name: String,
  val image: Image,
  val thumbnail: Image,
)

data class Image(val url: String, val width: Int, val height: Int)

data class Model8(val items: Items)

data class Items(val item: List<Model5>)

