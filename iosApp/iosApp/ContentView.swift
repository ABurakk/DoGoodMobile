import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greeting()

    private let appModule = AppModule()
    
	var body: some View {
        MainScreen(getRandomVolunteeringUseCase: appModule.getRandomVolunteeringUseCase)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
