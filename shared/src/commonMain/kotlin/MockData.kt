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
            Location("Turkey", "Ankara"),
            listOf("Education", "Tutoring", "Math", "Children", "Students"),
            day = "12",
            month = "May",
            ownerMailAddress = "charlie@gmail.com"
        ),
        Volunteering(
            2,
            VolunteeringType.MEDICAL,
            "Health clinic volunteer",
            "Assist with patient intake and record-keeping",
            "Community Health Center",
            Location("United States", "New York"),
            listOf("Medical", "Healthcare", "Volunteer", "Clinic", "Patient care"),
            day = "17",
            month = "April",
            ownerMailAddress = "alice@gmail.com"
        ),
        Volunteering(
            3,
            VolunteeringType.SOCIAL_SERVICES,
            "Food bank volunteer",
            "Help sort and distribute donations",
            "Food Bank Inc.",
            Location("United States", "Chicago"),
            listOf("Social services", "Volunteer", "Food bank", "Donations"),
            day = "3",
            month = "January",
            ownerMailAddress = "bob@gmail.com"
        ),
        Volunteering(
            4,
            VolunteeringType.ELDER_CARE,
            "Elder care volunteer",
            "Assist with daily activities and provide companionship",
            "Senior Living Facility",
            Location("United States", "Los Angeles"),
            listOf("Elder care", "Volunteer", "Daily activities", "Companionship", "Senior living"),
            day = "23",
            month = "October",
            ownerMailAddress = "george@gmail.com"
        ),
        Volunteering(
            5,
            VolunteeringType.HOMELESSNESS,
            "Homeless shelter volunteer",
            "Help prepare and serve meals, provide support to residents",
            "Homeless Shelter Inc.",
            Location("United States", "Miami"),
            listOf(
                "Homelessness",
                "Volunteer",
                "Meal preparation",
                "Meal service",
                "Support",
                "Shelter"
            ),
            day = "9",
            month = "November",
            ownerMailAddress = "julia@gmail.com"
        ),
        Volunteering(
            6,
            VolunteeringType.IMMIGRATION,
            "Immigration assistance volunteer",
            "Help with document translation and legal assistance",
            "Immigration Legal Aid Society",
            Location("United States", "San Francisco"),
            listOf(
                "Immigration",
                "Volunteer",
                "Translation",
                "Legal assistance"
            ),
            day = "11",
            month = "November",
            ownerMailAddress = "kotlin@gmail.com"
        ),
        Volunteering(
            7,
            VolunteeringType.ANIMAL_RESCUE,
            "Animal rescue volunteer",
            "Assist with animal care and feeding at the shelter",
            "Animal Rescue League",
            Location("United States", "Dallas"),
            listOf(
                "Animal rescue",
                "Volunteer",
                "Animal care",
                "Feeding",
                "Shelter"
            ),
            day = "19",
            month = "November",
            ownerMailAddress = "george@gmail.com"
        ),
        Volunteering(
            8,
            VolunteeringType.DISASTER_RELIEF,
            "Disaster relief volunteer",
            "Assist with disaster response and recovery efforts",
            "Disaster Relief Agency",
            Location("United States", "Houston"),
            listOf(
                "Disaster relief",
                "Volunteer",
                "Disaster response",
                "Recovery efforts"
            ),
            day = "5",
            month = "March",
            ownerMailAddress = "alice@gmail.com"
        ),
        Volunteering(
            9,
            VolunteeringType.HUNGER,
            "Hunger relief volunteer",
            "Help prepare and distribute meals to those in need",
            "Hunger Relief Organization",
            Location("United States", "Atlanta"),
            listOf(
                "Hunger",
                "Volunteer",
                "Meal preparation",
                "Meal distribution"
            ),
            day = "15",
            month = "March",
            ownerMailAddress = "bob@gmail.com"
        ),
        Volunteering(
            10,
            VolunteeringType.EDUCATION,
            "English language class for adults",
            "Teacher needed for 2 hours a week",
            "Community Center",
            Location("France", "Paris"),
            tags = listOf("education", "teaching", "language"),
            day = "15",
            month = "July",
            ownerMailAddress = "donald@gmail.com"

        ),

        Volunteering(
            11,
            VolunteeringType.SOCIAL_SERVICES,
            "Beach clean-up volunteer",
            "Help clean up the beach and protect marine life",
            "Environmental Protection Agency",
            Location("Spain", "Barcelona"),
            tags = listOf("environmental", "conservation", "outdoor work"),
            day = "18",
            month = "July",
            ownerMailAddress = "joe@gmail.com"

        ),

        Volunteering(
            12,
            VolunteeringType.MEDICAL,
            "Hospital volunteer",
            "Assist with patient care and non-medical tasks",
            "General Hospital",
            Location("Germany", "Berlin"),
            tags = listOf("healthcare", "hospital work"),
            day = "11",
            month = "July",
            ownerMailAddress = "marc@gmail.com"

        ),

        Volunteering(
            13,
            VolunteeringType.ANIMAL_RESCUE,
            "Animal shelter volunteer",
            "Help care for and socialize with the animals",
            "Animal Shelter Society",
            Location("Italy", "Rome"),
            tags = listOf("animal care", "shelter work", "teamwork", "communication", "patience"),
            day = "8",
            month = "September",
            ownerMailAddress = "bill@gmail.com"

        )
    )
}