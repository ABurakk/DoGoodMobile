package com.example.dogoodmobile.android.di

import com.example.dogoodmobile.volunteering.detail.data.VolunteeringDetailClientImpl
import com.example.dogoodmobile.volunteering.detail.domain.GetVolunteeringDetailUseCase
import com.example.dogoodmobile.volunteering.detail.domain.VolunteeringDetailClient
import com.example.dogoodmobile.volunteering.main.data.MainScreenClientImpl
import com.example.dogoodmobile.volunteering.main.domain.GetRandomVolunteeringUseCase
import com.example.dogoodmobile.volunteering.main.domain.MainScreenClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMainScreenClient(): MainScreenClient {
        return MainScreenClientImpl()
    }

    @Provides
    @Singleton
    fun provideVolunteeringDetailScreenClient(): VolunteeringDetailClient {
        return VolunteeringDetailClientImpl()
    }

    @Provides
    @Singleton
    fun provideGetRandomVolunteeringUseCase(
        client: MainScreenClient
    ): GetRandomVolunteeringUseCase {
        return GetRandomVolunteeringUseCase(client = client)
    }

    @Provides
    @Singleton
    fun provideGetVolunteeringDetailUseCase(
        client: VolunteeringDetailClient
    ): GetVolunteeringDetailUseCase {
        return GetVolunteeringDetailUseCase(client)
    }
}