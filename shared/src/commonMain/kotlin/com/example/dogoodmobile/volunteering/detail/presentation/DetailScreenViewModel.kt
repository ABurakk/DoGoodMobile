package com.example.dogoodmobile.volunteering.detail.presentation

import com.example.dogoodmobile.core.util.Resource
import com.example.dogoodmobile.core.util.toCommonStateFlow
import com.example.dogoodmobile.volunteering.detail.domain.GetVolunteeringDetailUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailScreenViewModel(
    private val coroutineScope: CoroutineScope?,
    private val getVolunteeringById: GetVolunteeringDetailUseCase
) {

    private val viewModelScope = coroutineScope ?: CoroutineScope(Dispatchers.Main)
    private val _state = MutableStateFlow(DetailScreenState())
    val state =
        _state.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), DetailScreenState())
            .toCommonStateFlow()

    fun onEvent(event: DetailScreenEvent) {
        when (event) {
            is DetailScreenEvent.LoadVolunteeringDetail -> {
                viewModelScope.launch {
                    val result = getVolunteeringById.execute(id = event.id.toInt())
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
                                    volunteering = it.volunteering
                                )
                            }
                        }
                    }
                }
            }
            else -> Unit
        }
    }
}