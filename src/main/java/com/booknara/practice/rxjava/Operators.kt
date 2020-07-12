package com.booknara.practice.rxjava

import io.reactivex.Observable

fun main() {
    filter()
    map()
    doOnNext()
    reduce()
    buffer()
}

fun filter() {
    Observable.range(1, 10)
            .filter { i -> i % 2 == 0 }
            .subscribe { i -> print("$i ") }
    println()
}

fun map() {
    Observable.range(1, 10)
            .map { i -> i * 2 }
            .subscribe { i -> print("$i ") }
    println()

    Observable.just(8, 9, 10)
            .filter { i -> i % 3 > 0 }
            .map { i -> (i * 10).toString() }
            .filter { s -> s.length < 4}
            .subscribe { s -> print("$s ") }
    println()
}

fun doOnNext() {
    Observable.just(8, 9, 10)
            .doOnNext { i -> print("A: $i ") }
            .filter { i -> i % 3 > 0 }
            .doOnNext { i -> print("B: $i ") }
            .map { i -> "#" + (i * 10).toString() }
            .doOnNext { s -> print("C: $s ") }
            .filter { s -> s.length < 4}
            .subscribe { s -> print("D: $s ") }
    println()
}

fun reduce() {
    Observable.range(1, 1000)
            .filter { x -> x % 3 == 0 }
            .distinct()
            .reduce { x: Int, y: Int -> x + y }
            .map { x -> Integer.toHexString(x) }
            .subscribe { s -> print("$s ") }
}

fun buffer() {
    Observable.range(1, 9)
            .buffer(1, 2)
            .concatMapIterable { x -> x }
            .map { x -> x.toString() }
            .subscribe { s -> print("$s ") }
}



