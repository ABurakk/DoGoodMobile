package com.example.dogoodmobile.android.main_screen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogoodmobile.volunteering.main.domain.GetRandomVolunteeringUseCase
import com.example.dogoodmobile.volunteering.main.presentation.MainScreenEvent
import com.example.dogoodmobile.volunteering.main.presentation.MainScreenViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AndroidMainScreenViewModel @Inject constructor(
    private val getRandomVolunteeringUseCase: GetRandomVolunteeringUseCase
) : ViewModel() {

    private val viewModel by lazy {
        MainScreenViewModel(
            getRandomVolunteeringUseCase = getRandomVolunteeringUseCase,
            coroutineScope = viewModelScope
        )
    }
    val state = viewModel.state

    fun onEvent(event: MainScreenEvent) {
        viewModel.onEvent(event)
    }
}