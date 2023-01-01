package com.example.dogoodmobile.volunteering.list.presentation

import com.example.dogoodmobile.core.util.Resource
import com.example.dogoodmobile.core.util.toCommonStateFlow
import com.example.dogoodmobile.volunteering.list.domain.GetVolunteeringListUseCase
import com.example.dogoodmobile.volunteering.list.presentation.ListScreenEvent.LoadVolunteeringListByType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ListScreenViewModel(
    coroutineScope: CoroutineScope?,
    private val getVolunteeringListUseCase: GetVolunteeringListUseCase
) {
    private val viewModelScope = coroutineScope ?: CoroutineScope(Dispatchers.Main)
    private val _state = MutableStateFlow(ListScreenState())

    val state =
        _state.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ListScreenState())
            .toCommonStateFlow()

    fun onEvent(event: ListScreenEvent) {
        when (event) {
            is ListScreenEvent.ErrorSeen -> {
                _state.update {
                    it.copy(
                        errorText = null
                    )
                }
            }
            is LoadVolunteeringListByType -> {
                viewModelScope.launch {
                    val result = getVolunteeringListUseCase.execute(type = event.type)
                    when (result) {
                        is Resource.Error -> {
                            _state.update {
                                it.copy(errorText = result.throwable?.message)
                            }
                        }
                        is Resource.Success -> {
                            _state.update {
                                it.copy(volunteeringList = result.data ?: listOf())
                            }
                        }
                    }
                }
            }
            else -> Unit
        }
    }
}