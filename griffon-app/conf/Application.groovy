application {
	title="Ebay"
	startupGroups=["init"]
	autoShutdown=true
}
mvcGroups {
	init {
		model="InitModel"
		controller="InitController"
		view="InitView"
	}
	deck {
		model="DeckModel"
		controller="DeckController"
		view="DeckView"
	}
}
