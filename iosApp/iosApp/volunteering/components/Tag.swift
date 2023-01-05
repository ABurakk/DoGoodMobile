//
//  Tag.swift
//  iosApp
//
//  Created by Ahmet Burak Ilhan on 5.01.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct Tag: View {
    let text: String
    
    var body: some View {
        Button(
            action: {},
            label: {
                Text(text).foregroundColor(Color.black)
            }
        )
        .padding(.horizontal, 10)
        .padding(.vertical, 8)
        .background(Color.lightBlueGrey)
        .cornerRadius(12)
    }
}

struct Tag_Previews: PreviewProvider {
    static var previews: some View {
        Tag(text: "Ahmet")
    }
}
