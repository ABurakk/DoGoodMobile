package com.example.dogoodmobile.volunteering.list.data

import MockData
import com.example.dogoodmobile.core.domain.Volunteering
import com.example.dogoodmobile.core.domain.VolunteeringType
import com.example.dogoodmobile.volunteering.list.domain.VolunteeringListClient

class VolunteeringListClientImpl : VolunteeringListClient {
    override suspend fun getVolunteeringByTypeAndLocation(
        type: VolunteeringType
    ): List<Volunteering> {
        return MockData.volunteeringList()
            .filter {
                it.type == type
            }
    }
}