package com.example.dogoodmobile.volunteering.list.domain

import com.example.dogoodmobile.core.domain.Volunteering
import com.example.dogoodmobile.core.domain.VolunteeringType
import com.example.dogoodmobile.core.util.Resource

class GetVolunteeringListUseCase(
    private val client: VolunteeringListClient
) {
    suspend fun execute(
        type: VolunteeringType,
        country: String?,
        city: String?
    ): Resource<List<Volunteering>> {
        return try {
            val volunteeringList = client.getVolunteeringByTypeAndLocation(
                type, country, city
            )
            Resource.Success(volunteeringList)
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }
}