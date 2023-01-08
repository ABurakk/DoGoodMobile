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
    val day: String,
    val month: String,
    val ownerMailAddress: String = ""
)
