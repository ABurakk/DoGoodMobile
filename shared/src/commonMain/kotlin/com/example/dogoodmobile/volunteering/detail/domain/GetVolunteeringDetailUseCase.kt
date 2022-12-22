package com.example.dogoodmobile.volunteering.detail.domain

import com.example.dogoodmobile.core.domain.Volunteering
import com.example.dogoodmobile.core.util.Resource

class GetVolunteeringDetailUseCase(
    private val client: VolunteeringDetailClient
) {
    suspend fun execute(
        id: Int
    ): Resource<Volunteering> {

        return try {
            val volunteeringDetail = client.getVolunteeringDetailById(id)
            Resource.Success(volunteeringDetail)
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }
}