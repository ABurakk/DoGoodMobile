package com.example.dogoodmobile.core.domain

@kotlinx.serialization.Serializable
data class Location(
    val country: String,
    val city: String
)
