package com.booknara.practice.kotlin.annotation

import com.booknara.practice.kotlin.User
import java.util.*
import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME) // by default retention is runtime
@Target(AnnotationTarget.PROPERTY)
annotation class JsonExclude

annotation class JsonName(val name: String)

annotation class DeserializeInterface(val targetClass: KClass<out Any>)

annotation class CustomSerializer(
    val serializerClass: KClass<out ValueSerializer<*>>
)

interface Company {
    val name: String
}

data class CompanyImpl(override val name: String) : Company

data class Person(
    val name: String,
    @DeserializeInterface(CompanyImpl::class) val company: Company,
    @CustomSerializer(DateSerializer::class) val birthDate: Date
)

fun sum(x: Int, y: Int) = x + y

fun main() {
    val user = User("Alice", 29)
    val kClass = user.javaClass.kotlin
    println(kClass.simpleName)

}