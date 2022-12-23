package com.example.dogoodmobile.volunteering.main.presentation

import com.example.dogoodmobile.core.util.Resource
import com.example.dogoodmobile.core.util.toCommonStateFlow
import com.example.dogoodmobile.volunteering.main.domain.GetRandomVolunteeringUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val coroutineScope: CoroutineScope?,
    private val getRandomVolunteeringUseCase: GetRandomVolunteeringUseCase
) {

    private val viewModelScope = coroutineScope ?: CoroutineScope(Dispatchers.Main)

    private val _state = MutableStateFlow(MainScreenState())
    val state =
        _state.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), MainScreenState())
            .toCommonStateFlow()

    init {
        viewModelScope.launch {
            val result = getRandomVolunteeringUseCase.execute()
            when (result) {
                is Resource.Error -> {
                    _state.update {
                        it.copy(
                            errorText = result.throwable?.message
                        )
                    }
                }
                is Resource.Success -> {
                    _state.update {
                        it.copy(
                            randomVolunteeringAd = result.data
                        )
                    }
                }
            }
        }
    }

    fun onEvent(event: MainScreenEvent) {
        when (event) {
            is MainScreenEvent.ClickExpandOrCloseVolunteeringTypes -> {
                _state.update {
                    it.copy(
                        isVolunteeringListBoxExpanded = it.isVolunteeringListBoxExpanded.not()
                    )
                }
            }
            is MainScreenEvent.ErrorSeen -> {
                _state.update {
                    it.copy(
                        errorText = null
                    )
                }
            }
            else -> Unit
        }
    }
}