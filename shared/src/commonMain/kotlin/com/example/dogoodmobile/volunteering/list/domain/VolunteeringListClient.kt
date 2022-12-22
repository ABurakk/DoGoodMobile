package com.example.dogoodmobile.volunteering.list.domain

import com.example.dogoodmobile.core.domain.Volunteering
import com.example.dogoodmobile.core.domain.VolunteeringType

interface VolunteeringListClient {
    suspend fun getVolunteeringByTypeAndLocation(
        type: VolunteeringType,
        country: String?,
        city: String?
    ): List<Volunteering>
}