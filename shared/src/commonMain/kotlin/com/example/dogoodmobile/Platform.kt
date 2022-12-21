package com.example.dogoodmobile

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform