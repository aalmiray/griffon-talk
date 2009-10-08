import griffon.transitions.TransitionLayout
import com.bric.image.transition.Transition2D
import com.bric.image.transition.spunk.SwivelTransition2D
import org.codehaus.groovy.runtime.typehandling.GroovyCastException
import net.miginfocom.swing.MigLayout
import groovy.ui.ConsoleTextEditor
import java.awt.event.KeyEvent
import java.awt.event.MouseEvent
import javax.swing.KeyStroke
import java.awt.Font

build(DeckActions)

createFooter = { idx ->
  def footer
  noparent {
    footer = panel(layout: new MigLayout("fill","[right]1%","[bottom]")) {
      label(idx.toString())
    }
  }
  footer
}

createEditor = { Map attrs ->
  def runnable = attrs?.remove("runnable") ?: false
  def editor
  noparent {
    editor = container(new ConsoleTextEditor(border: emptyBorder(0)))
    EditorStyles.apply(editor)
    container(editor.textEditor,
      editable: false,
      font: new Font("Monospaced", Font.PLAIN, 20)) {
      if(runnable) {
        action(keyStroke: shortcut("ENTER"),
               closure: {controller.runScript(editor.textEditor.text)})
      }
    }
    keyStrokeAction(component: editor,
      keyStroke: shortcut("shift L"),
      condition: "in focused window",
      action: biggerFontAction)
    keyStrokeAction(component: editor,
      keyStroke: shortcut("shift S"),
      condition: "in focused window",
      action: smallerFontAction)
  }
  attrs?.each{ k, v -> editor.textEditor[(k)] = v }
  editor
}

lookupPopup = jidePopup(movable: false, resizable: false, border: emptyBorder(0),
   popupMenuWillBecomeInvisible: {evt -> doLater{frame.requestFocus()} } ) {
   panel {
      borderLayout()
      textField(id: "input", columns: 2, editable: true,
        border: emptyBorder(0),
        font: new Font("SansSerif", Font.BOLD, 64))
   }
}
lookupPopup.setDefaultFocusComponent(input)
keyStrokeAction(component: input,
  keyStroke: "ENTER",
  action: jumpAction)

lafsPopup = jidePopup(movable: false, resizable: false, border: emptyBorder(0),
   popupMenuWillBecomeInvisible: {evt -> doLater{frame.requestFocus()} } ) {
   scrollPane {
      list(id: "lafList", visibleRowCount: 10,
        border: emptyBorder(0),
        font: new Font("SansSerif", Font.BOLD, 24),
        listData: model.lafs.keySet() as Object[])
   }
}
lafsPopup.setDefaultFocusComponent(lafList)
keyStrokeAction(component: lafList,
  keyStroke: "ENTER",
  action: lafAction)

editorLayout = {
  new MigLayout("fill ","5%[center]5%","5%[top]3%[center]5%")
}

handleMouseEvent = { evt ->
  if(evt.button == MouseEvent.BUTTON1) {
    deck.layout.next(deck)
  } else if(evt.button == MouseEvent.BUTTON3) {
    deck.layout.previous(deck)
  }
}

application(id: "frame", undecorated: true, pack: false, locationByPlatform: false, location: [0,0], size: [1024,768]) {
  borderLayout()
  panel(id: "deck", constraints: context.CENTER,
        layout: new TransitionLayout(defaultDuration: 1500L,
                                     defaultTransition: new SwivelTransition2D(Transition2D.CLOCKWISE))) {
    boolean building = true
    count = 0
    while(building) {
       try {
          transition = null
          slide = build("Slide${(count++)}" as Class)
          widget(slide, constraints: [name: "page${count}".toString(), transition: transition],
                 mouseClicked: handleMouseEvent)
       } catch( GroovyCastException x ) {
          // x.printStackTrace()
          building = false
       }
    }
  }

  keyStrokeAction(component: deck,
    keyStroke: shortcut("LEFT"),
    condition: "in focused window",
    action: previousAction)
  keyStrokeAction(component: deck,
    keyStroke: shortcut("RIGHT"),
    condition: "in focused window",
    action: nextAction)
  keyStrokeAction(component: deck,
    keyStroke: shortcut("shift ESCAPE"),
    condition: "in focused window",
    action: closeAction)
  keyStrokeAction(component: deck,
    keyStroke: shortcut("UP"),
    condition: "in focused window",
    action: lookupAction)
  keyStrokeAction(component: deck,
    keyStroke: shortcut("shift F"),
    condition: "in focused window",
    action: showLafsAction)

  swingRepaintTimeline(deck, loop: true)
}