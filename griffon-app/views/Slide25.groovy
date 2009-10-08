import net.miginfocom.swing.MigLayout

container(new SlidePanel(footer: createFooter(count)),layout: new MigLayout("fill","[center]","[center]")) {
  label("Thank you!", cssClass: "title")
}