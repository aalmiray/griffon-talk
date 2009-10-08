import net.miginfocom.swing.MigLayout
import com.bric.image.transition.Transition2D
import com.bric.image.transition.spunk.StarsTransition2D

transition = new StarsTransition2D(Transition2D.LEFT)

container(new SlidePanel(footer: createFooter(count)),layout: new MigLayout("fill","[center]","[center]")) {
  label("What is Griffon?", cssClass: "title")
}