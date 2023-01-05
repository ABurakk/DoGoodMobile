//
//  ClickableTag.swift
//  iosApp
//
//  Created by Ahmet Burak Ilhan on 5.01.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ClickableTagButton: View {
    let type: VolunteeringType
    let onClick: (VolunteeringType) -> Void
    
    var body: some View {
        Button(
            action: {
                self.onClick(self.type)
            },
            label: {
                Text(type.name).foregroundColor(Color.black)
            }
        )
        .padding(.horizontal, 10)
        .padding(.vertical, 8)
        .background(Color.lightBlueGrey)
        .cornerRadius(12)
    }
}

struct ClickableTagButton_Previews: PreviewProvider {
    static var previews: some View {
        ClickableTagButton(type: VolunteeringType.education, onClick: { type in print(type.title)})
    }
}

