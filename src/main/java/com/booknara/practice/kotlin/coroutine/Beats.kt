package com.booknara.practice.kotlin.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.sound.sampled.AudioSystem

fun main() {
    runBlocking {
        launch {
            playBeats("x-x-x-x-x-x-", "audio/toms.aiff")
        }
        playBeats("x-----x-----", "audio/crash_cymbal.aiff")
    }
}

suspend fun playBeats(beats: String, file: String) {
    var parts = beats.split("x")
    var count = 0
    for (part in parts) {
        count += part.length + 1
        if (part == "") {
            playSound(file)
        } else {
            //Thread.sleep(100 * (part.length + 1L))
            delay(100 * (part.length + 1L))
            if (count < beats.length) {
                playSound(file)
            }
        }
    }
}

fun playSound(file: String) {
    val url = object {}.javaClass.classLoader.getResource(file)
    println(url)
    val clip = AudioSystem.getClip()
    val audioInputStream = AudioSystem.getAudioInputStream(url)
    clip.open(audioInputStream)
    clip.start()
}
