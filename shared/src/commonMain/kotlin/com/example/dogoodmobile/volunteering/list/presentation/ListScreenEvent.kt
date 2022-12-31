package com.example.dogoodmobile.volunteering.list.presentation

import com.example.dogoodmobile.core.domain.VolunteeringType

sealed class ListScreenEvent {
    object ClickBackButton : ListScreenEvent()
    object ErrorSeen : ListScreenEvent()
    data class ClickVolunteering(val id: String) : ListScreenEvent()
    data class LoadVolunteeringListByType(val type: VolunteeringType) : ListScreenEvent()
}