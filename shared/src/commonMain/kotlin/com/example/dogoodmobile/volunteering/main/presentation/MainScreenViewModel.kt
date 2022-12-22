package com.example.dogoodmobile.volunteering.main.presentation

import com.example.dogoodmobile.volunteering.main.domain.GetRandomVolunteeringUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class MainScreenViewModel(
    private val coroutineScope: CoroutineScope?,
    private val getRandomVolunteeringUseCase: GetRandomVolunteeringUseCase,
    private val onNavigate: (MainScreenEvent) -> Unit
) {

    private val viewModelScope = coroutineScope ?: CoroutineScope(Dispatchers.Main)

    private val _state = MutableStateFlow(MainScreenState())
    val state = _state

    init {
        _state.update {
            it.copy(randomVolunteeringAd = it.randomVolunteeringAd)
        }
    }

    fun onEvent(event: MainScreenEvent) {

        when (event) {
            is MainScreenEvent.ChooseVolunteeringType -> {
                onNavigate(event)
            }
            is MainScreenEvent.ClickRandomVolunteeringAd -> {
                onNavigate(event)
            }
        }
    }
}