//
//  MainScreen.swift
//  iosApp
//
//  Created by Ahmet Burak Ilhan on 5.01.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared


struct MainScreen: View {
    private var getRandomVolunteeringUseCase: GetRandomVolunteeringUseCase
    @ObservedObject var mainScreenViewModel : IOSMainScreenViewModel
    
    
    init(getRandomVolunteeringUseCase: GetRandomVolunteeringUseCase) {
        self.getRandomVolunteeringUseCase = getRandomVolunteeringUseCase
        self.mainScreenViewModel = IOSMainScreenViewModel(getRandomVolunteeringUseCase: getRandomVolunteeringUseCase)
    }
    
    var body: some View {
        VStack{
            ProfileHeadline{
                
            }
        }
        .onAppear{
            mainScreenViewModel.startObserving()
        }
        .onDisappear{
            mainScreenViewModel.dispose()
        }
    }
}
