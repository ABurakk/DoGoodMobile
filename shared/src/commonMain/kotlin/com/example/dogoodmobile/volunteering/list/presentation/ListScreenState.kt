package com.example.dogoodmobile.volunteering.list.presentation

import com.example.dogoodmobile.core.domain.Volunteering

data class ListScreenState(
    val volunteeringList: List<Volunteering> = listOf(),
    val isLoading: Boolean = false,
    val errorText: String? = null,
)