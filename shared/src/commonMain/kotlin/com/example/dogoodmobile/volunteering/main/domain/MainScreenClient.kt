package com.example.dogoodmobile.volunteering.main.domain

import com.example.dogoodmobile.core.domain.Volunteering

interface MainScreenClient {
    suspend fun getRandomVolunteering(): Volunteering
}