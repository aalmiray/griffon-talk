import net.miginfocom.swing.MigLayout
import javax.swing.SwingConstants

def script = '''action(id: "countdown", name: "Start Countdown",
   closure: { evt ->
     int count = lengthSlider.value
     status.text = count
     doOutside {
       while ( --count >= 0 ) {
         sleep( 1000 )
         edt { status.text = count }
       }
       doLater {
         status.background = Color.RED
       }
     }
})'''

container(new SlidePanel(footer: createFooter(count)), layout: editorLayout()) {
  label("Threading", cssClass: "title", constraints: "wrap")
  scrollPane(constraints: "grow") {
    widget(createEditor(text: script, editable: true, runnable: true))
  }
}