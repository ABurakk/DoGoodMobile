package com.example.dogoodmobile.di

import com.example.dogoodmobile.volunteering.list.data.VolunteeringListClientImpl
import com.example.dogoodmobile.volunteering.list.domain.GetVolunteeringListUseCase
import com.example.dogoodmobile.volunteering.list.domain.VolunteeringListClient
import com.example.dogoodmobile.volunteering.main.data.MainScreenClientImpl
import com.example.dogoodmobile.volunteering.main.domain.GetRandomVolunteeringUseCase
import com.example.dogoodmobile.volunteering.main.domain.MainScreenClient

class AppModule {
    private val mainScreenClient: MainScreenClient by lazy {
        MainScreenClientImpl()
    }

    private val listScreenClient: VolunteeringListClient by lazy {
        VolunteeringListClientImpl()
    }

    val getRandomVolunteeringUseCase: GetRandomVolunteeringUseCase by lazy {
        GetRandomVolunteeringUseCase(mainScreenClient)
    }

    val getVolunteeringListUseCase: GetVolunteeringListUseCase by lazy {
        GetVolunteeringListUseCase(client = listScreenClient)
    }
}