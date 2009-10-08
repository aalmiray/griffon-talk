import net.miginfocom.swing.MigLayout
import javax.swing.SwingConstants
import java.awt.Font

def font = new Font("Monospaced", Font.BOLD, 22)

def script1 = '''import groovy.swing.SwingBuilder
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE
import java.awt.Font

font = new Font("SansSerif", Font.BOLD, 32i)

new SwingBuilder().edt {
  frame(title: "Binding (1)", pack: true, visible: true,
         defaultCloseOperation: DISPOSE_ON_CLOSE) {
    gridLayout(cols: 1, rows: 2)
    textField(id: "input", columns: 20)
    textField(id: "output", columns: 20, editable: false)
    current.contentPane.each{ it.font = font }
  }
  bind(source: input,  sourceProperty: "text",
       target: output, targetProperty: "text")
}'''

def script2 = '''import groovy.swing.SwingBuilder
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE
import java.awt.Font

font = new Font("SansSerif", Font.BOLD, 32i)

new SwingBuilder().edt {
  frame(title: "Binding (2)", pack: true, visible: true,
         defaultCloseOperation: DISPOSE_ON_CLOSE) {
    gridLayout(cols: 1, rows: 2)
    textField(id: "input", columns: 20)
    textField(id: "output", columns: 20, editable: false,
      text: bind(source: input,  sourceProperty: "text"))
    current.contentPane.each{ it.font = font }
  }
}'''

def script3 = '''import groovy.swing.SwingBuilder
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE
import java.awt.Font

font = new Font("SansSerif", Font.BOLD, 32i)

new SwingBuilder().edt {
  frame(title: "Binding (3)", pack: true, visible: true,
         defaultCloseOperation: DISPOSE_ON_CLOSE) {
    gridLayout(cols: 1, rows: 2)
    textField(id: "input", columns: 20)
    textField(id: "output", columns: 20, editable: false,
      text: bind{ input.text })
    current.contentPane.each{ it.font = font }
  }
}'''

container(new SlidePanel(footer: createFooter(count)), layout: editorLayout()) {
  label("Binding", cssClass: "title", constraints: "wrap")
  tabbedPane(constraints: "grow", tabPlacement: SwingConstants.BOTTOM, font: font) {
    scrollPane(title: "Explicit") {
      widget(createEditor(text: script1, editable: true, runnable: true))
    }
    scrollPane(title: "Implicit") {
      widget(createEditor(text: script2, editable: true, runnable: true))
    }
    scrollPane(title: "Short") {
      widget(createEditor(text: script3, editable: true, runnable: true))
    }
  }
}