import net.miginfocom.swing.MigLayout

container(new SlidePanel(footer: createFooter(count)),layout: new MigLayout("fill ","[center][center][center]","[center]")) {
  label(icon: imageIcon(resource: "grails-icon-128x128.png", class: DeckView))
  label("->", cssClass: "title")
  label(icon: imageIcon(resource: "griffon-icon-128x128.png", class: DeckView))
}