package com.booknara.practice.kotlin

import kotlin.reflect.KAnnotatedElement

fun <T> Iterable<T>.joinToStringBuilder(builder: StringBuilder,
                                        separator: CharSequence = ", ",
                                        prefix: CharSequence = "",
                                        postfix: CharSequence = "",
                                        limit: Int = -1,
                                        truncated: CharSequence = "...",
                                        callback: ((T) -> Unit)? = null): StringBuilder {
  return joinTo(builder, separator, prefix, postfix, limit, truncated) {
    if (callback == null) return@joinTo it.toString()
    callback(it)
    ""
  }
}

inline fun <reified T> KAnnotatedElement.findAnnotation(): T? = annotations.filterIsInstance<T>().firstOrNull()