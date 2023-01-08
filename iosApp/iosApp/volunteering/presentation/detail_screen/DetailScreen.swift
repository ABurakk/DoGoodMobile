//
//  DetailScreen.swift
//  iosApp
//
//  Created by Ahmet Burak Ilhan on 7.01.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct DetailScreen: View {
    let volunteerinID : String
    private let appModule = AppModule()
    
    @ObservedObject var viewModel : IOSDetailScreenViewModel
    
    init(volunteerinID: String) {
        self.volunteerinID = volunteerinID
        self.viewModel = IOSDetailScreenViewModel(getDetailUseCase: appModule.getVolunteeringDetailUseCase)
    }
    
    var body: some View {
        VStack(){
            Image(viewModel.state.volunteering?.type.title.lowercased() ?? "").resizable().cornerRadius(16).frame(width: .infinity,height: 250).padding(.leading, 16).padding(.trailing, 16).padding(.top, 4).alignmentGuide(.top){ d in d[.top] }
            
            Spacer()
        }
        .onAppear{
            viewModel.startObserving()
            viewModel.onEvent(event: DetailScreenEvent.LoadVolunteeringDetail(id: volunteerinID))
        }.onDisappear{
            viewModel.dispose()
        }
        
    }
}
