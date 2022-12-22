package com.example.dogoodmobile.core.domain

@kotlinx.serialization.Serializable
enum class VolunteeringType(
    val id: String,
    val title: String
) {
    EDUCATION("1", "Education"),
    MEDICAL("2", "Medical"),
    SOCIAL_SERVICES("3", "Social Services"),
    ELDER_CARE("4", "Elder Care"),
    HOMELESSNESS("5", "Homelessness"),
    IMMIGRATION("6", "Immigration"),
    ANIMAL_RESCUE("7", "Animal Rescue"),
    DISASTER_RELIEF("8", "Disaster Relief"),
    HUNGER("9", "Hunger")
}