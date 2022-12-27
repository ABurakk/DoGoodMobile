package com.example.dogoodmobile.volunteering.detail.presentation

import com.example.dogoodmobile.core.domain.Volunteering

data class DetailScreenState(
    val volunteering: Volunteering? = null,
    val isLoading: Boolean = false,
    val errorText: String? = null,
)