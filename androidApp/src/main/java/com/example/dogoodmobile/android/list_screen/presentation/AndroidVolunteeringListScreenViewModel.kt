package com.example.dogoodmobile.android.list_screen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogoodmobile.volunteering.list.domain.GetVolunteeringListUseCase
import com.example.dogoodmobile.volunteering.list.presentation.ListScreenEvent
import com.example.dogoodmobile.volunteering.list.presentation.ListScreenViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AndroidVolunteeringListScreenViewModel @Inject constructor(
    private val getVolunteeringListUseCase: GetVolunteeringListUseCase
) : ViewModel() {

    private val viewModel by lazy {
        ListScreenViewModel(
            getVolunteeringListUseCase = getVolunteeringListUseCase,
            coroutineScope = viewModelScope
        )
    }

    val state = viewModel.state

    fun onEvent(event: ListScreenEvent) {
        viewModel.onEvent(event)
    }
}