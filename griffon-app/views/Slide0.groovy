import net.miginfocom.swing.MigLayout

container(new SlidePanel(footer: createFooter(count)), layout: new MigLayout("fill","[center]","20%[center]5%[center]2%[center]20%")) {
  label(icon: imageIcon(resource: "griffon-icon-256x256.png", class: DeckView), constraints: "wrap")
  label(text: "Welcome to the", constraints: "wrap", cssClass: "title")
  label(text: "Desktop Revolution", cssClass: "title")
}