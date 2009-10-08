import net.miginfocom.swing.MigLayout

container(new SlidePanel(footer: createFooter(count)),layout: new MigLayout("fill ","5%[left]5%","")) {
 label("Testing Plugins", cssClass: "title", constraints: "center, wrap")
 label("FEST", icon: imageIcon(resource: "griffon-icon-24x24.png", class: DeckView),
       cssClass: "desc", constraints: "wrap")
 label("   Fluent interface for Swing testing", cssClass: "desc", constraints: "wrap")
 label("Easyb", icon: imageIcon(resource: "griffon-icon-24x24.png", class: DeckView),
       cssClass: "desc", constraints: "wrap")
 label("   Behavior Driven Development", cssClass: "desc", constraints: "wrap")
 label("Codenarc", icon: imageIcon(resource: "griffon-icon-24x24.png", class: DeckView),
       cssClass: "desc", constraints: "wrap")
 label("   Static code analysis", cssClass: "desc", constraints: "wrap")
 label("Code-coverage", icon: imageIcon(resource: "griffon-icon-24x24.png", class: DeckView),
       cssClass: "desc", constraints: "wrap")
 label("   Code coverage via Cobertura", cssClass: "desc", constraints: "wrap")
 label("JDepend", icon: imageIcon(resource: "griffon-icon-24x24.png", class: DeckView),
       cssClass: "desc", constraints: "wrap")
 label("   Package metrics", cssClass: "desc", constraints: "wrap")
}