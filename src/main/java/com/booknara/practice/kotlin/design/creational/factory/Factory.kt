package com.booknara.practice.kotlin.design.creational.factory

import com.booknara.practice.kotlin.design.creational.factory.FacebookController.getFacebookName

class User private constructor(val nickName: String) {
    // Factory using companion object
    companion object {
        fun newSubscribingUser(email: String) = User(email.substringBefore('@'))

        fun newFacebookUser(accountId: Int) = User(getFacebookName(accountId))
    }
}

object FacebookController {
    fun getFacebookName(accountId: Int) = accountId.toString()
}

fun main() {
    val subscribingUser = User.newSubscribingUser("abc@a.com")
    val facebookUser = User.newFacebookUser(4)
}
