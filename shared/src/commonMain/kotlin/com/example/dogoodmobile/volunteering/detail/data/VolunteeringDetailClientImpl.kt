package com.example.dogoodmobile.volunteering.detail.data

import MockData
import com.example.dogoodmobile.core.domain.Volunteering
import com.example.dogoodmobile.volunteering.detail.domain.VolunteeringDetailClient

class VolunteeringDetailClientImpl : VolunteeringDetailClient {
    override suspend fun getVolunteeringDetailById(id: Int): Volunteering {
        return MockData.volunteeringList().filter { it.id == id }[0]
    }
}