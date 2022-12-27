package com.example.dogoodmobile.android.detail_screen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogoodmobile.volunteering.detail.domain.GetVolunteeringDetailUseCase
import com.example.dogoodmobile.volunteering.detail.presentation.DetailScreenEvent
import com.example.dogoodmobile.volunteering.detail.presentation.DetailScreenViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AndroidDetailScreenViewModel @Inject constructor(
    private val getVolunteeringDetailUseCase: GetVolunteeringDetailUseCase
) : ViewModel() {

    private val viewModel by lazy {
        DetailScreenViewModel(
            coroutineScope = viewModelScope,
            getVolunteeringById = getVolunteeringDetailUseCase
        )
    }

    val state = viewModel.state

    fun onEvent(event: DetailScreenEvent) {
        viewModel.onEvent(event)
    }
}