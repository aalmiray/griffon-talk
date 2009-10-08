import net.miginfocom.swing.MigLayout

container(new SlidePanel(footer: createFooter(count)), layout: new MigLayout("fill","[center]","20%[center]5%[center]2%[center]20%")) {
  label(icon: imageIcon(resource: "griffon_in_action.jpg", class: DeckView), constraints: "wrap")
  label(text: "Griffon in Action (March 2010)", constraints: "wrap", cssClass: "desc")
  label(text: "http://manning.com/almiray", constraints: "wrap", cssClass: "desc")
}