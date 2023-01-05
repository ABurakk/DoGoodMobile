//
//  VolunteeringListItem.swift
//  iosApp
//
//  Created by Ahmet Burak Ilhan on 5.01.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct VolunteeringListItem: View {
    let volunteering: Volunteering
    let onVolunteeringButtonClick: (String) -> Void

    var body: some View {
        HStack {
            HStack {
                VStack(alignment: .center) {
                    Text(volunteering.day)
                        .font(.system(size: 26, weight: .semibold))
                        .foregroundColor(Color.onBackground)
                    Text(volunteering.month)
                        .font(.system(size: 14))
                        .foregroundColor(Color.onBackground)
                }

                Text(volunteering.title)
                    .font(.system(size: 16))
                    .foregroundColor(Color.onBackground)
                    .frame(maxWidth: 200)
                    .lineLimit(2)
                    .padding(16)
            }

            Text(volunteering.location.city)
                .font(.system(size: 16, weight: .bold))
                .foregroundColor(Color.onBackground)
                .padding(.trailing, 4)
                .padding(.leading, 16)
            
        }
        .padding(16)
        .padding(.horizontal, 16)
        .background(Color.white)
        .cornerRadius(12)
        .overlay(
            RoundedRectangle(cornerRadius: 12)
                .stroke(Color.gray, lineWidth: 0.8)
        )
        .onTapGesture {
            self.onVolunteeringButtonClick(String(self.volunteering.id))
        }
    }
}


struct VolunteeringListItem_Previews: PreviewProvider {
    static var previews: some View {
        VolunteeringListItem(volunteering: MockData().volunteeringList().first!) { _ in }
            .previewLayout(.fixed(width: 300, height: 100))
    }
}

