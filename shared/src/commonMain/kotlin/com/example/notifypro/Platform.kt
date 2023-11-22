package com.example.notifypro

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform