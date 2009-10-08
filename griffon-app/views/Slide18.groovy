import net.miginfocom.swing.MigLayout

container(new SlidePanel(footer: createFooter(count)),layout: new MigLayout("fill ","5%[left]5%","")) {
 label("Don't Repeat Yourself", cssClass: "title", constraints: "center, wrap")
 label("How? Use a Dynamic Language!", cssClass: "desc", constraints: "wrap")
 label("With Closures/Blocks", icon: imageIcon(resource: "griffon-icon-24x24.png", class: DeckView),
       cssClass: "desc", constraints: "wrap")
 label("With terse property syntax", icon: imageIcon(resource: "griffon-icon-24x24.png", class: DeckView),
       cssClass: "desc", constraints: "wrap")
 label('   myJTextArea.text = "Fires Property Change"', cssClass: "code", constraints: "wrap")
 label("With terse eventing syntax", icon: imageIcon(resource: "griffon-icon-24x24.png", class: DeckView),
       cssClass: "desc", constraints: "wrap")
 label("   button.actionPerformed = {println 'hi'}", cssClass: "code", constraints: "wrap")
 label("With Rich Annotation Support", icon: imageIcon(resource: "griffon-icon-24x24.png", class: DeckView),
       cssClass: "desc", constraints: "wrap")
 label("   @Bindable String aBoundProperty", cssClass: "code", constraints: "wrap")
}