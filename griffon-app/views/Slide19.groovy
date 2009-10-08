import net.miginfocom.swing.MigLayout

container(new SlidePanel(footer: createFooter(count)),layout: new MigLayout("fill ","5%[left]5%","")) {
 label("Built-in Testing", cssClass: "title", constraints: "center, wrap")
 label("creat-app adds an integration test per controller", icon: imageIcon(resource: "griffon-icon-24x24.png", class: DeckView),
       cssClass: "desc", constraints: "wrap")
 label("same goes for create-mvc", icon: imageIcon(resource: "griffon-icon-24x24.png", class: DeckView),
       cssClass: "desc", constraints: "wrap")
 label("create-unit adds a new test", icon: imageIcon(resource: "griffon-icon-24x24.png", class: DeckView),
       cssClass: "desc", constraints: "wrap")
 label("test-app runs all tests", icon: imageIcon(resource: "griffon-icon-24x24.png", class: DeckView),
       cssClass: "desc", constraints: "wrap")
}