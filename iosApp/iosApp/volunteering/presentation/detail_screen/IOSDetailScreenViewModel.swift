//
//  IOSDetailScreenViewModel.swift
//  iosApp
//
//  Created by Ahmet Burak Ilhan on 8.01.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared


extension DetailScreen {
    @MainActor class IOSDetailScreenViewModel : ObservableObject {
        private var getDetailUseCase : GetVolunteeringDetailUseCase
        
        private let viewModel : DetailScreenViewModel
        
        
        @Published var state = DetailScreenState(volunteering: nil, isLoading: false, errorText: nil)
        
        private var handle: Kotlinx_coroutines_coreDisposableHandle?
        
        init(getDetailUseCase: GetVolunteeringDetailUseCase) {
            self.getDetailUseCase = getDetailUseCase
            self.viewModel = DetailScreenViewModel(coroutineScope: nil, getVolunteeringById: getDetailUseCase)
        }
        
        func onEvent(event : DetailScreenEvent){
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
