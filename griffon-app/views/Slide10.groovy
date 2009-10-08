import net.miginfocom.swing.MigLayout
import javax.swing.SwingConstants
import com.bric.image.transition.Transition2D
import com.bric.image.transition.vanilla.BlendTransition2D

transition = new BlendTransition2D()

def script = '''action(id: "countdown", name: "Start Countdown",
   closure: { evt ->
     int count = lengthSlider.value
     status.text = count

       while ( --count >= 0 ) {
         sleep( 1000 )
               status.text = count
       }

         status.background = Color.RED


})'''

container(new SlidePanel(footer: createFooter(count)), layout: editorLayout()) {
  label("Threading", cssClass: "title", constraints: "wrap")
  scrollPane(constraints: "grow") {
    widget(createEditor(text: script, editable: true, runnable: true))
  }
}