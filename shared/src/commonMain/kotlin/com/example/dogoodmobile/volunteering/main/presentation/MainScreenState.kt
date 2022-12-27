package com.example.dogoodmobile.volunteering.main.presentation

import com.example.dogoodmobile.core.domain.Volunteering

data class MainScreenState(
    val isVolunteeringListBoxExpanded: Boolean = false,
    val randomVolunteeringAd: Volunteering? = null,
    val errorText: String? = null,
    val isLoading: Boolean = false
)