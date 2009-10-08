import net.miginfocom.swing.MigLayout

container(new SlidePanel(footer: createFooter(count)),layout: new MigLayout("fill ","5%[left]5%","")) {
 label("More Plugins!", cssClass: "title", constraints: "center, wrap")
 label("Polyglot programming - Scala, Clojure, JavaFX", icon: imageIcon(resource: "griffon-icon-24x24.png", class: DeckView),
       cssClass: "desc", constraints: "wrap")
 label("Components - SwingX, Jide, Flamingo, Macwidgets", icon: imageIcon(resource: "griffon-icon-24x24.png", class: DeckView),
       cssClass: "desc", constraints: "wrap")
 label("Glitz - CSS, Gfx, JGoodies Forms, Transitions, Trident", icon: imageIcon(resource: "griffon-icon-24x24.png", class: DeckView),
       cssClass: "desc", constraints: "wrap")
 label("Misc - Splash, Wizard, Installer, Gpars, GSQL, JUNG", icon: imageIcon(resource: "griffon-icon-24x24.png", class: DeckView),
       cssClass: "desc", constraints: "wrap")
 label("A few more already in the pipeline :-)", icon: imageIcon(resource: "griffon-icon-24x24.png", class: DeckView),
       cssClass: "desc", constraints: "wrap")
}
