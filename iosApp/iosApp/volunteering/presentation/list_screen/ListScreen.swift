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
    var typeId: String
    var body: some View {
        LazyVStack{
            TypeRowView(){ type in
                print(type)
            }.alignmentGuide(.top) { d in d[.top] }.padding(.top, 20).padding(.bottom, 20).padding(.trailing,12).padding(.leading,12)
        }
        Spacer()
            .navigationBarTitle("List",displayMode: .inline)
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
                    }
                }
            }
        }
    }
}
