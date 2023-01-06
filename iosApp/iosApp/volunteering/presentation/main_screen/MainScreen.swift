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
            
            VolunteeringTypeIcons{ volunteeringType in
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


struct VolunteeringTypeIcons: View {
    @State private var expandedState = false

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
                onClick: { onVolunteeringTypeClicked(VolunteeringType.medical.id) }
            )
            VolunteeringButton(
                iconSource: "book",
                color: .red,
                name: "Education",
                isTextVisible: true,
                onClick: { onVolunteeringTypeClicked(VolunteeringType.education.id) }
            )
            VolunteeringButton(
                iconSource: "person.line.dotted.person",
                color: .pink,
                name: "Social Services",
                isTextVisible: true,
                onClick: { onVolunteeringTypeClicked(VolunteeringType.socialServices.id) }
            )
            if volunteeringTypeExpandState {
                VolunteeringButton(
                    iconSource: "figure.roll",
                    color: .green,
                    name: "Elder Care",
                    isTextVisible: true,
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
                onClick: { onVolunteeringTypeClicked(VolunteeringType.animalRescue.id) }
            )
            VolunteeringButton(
                iconSource: "house",
                color: .purple,
                name: "Homelessness",
                isTextVisible: true,
                onClick: { onVolunteeringTypeClicked(VolunteeringType.homelessness.id) }
            )
            VolunteeringButton(
                iconSource: "figure.wave",
                color: .red,
                name:"Immigration",
                isTextVisible: true,
                onClick: {onVolunteeringTypeClicked(VolunteeringType.immigration.id)}
            )
            
            VolunteeringButton(
                iconSource: "arrow.up",
                color: .gray,
                name:"Less",
                isTextVisible: true,
                onClick: {expandedStateChanged(false)}
            )
        }
    }
}

