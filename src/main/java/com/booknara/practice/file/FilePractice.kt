package com.booknara.practice.file

import java.io.File

fun main() {
  // Replace "file_path.txt" with the actual path to your text file
  val file = File("src/main/java/com/booknara/practice/file/words_with_numbers.txt")

  var count = 0
  // Check if the file exists
  if (file.exists()) {
    // Read and process each line of the file
    file.forEachLine { line ->
      // Perform your desired operation on each line
      //println(line)
      if (line.toIntOrNull() != null) {
        count++
      }
    }
  } else {
    println("File not found.")
  }

  println(count)
}
