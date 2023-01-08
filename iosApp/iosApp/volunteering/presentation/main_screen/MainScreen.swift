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
        VStack(){
                        
            ProfileHeadline{}.alignmentGuide(.top) { d in d[.top] }.padding(.top, 30).padding(.bottom, 20)
            
            VolunteeringTypeIcons{ volunteeringType in print(volunteeringType)}
            
            FeaturedRow{
                mainScreenViewModel.onEvent(event: MainScreenEvent.ClickRefreshFeaturedAd())
            }
            
            FeaturedAd(
                   volunteering: mainScreenViewModel.state.randomVolunteeringAd,volunteeringAdTitle: mainScreenViewModel.state.randomVolunteeringAd == nil ? "a" : mainScreenViewModel.state.randomVolunteeringAd!.type.title.lowercased())
            
            Spacer()
        }
        .onAppear{
            mainScreenViewModel.startObserving()
        }
        .onDisappear{
            mainScreenViewModel.dispose()
        }
    }
}


struct VolunteeringTypeIcons: View {
    @State private var expandedState = true

    var onVolunteeringTypeClicked: (String) -> Void

    var body: some View {
        VStack(alignment: .center) {
            VolunteeringTypeRow1(
                volunteeringTypeExpandState: expandedState,
                expandedStateChanged: { self.expandedState = $0 },
                onVolunteeringTypeClicked: onVolunteeringTypeClicked
            )
            if expandedState {
                VolunteeringTypeRow2(
                    expandedStateChanged: { self.expandedState = $0 },
                    onVolunteeringTypeClicked: onVolunteeringTypeClicked
                )
            }
        }
    }
}


struct VolunteeringTypeRow1: View {
    var volunteeringTypeExpandState: Bool
    var expandedStateChanged: (Bool) -> Void
    var onVolunteeringTypeClicked: (String) -> Void

    var body: some View {
        HStack(spacing: 12) {
            VolunteeringButton(
                iconSource: "stethoscope",
                color: .orange,
                name: "Medical",
                isTextVisible: true,
                type: VolunteeringType.medical,
                onClick: { onVolunteeringTypeClicked(VolunteeringType.medical.id) }
            )
            VolunteeringButton(
                iconSource: "book",
                color: .blue,
                name: "Education",
                isTextVisible: true,
                type: VolunteeringType.education,
                onClick: { onVolunteeringTypeClicked(VolunteeringType.education.id) }
            )
            VolunteeringButton(
                iconSource: "person.line.dotted.person",
                color: .pink,
                name: "Social Services",
                isTextVisible: true,
                type: VolunteeringType.socialServices,
                onClick: { onVolunteeringTypeClicked(VolunteeringType.socialServices.id) }
            )
            if volunteeringTypeExpandState {
                VolunteeringButton(
                    iconSource: "figure.roll",
                    color: .green,
                    name: "Elder Care",
                    isTextVisible: true,
                    type: VolunteeringType.elderCare,
                    onClick: {
                        if volunteeringTypeExpandState {
                            onVolunteeringTypeClicked(VolunteeringType.elderCare.id)
                            return
                        }
                        expandedStateChanged(!volunteeringTypeExpandState)
                    }
                )
            } else {
                VolunteeringButton(
                    iconSource: "arrow.down.to.line",
                    color: .gray,
                    name: "Other",
                    isTextVisible: true,
                    isNavigationEnable: false,
                    onClick: {
                        expandedStateChanged(!volunteeringTypeExpandState)
                    }
                )
            }
        }
    }
}


struct VolunteeringTypeRow2: View {
    var expandedStateChanged: (Bool) -> Void
    var onVolunteeringTypeClicked: (String) -> Void

    var body: some View {
        HStack(spacing: 12) {
            VolunteeringButton(
                iconSource: "pawprint",
                color: .green,
                name: "Animal Rescue",
                isTextVisible: true,
                type: VolunteeringType.animalRescue,
                onClick: { onVolunteeringTypeClicked(VolunteeringType.animalRescue.id) }
            )
            VolunteeringButton(
                iconSource: "house",
                color: .purple,
                name: "Homelessness",
                isTextVisible: true,
                type: VolunteeringType.homelessness,
                onClick: { onVolunteeringTypeClicked(VolunteeringType.homelessness.id) }
            )
            VolunteeringButton(
                iconSource: "figure.wave",
                color: .red,
                name:"Immigration",
                isTextVisible: true,
                type: VolunteeringType.immigration,
                onClick: {onVolunteeringTypeClicked(VolunteeringType.immigration.id)}
            )
            
            VolunteeringButton(
                iconSource: "arrow.up",
                color: .gray,
                name:"Less",
                isTextVisible: true,
                isNavigationEnable: false,
                onClick: {expandedStateChanged(false)}
            )
        }
    }
}


struct FeaturedRow: View {
    
    var onRefreshClicked: () -> Void
    
    var body: some View {
        HStack {
            Text("Featured")
                .font(.system(size: 20))
                .fontWeight(.semibold)
                .padding(.leading, 16)

            Spacer()
            
            Button(action: { onRefreshClicked() }) {
                Image(
                    systemName: "arrow.clockwise"
                )
            }.foregroundColor(.gray)
        }
        .frame(maxWidth: .infinity)
        .padding(.leading, 16).padding(.trailing, 30).padding(.top, 16)
    }
}

struct FeaturedAd: View {
    var volunteering: Volunteering?
    var volunteeringAdTitle: String
    
    var body: some View {
        ZStack(alignment: .bottom) {
            Image(volunteeringAdTitle)
                .resizable()
                .cornerRadius(16)
                
            NavigationLink(destination: DetailScreen(volunteerinID: String(volunteering?.id ?? 1))){
                FeaturedAdInfoButton(volunteering: self.volunteering).padding(16)
            }
            
            
        }.frame(width: .infinity, height: 250).padding(.leading, 16).padding(.trailing, 16).padding(.top, 4)
    }
}


