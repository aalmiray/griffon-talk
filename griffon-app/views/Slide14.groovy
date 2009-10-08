import net.miginfocom.swing.MigLayout

container(new SlidePanel(footer: createFooter(count)),layout: new MigLayout("fill ","[center]","")) {
 label("Convention over Configuration", cssClass: "desc", constraints: "wrap")
 label("Don't repeat yourself (DRY)", cssClass: "desc", constraints: "wrap")
 label("MVC Pattern", cssClass: "desc", constraints: "wrap")
 label("Automate repetitive tasks", cssClass: "desc", constraints: "wrap")
 label('Testing supported “out of the box”', cssClass: "desc")
}