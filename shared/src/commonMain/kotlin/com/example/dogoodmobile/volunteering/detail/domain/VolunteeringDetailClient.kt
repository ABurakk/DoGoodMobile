package com.example.dogoodmobile.volunteering.detail.domain

import com.example.dogoodmobile.core.domain.Volunteering

interface VolunteeringDetailClient {
    suspend fun getVolunteeringDetailById(
        id: Int
    ): Volunteering
}