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
        VStack(alignment: .leading){
            Image(viewModel.state.volunteering?.type.title.lowercased() ?? "").resizable().cornerRadius(16).frame(width: .infinity,height: 250).padding(.leading, 16).padding(.trailing, 16).padding(.top, 4).alignmentGuide(.top){ d in d[.top] }
            
            Text(viewModel.state.volunteering?.title ?? "")
                .padding(.leading,16)
                .padding(.top,8)
                .padding(.bottom,8)
                .font(.system(size: 24, weight: .semibold)).alignmentGuide(.leading) { _ in 0 }
            
            Divider().frame(height: 1).overlay(.gray).padding(.leading,16).padding(.trailing,16).padding(.bottom,8)
            
            HStack{
                VolunteeringButton(
                    iconSource: "house.fill",
                    color: .primary,
                    name: "",
                    isTextVisible: false,
                    isNavigationEnable: false,
                    onClick: {  }
                ).padding(.leading,16)
                
                VStack(alignment: .leading){
                    Text(viewModel.state.volunteering?.ownerName ?? "")
                        .padding(.bottom,8)
                        .font(.system(size: 16, weight: .bold)).alignmentGuide(.top) { _ in 0 }
                    
                    Spacer()
                    
                    var city = viewModel.state.volunteering?.location.city ?? ""
                    var country = viewModel.state.volunteering?.location.country ?? ""
                    
                    Text(city+", "+country)
                        .padding(.bottom,8)
                        .font(.system(size: 12, weight: .semibold)).alignmentGuide(.bottom) { _ in 0 }
                    
                }.frame(height: 54)
                
               
                
            }.alignmentGuide(.leading) { _ in 0 }
            
            Divider().frame(height: 1).overlay(.gray).padding(.leading,16).padding(.trailing,16)
            
            VStack(alignment: .leading){
                Text("Volunteering Detail")
                    .padding(.bottom,8)
                    .font(.system(size: 20, weight: .bold)).alignmentGuide(.top) { _ in 0 }
                
                Text(viewModel.state.volunteering?.detail ?? "")
                    .padding(.bottom,8)
                    .font(.system(size: 12, weight: .semibold))
                
            }.padding(.leading,20).padding(.top,8).alignmentGuide(.leading) { _ in 0 }
            
            
            Divider().frame(height: 1).overlay(.gray).padding(.leading,16).padding(.trailing,16)
            
            LazyVGrid(columns: [GridItem(.flexible()), GridItem(.flexible()), GridItem(.flexible())]){
                ForEach(viewModel.state.volunteering?.tags ?? [], id: \.self) { item in
                    Tag(text: item.capitalized)
                    }
            }.padding(.leading,16).padding(.trailing,16).padding(.bottom,8).padding(.top,8)
            
            HStack {
                Button(action:{
                    
                }){
                    Text("Contact Now")
                        .font(.system(size: 16))
                        .fontWeight(.bold)
                        .foregroundColor(.white)
                        .padding(.top,16).padding(.bottom,16)
                        .alignmentGuide(.top) { _ in 0 }
                }
            }
            .padding(.top, 6)
            .padding(.bottom, 6)
            .frame(maxWidth: .infinity)
            .background(Color.accentViolet)
            .cornerRadius(12)
            .padding(.horizontal, 24)
            
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
