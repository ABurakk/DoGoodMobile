package com.example.dogoodmobile.volunteering.main.data

import MockData
import com.example.dogoodmobile.core.domain.Volunteering
import com.example.dogoodmobile.volunteering.main.domain.MainScreenClient

class MainScreenClientImpl : MainScreenClient {
    override suspend fun getRandomVolunteering(): Volunteering {
        return MockData.volunteeringList().random()
    }
}