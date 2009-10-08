import net.miginfocom.swing.MigLayout

container(new SlidePanel(footer: createFooter(count)),layout: new MigLayout("fill ","5%[left]5%","")) {
 label("Lifecycle", cssClass: "title", constraints: "center, wrap")
 label("Events modeled after JSR 296", cssClass: "desc", constraints: "wrap")
 label("location: griffon-app/lifecycle", cssClass: "desc", constraints: "wrap")
 label("Initialize", icon: imageIcon(resource: "griffon-icon-24x24.png", class: DeckView),
       cssClass: "desc", constraints: "wrap")
 label("Startup", icon: imageIcon(resource: "griffon-icon-24x24.png", class: DeckView),
       cssClass: "desc", constraints: "wrap")
 label("Ready", icon: imageIcon(resource: "griffon-icon-24x24.png", class: DeckView),
       cssClass: "desc", constraints: "wrap")
 label("Shutdown", icon: imageIcon(resource: "griffon-icon-24x24.png", class: DeckView),
       cssClass: "desc", constraints: "wrap")
}