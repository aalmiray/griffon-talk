import net.miginfocom.swing.MigLayout

container(new SlidePanel(footer: createFooter(count)),layout: new MigLayout("fill ","5%[left]5%","")) {
 label("Configuration", cssClass: "title", constraints: "center, wrap")
 label("Remember your ABCs", cssClass: "desc", constraints: "wrap")
 label("location: griffon-app/conf", cssClass: "desc", constraints: "wrap")
 label("A is for Application", icon: imageIcon(resource: "griffon-icon-24x24.png", class: DeckView),
       cssClass: "desc", constraints: "wrap")
 label("B is for Builder", icon: imageIcon(resource: "griffon-icon-24x24.png", class: DeckView),
       cssClass: "desc", constraints: "wrap")
 label("C is for Config", icon: imageIcon(resource: "griffon-icon-24x24.png", class: DeckView),
       cssClass: "desc", constraints: "wrap")
}