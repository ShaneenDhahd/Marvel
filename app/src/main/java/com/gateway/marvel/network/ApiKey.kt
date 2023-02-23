package com.gateway.marvel.network

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

object ApiKey {

    const val AUTH = "ca74e2a96a3f354a8dc3bf07a0bf62db"
    const val PRIVATE_AUTH = "7fb18a94606dfed5fb88d5cb940d8c445128521f"
    val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()
    fun hash(): String {
        val input = "$timeStamp$PRIVATE_AUTH$AUTH"
        val md = MessageDigest.getInstance("MD5")
        return  BigInteger(1, md.digest(input.toByteArray())).toString(16)
    }
}