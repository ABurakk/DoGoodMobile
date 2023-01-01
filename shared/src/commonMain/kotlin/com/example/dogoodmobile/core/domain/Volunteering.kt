package com.example.dogoodmobile.core.domain

@kotlinx.serialization.Serializable
data class Volunteering(
    val id: Int,
    val type: VolunteeringType,
    val title: String,
    val detail: String,
    val ownerName: String,
    val location: Location,
    val tags: List<String> = listOf(),
    val day: String = "28",
    val month: String = "April"
)
