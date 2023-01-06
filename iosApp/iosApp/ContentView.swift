import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greeting()

    private let appModule = AppModule()
    
	var body: some View {
        
        NavigationView {
            
            MainScreen(getRandomVolunteeringUseCase: appModule.getRandomVolunteeringUseCase)
                .navigationTitle("Home")
                .navigationBarTitleDisplayMode(.inline)
        }
        
        
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
