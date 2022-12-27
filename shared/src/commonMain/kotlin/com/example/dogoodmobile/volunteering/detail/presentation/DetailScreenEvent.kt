package com.example.dogoodmobile.volunteering.detail.presentation

sealed class DetailScreenEvent {
    object ClickBackButton : DetailScreenEvent()
    object ClickContactNow : DetailScreenEvent()
    data class LoadVolunteeringDetail(val id: String) : DetailScreenEvent()
}