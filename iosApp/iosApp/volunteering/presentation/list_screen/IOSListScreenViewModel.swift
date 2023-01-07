//
//  IOSListScreenViewModel.swift
//  iosApp
//
//  Created by Ahmet Burak Ilhan on 7.01.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared


extension ListScreen{
    @MainActor class IOSListScreenViewModel: ObservableObject {
        private var getVolunteeringListUseCase : GetVolunteeringListUseCase
        private let viewmodel : ListScreenViewModel
    
        @Published var state = ListScreenState(volunteeringList: [], isLoading: false, errorText: nil)
        
        private var handle: Kotlinx_coroutines_coreDisposableHandle?
        
        init(getVolunteeringListUseCase: GetVolunteeringListUseCase) {
            self.getVolunteeringListUseCase = getVolunteeringListUseCase
            self.viewmodel = ListScreenViewModel(coroutineScope: nil, getVolunteeringListUseCase: getVolunteeringListUseCase)
        }
        
        func onEvent(event : ListScreenEvent){
            self.viewmodel.onEvent(event: event)
        }
        
        func startObserving() {
            handle = viewmodel.state.subscribe(onCollect: { state in
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
