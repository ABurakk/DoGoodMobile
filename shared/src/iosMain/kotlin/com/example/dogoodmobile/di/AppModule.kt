package com.example.dogoodmobile.di

import com.example.dogoodmobile.volunteering.main.data.MainScreenClientImpl
import com.example.dogoodmobile.volunteering.main.domain.GetRandomVolunteeringUseCase
import com.example.dogoodmobile.volunteering.main.domain.MainScreenClient

class AppModule {
    private val client: MainScreenClient by lazy {
        MainScreenClientImpl()
    }


    val getRandomVolunteeringUseCase: GetRandomVolunteeringUseCase by lazy {
        GetRandomVolunteeringUseCase(client)
    }
}