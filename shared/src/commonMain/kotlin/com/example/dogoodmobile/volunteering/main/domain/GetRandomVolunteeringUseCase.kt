package com.example.dogoodmobile.volunteering.main.domain

import com.example.dogoodmobile.core.domain.Volunteering
import com.example.dogoodmobile.core.util.Resource

class GetRandomVolunteeringUseCase(
    private val client: MainScreenClient
) {
    suspend fun execute(): Resource<Volunteering> {
        return try {
            Resource.Success(client.getRandomVolunteering())
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }
}