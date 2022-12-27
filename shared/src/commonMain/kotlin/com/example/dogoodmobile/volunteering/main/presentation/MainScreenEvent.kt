package com.example.dogoodmobile.volunteering.main.presentation

sealed class MainScreenEvent {
    data class ChooseVolunteeringType(val id: String) : MainScreenEvent()
    data class ClickRandomVolunteeringAd(val id: String) : MainScreenEvent()
    object ErrorSeen : MainScreenEvent()
    object ClickRefreshFeaturedAd : MainScreenEvent()
}
