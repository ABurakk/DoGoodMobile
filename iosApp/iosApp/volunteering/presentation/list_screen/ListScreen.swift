//
//  ListScreen.swift
//  iosApp
//
//  Created by Ahmet Burak Ilhan on 7.01.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared


struct ListScreen: View {
    private let appModule = AppModule()
    var type: VolunteeringType
    
    private var getVolunteeringListUseCase : GetVolunteeringListUseCase
    @ObservedObject var viewModel : IOSListScreenViewModel
    
    init(type: VolunteeringType) {
        self.type = type
        self.getVolunteeringListUseCase = appModule.getVolunteeringListUseCase
        self.viewModel = IOSListScreenViewModel(getVolunteeringListUseCase: getVolunteeringListUseCase)
    }
    
    var body: some View {
        LazyVStack{
            TypeRowView(){ type in
                viewModel.onEvent(event: ListScreenEvent.LoadVolunteeringListByType(type: type))
            }.alignmentGuide(.top) { d in d[.top] }.padding(.top, 20).padding(.bottom, 20).padding(.trailing,12).padding(.leading,12)
            
            VolunteeringList(list: viewModel.state.volunteeringList)
        }
        Spacer()
            .navigationBarTitle("List",displayMode: .inline)
        
            .onAppear{
                viewModel.startObserving()
                viewModel.onEvent(event: ListScreenEvent.LoadVolunteeringListByType(type: type))
            }
            .onDisappear{
                viewModel.dispose()
            }
    }
}

struct TypeRowView: View {
    let typeArray : [VolunteeringType]  = [.homelessness,.immigration,.animalRescue,.education, .medical, .socialServices, .elderCare, .disasterRelief, .hunger]
    let onTypeButtonClick : (VolunteeringType) -> Void
    
    var body: some View {
        ScrollView(.horizontal){
            LazyHStack{
                ForEach(typeArray, id: \.self) { item in
                    ClickableTagButton(type:item){ type in
                        onTypeButtonClick(type)
                    }.padding(.trailing,4)
                }
            }
        }
    }
}

struct VolunteeringList: View{
    var list : [Volunteering]
    var body: some View{
        ScrollView(.vertical){
            LazyVStack {
                ForEach(list, id: \.self){ item in
                    VolunteeringListItem(volunteering: item).padding(.trailing,12).padding(.leading,12)
                    
                    Spacer(minLength: 12)
                }
            }
        }
    }
}
