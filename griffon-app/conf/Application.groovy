application {
    title = 'Ebay'
    startupGroups = ['init']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "Init"
    'init' {
        model = 'InitModel'
        controller = 'InitController'
        view = 'InitView'
    }

    // MVC Group for "deck"
    'deck' {
        model = 'DeckModel'
        controller = 'DeckController'
        view = 'DeckView'
    }

}
