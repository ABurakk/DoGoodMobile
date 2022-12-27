package com.example.dogoodmobile.android.core.presentation

import com.example.dogoodmobile.android.R
import com.example.dogoodmobile.core.domain.Volunteering
import com.example.dogoodmobile.core.domain.VolunteeringType

data class UiVolunteering(
    val volunteering: Volunteering?
) {
    val drawableRes: Int?
        get() {
            return when (volunteering?.type) {
                VolunteeringType.EDUCATION -> R.drawable.education
                VolunteeringType.MEDICAL -> R.drawable.medical
                VolunteeringType.SOCIAL_SERVICES -> R.drawable.soecialservice
                VolunteeringType.ELDER_CARE -> R.drawable.eldercare
                VolunteeringType.HOMELESSNESS -> R.drawable.homeless
                VolunteeringType.IMMIGRATION -> R.drawable.immigration
                VolunteeringType.ANIMAL_RESCUE -> R.drawable.animalrescue
                VolunteeringType.DISASTER_RELIEF -> R.drawable.disaster
                VolunteeringType.HUNGER -> R.drawable.hunger
                else -> {
                    null
                }
            }
        }
}