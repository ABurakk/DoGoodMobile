//
//  IOSMainScreenViewModel.swift
//  iosApp
//
//  Created by Ahmet Burak Ilhan on 5.01.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared


import Foundation
import shared

extension MainScreen {
    @MainActor class IOSMainScreenViewModel: ObservableObject {
        private var getRandomVolunteeringUseCase: GetRandomVolunteeringUseCase
        
        private let viewModel: MainScreenViewModel
        
        @Published var state: MainScreenState = MainScreenState(
            isVolunteeringListBoxExpanded: false,
            randomVolunteeringAd: nil,
            errorText: nil,
            isLoading: false
        )
        private var handle: Kotlinx_coroutines_coreDisposableHandle?
        
        init(getRandomVolunteeringUseCase: GetRandomVolunteeringUseCase) {
            self.getRandomVolunteeringUseCase = getRandomVolunteeringUseCase
            self.viewModel = MainScreenViewModel(coroutineScope: nil, getRandomVolunteeringUseCase: getRandomVolunteeringUseCase)
        }
        
        func onEvent(event: MainScreenEvent) {
            self.viewModel.onEvent(event: event)
        }
        
        func startObserving() {
            handle = viewModel.state.subscribe(onCollect: { state in
                if let state = state {
                    self.state = state
                }
            })
        }
        
        func dispose() {
                    handle?.dispose()
                }
    }
}
