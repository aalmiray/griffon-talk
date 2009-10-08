import net.miginfocom.swing.MigLayout
import javax.swing.SwingConstants

def script = '''action(id: "countdown", name: "Start Countdown",
   closure: { evt ->
     int count = lengthSlider.value
     status.text = count
     jxwithWorker(start: true) {
       work {
         while ( --count >= 0 ) {
           sleep( 1000 )
           publish(count)
         }
       }
       onUpdate { chunks ->
         status.text = chunks[0]
       }
       onDone {
         status.background = Color.RED
       }
     }
})'''

container(new SlidePanel(footer: createFooter(count)), layout: editorLayout()) {
  label("Threading - SwingWorker", cssClass: "title", constraints: "wrap")
  scrollPane(constraints: "grow") {
    widget(createEditor(text: script, editable: true, runnable: true))
  }
}