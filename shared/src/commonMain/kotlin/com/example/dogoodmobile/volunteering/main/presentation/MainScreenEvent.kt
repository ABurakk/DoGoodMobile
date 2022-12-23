package com.example.dogoodmobile.volunteering.main.presentation

sealed class MainScreenEvent {
    data class ChooseVolunteeringType(val id: String) : MainScreenEvent()
    data class ClickRandomVolunteeringAd(val id: String) : MainScreenEvent()
    object ClickExpandOrCloseVolunteeringTypes : MainScreenEvent()
    object ErrorSeen : MainScreenEvent()
}