//
//  VolunteeringButton.swift
//  iosApp
//
//  Created by Ahmet Burak Ilhan on 5.01.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

import SwiftUI
import shared

struct VolunteeringButton: View {
    let iconSource: String
    let color: Color
    let name: String
    let isTextVisible: Bool
    var isNavigationEnable: Bool = true
    var type: VolunteeringType = VolunteeringType.immigration
    let onClick: () -> Void
    
    var body: some View {
        
        if(isNavigationEnable){
            NavigationLink(
                destination: ListScreen(type: self.type)
            ){
                VStack(
                    alignment: .center,
                    spacing: 6,
                    content: {
                        Button(
                            action: {
                                self.onClick()
                            },
                            label: {
                                    Image(systemName: iconSource)
                                        .foregroundColor(color)
                                
                            }
                        )
                        .frame(width: 64, height: 64)
                        .background(Color.lightBlueGrey)
                        .clipShape(RoundedRectangle(cornerRadius: 12))
                        if isTextVisible {
                            Text(name)
                                .font(.system(size: 12, weight: .semibold))
                                .multilineTextAlignment(.center)
                                .foregroundColor(.black)
                        }
                    }
                )
            }
            
        }else{
            VStack(
                alignment: .center,
                spacing: 6,
                content: {
                    Button(
                        action: {
                            self.onClick()
                        },
                        label: {
                                Image(systemName: iconSource)
                                    .foregroundColor(color)
                            
                        }
                    )
                    .frame(width: 64, height: 64)
                    .background(Color.lightBlueGrey)
                    .clipShape(RoundedRectangle(cornerRadius: 12))
                    if isTextVisible {
                        Text(name)
                            .font(.system(size: 12, weight: .semibold))
                            .multilineTextAlignment(.center)
                            .foregroundColor(.black)
                    }
                }
            )

        }
    }
}

struct VolunteeringButton_Previews: PreviewProvider {
    static var previews: some View {
        VolunteeringButton(
            iconSource: "book",
            color: .red,
            name: "Button",
            isTextVisible: true,
            onClick: {
                print("Button clicked")
            }
        )
    }
}

