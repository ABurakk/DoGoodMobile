//
//  ProfileHeadline.swift
//  iosApp
//
//  Created by Ahmet Burak Ilhan on 5.01.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct ProfileHeadline: View {
    let onStartClick: () -> Void

    var body: some View {
        ZStack(alignment: .leading) {
            HStack {
                Text("Start New \nVolunteering Project")
                    .font(.system(size: 16))
                    .fontWeight(.bold)
                    .foregroundColor(.white)
                    .padding(16)

                Button(
                    action: onStartClick
                ) {
                    Text("Start Now")
                        .font(.system(size: 14))
                        .fontWeight(.semibold)
                        .foregroundColor(Color.black)
                        .padding(.horizontal, 20)
                        .frame(height: 42)
                }.background(Color.background)
                    .cornerRadius(12)
                    .padding(.trailing,9)
            }
            .padding(.top, 6)
            .padding(.bottom, 6)
            .frame(maxWidth: .infinity)
            .background(Color.accentViolet)
            .cornerRadius(12)
            
        }
        .padding(.horizontal, 32)
    }
}

struct ProfileHeadline_Previews: PreviewProvider {
    static var previews: some View {
        ProfileHeadline{
            
        }
    }
}
