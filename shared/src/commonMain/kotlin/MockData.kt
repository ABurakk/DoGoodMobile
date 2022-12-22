import com.example.dogoodmobile.core.domain.Location
import com.example.dogoodmobile.core.domain.Volunteering
import com.example.dogoodmobile.core.domain.VolunteeringType

object MockData {
    fun volunteeringList() = listOf(
        Volunteering(
            1,
            VolunteeringType.EDUCATION,
            "Math class for 8-10 years students",
            "Teacher needed for 5 hours a week",
            "Municipality",
            Location("Turkey", "Ankara")
        ),
        Volunteering(
            2,
            VolunteeringType.MEDICAL,
            "Health clinic volunteer",
            "Assist with patient intake and record-keeping",
            "Community Health Center",
            Location("United States", "New York")
        ),
        Volunteering(
            3,
            VolunteeringType.SOCIAL_SERVICES,
            "Food bank volunteer",
            "Help sort and distribute donations",
            "Food Bank Inc.",
            Location("United States", "Chicago")
        ),
        Volunteering(
            4,
            VolunteeringType.ELDER_CARE,
            "Elder care volunteer",
            "Assist with daily activities and provide companionship",
            "Senior Living Facility",
            Location("United States", "Los Angeles")
        ),
        Volunteering(
            5,
            VolunteeringType.HOMELESSNESS,
            "Homeless shelter volunteer",
            "Help prepare and serve meals, provide support to residents",
            "Homeless Shelter Inc.",
            Location("United States", "Miami")
        ),
        Volunteering(
            6,
            VolunteeringType.IMMIGRATION,
            "Immigration assistance volunteer",
            "Help with document translation and legal assistance",
            "Immigration Legal Aid Society",
            Location("United States", "San Francisco")
        ),
        Volunteering(
            7,
            VolunteeringType.ANIMAL_RESCUE,
            "Animal rescue volunteer",
            "Assist with animal care and feeding at the shelter",
            "Animal Rescue League",
            Location("United States", "Dallas")
        ),
        Volunteering(
            8,
            VolunteeringType.DISASTER_RELIEF,
            "Disaster relief volunteer",
            "Assist with disaster response and recovery efforts",
            "Disaster Relief Agency",
            Location("United States", "Houston")
        ),
        Volunteering(
            9,
            VolunteeringType.HUNGER,
            "Hunger relief volunteer",
            "Help prepare and distribute meals to those in need",
            "Hunger Relief Organization",
            Location("United States", "Atlanta")
        ),
        Volunteering(
            10,
            VolunteeringType.EDUCATION,
            "English language class for adults",
            "Teacher needed for 2 hours a week",
            "Community Center",
            Location("France", "Paris")
        ),

        Volunteering(
            11,
            VolunteeringType.SOCIAL_SERVICES,
            "Beach clean-up volunteer",
            "Help clean up the beach and protect marine life",
            "Environmental Protection Agency",
            Location("Spain", "Barcelona")
        ),

        Volunteering(
            12,
            VolunteeringType.MEDICAL,
            "Hospital volunteer",
            "Assist with patient care and non-medical tasks",
            "General Hospital",
            Location("Germany", "Berlin")
        ),

        Volunteering(
            13,
            VolunteeringType.ANIMAL_RESCUE,
            "Animal shelter volunteer",
            "Help care for and socialize with the animals",
            "Animal Shelter Society",
            Location("Italy", "Rome")
        )
    )
}