# DoGoodMobile

![Component 1](https://user-images.githubusercontent.com/64445944/211906897-93bddf88-b38a-49a8-a373-1c1fbebe8a38.png)

DoGoodMobile app is designed to help users find and connect with volunteering opportunities. 
The App aims to simplify the process of finding and connecting with volunteering opportunities 
and make easy for people to find their passion and help the society at the same time.

The app's main screen allows users to browse through different types of volunteering opportunities. Users can also see featured volunteering projects on the main screen, which are highlighted for easy visibility and can be accessed with a simple tap. These featured projects lead users to a detailed project page.

Additionally, the app includes a volunteering screen where users can view a list of available volunteering projects, organized by type. Users can switch between different types of projects to find the opportunities that best align with their interests.

Finally, the detail screen provides detailed information about the chosen project and contact information for the organization hosting it. This allows users to learn more about the project and get in touch with the organization to learn more about how to get involved.


## What is the problem ?
The problem that the DoGoodMobile app is trying to solve is the difficulty that individuals may have in finding and connecting with volunteering opportunities that align with their interests.


## Who is experiencing the problem ?

The app is aimed at people who want to volunteer their free time and make a positive impact in their community, but are experiencing challenges in identifying and participating in volunteer projects that align with their interests and are located in their area.

## Why is it important to adress this problem ?
Finding and connecting with volunteering opportunities can be a problem because of lack of information and difficulty in finding the right opportunities that align with the individual's interests. Addressing this problem is important as it allows individuals to give back to their communities and make a positive impact, while also providing personal benefits. DoGoodMobile app aims to make it easy for people to find and connect with volunteer opportunities, which will increase participation and ultimately benefit the society.

https://user-images.githubusercontent.com/64445944/211913764-cd8ed90e-a9a6-4493-a600-528ae8e2bc4e.MP4


## DoGood Mobile with KMM

| What                                    | How                                                                                                                                                                             |
|-----------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 🖥️ User Interface (Android, iOS) | Jetpack Compose / SwiftUI                                                                                                          |
| 🧩 Architecture                         | MVI + Clean Architecture                                                                                                        |
| 💉 DI (Android)                         | Hilt                                                                                                                                                 |
| 🔃 Async                                | Coroutines + Kotlin Flow + Flow Classes for IOS | |
                                

* Data Related Classes: 100% of the code, including the parts that handle communicating with remote APIs and returning mock data for local usage.
* Domain Layer Classes : Almost %100 of code shared: Mapping lists, CommonFlow, CommonMutableStateFlow, and data classes such as Volunteering and Volunteering Type.
* Presentation Layer: In this project, I followed the Model-View-Intent (MVI) pattern and I shared 100% of the event and state classes, which include Screen's logic (text value, navigation etc.) . Alongiside these classes, I shared the majority of the logic within the ViewModel class, but since we have some platform-specific features, such as the ViewModel's scope in Android or @Published in IOS, I implemented separate viewmodels for each platform to use these and shared viewmodels.

I tried to explain my approach for sharing viewmodel in this [medium article](https://ahmetburakilhan.medium.com/eb1c10f17e2b)

###  DoGood Mobile Data
The current version of the DoGoodMobile app uses a set of pre-populated, static data stored locally on the device, allowing users to test and explore the user interface without the need for any additional setup or configuration.
For the prod version of the app, we need to connect the endponits which implemented on another BE project that uses Ktor and MongoDB. Here is the link of BE.
[Ktor BE](https://github.com/ABurakk/com.dogoodmobile.dogoodmobile) 
## What are the next steps for DoGood Mobile

* Adding a feature for users to create and post their own volunteering opportunities. This could involve creating a new screen within the app where users can input information about their volunteer opportunity, such as the type of work, location, time commitments, and contact information.
* Enable the communication functionality to the app: This includes allowing users to easily contact the organization hosting the volunteer opportunity through the app itself, rather than redirecting them to the mail app.

## LICENCE
DoGood Mobile is distributed under the terms of the MIT License.
