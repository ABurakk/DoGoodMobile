//
//  FeaturedAdInfoButton.swift
//  iosApp
//
//  Created by Ahmet Burak Ilhan on 5.01.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared


struct FeaturedAdInfoButton: View {
    let volunteering: Volunteering?
    
    var body: some View {
        ZStack {
            RoundedRectangle(cornerRadius: 16)
                .foregroundColor(Color.lightBlueGrey)
                .frame(height: 96)
            
            VStack(alignment: .leading, spacing: 0) {
                HStack(alignment: .top, spacing: 0) {
                    VStack(alignment: .leading, spacing: 6) {
                        // Assign intermediate results to variables
                        let title = volunteering?.title ?? ""
                        let ownerName = volunteering?.ownerName ?? ""
                        let country = volunteering?.location.country ?? ""
                        
                        Text(title)
                            .font(.system(size: 18, weight: .semibold))
                            .foregroundColor(Color.onBackground)
                            .frame(maxWidth: 210)
                            .lineLimit(1)
                            .truncationMode(.tail)
                            .padding(.horizontal, 12)
                        
                        Text("by " + ownerName + " at " + country)
                            .font(.system(size: 14, weight: .regular))
                            .foregroundColor(Color.onBackground)
                            .frame(maxWidth: 210)
                            .lineLimit(1)
                            .truncationMode(.tail)
                            .padding(.horizontal, 12)
                            .padding(.bottom, 10)
                    }
                    
                    Button(action: {

                    }) {
                        Image(systemName: "arrow.right")
                            .foregroundColor(.white)
                    }
                    .buttonStyle(PlainButtonStyle())
                    .frame(width: 48, height: 48)
                    .background(Color.accentViolet)
                    .clipShape(RoundedRectangle(cornerRadius: 12))
                }
            }
            
        }
    }
}
