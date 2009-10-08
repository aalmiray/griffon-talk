import ca.odell.glazedlists.*
import ca.odell.glazedlists.gui.*
import ca.odell.glazedlists.swing.*
import java.awt.Toolkit
import java.awt.event.KeyEvent

actions {
  action(id: "playAction",
    name: "Play",
    closure: controller.play)
  action(id: "printAction",
    name: "Print",
    closure: controller.print)
  action(id: "helpAction",
    name: "Help",
    closure: controller.help)
  action(id: "quitAction",
    name: "Quit",
    closure: controller.quit)
}

def createTableModel() {
   def columnNames = ["Shortcut","Description"]
   new EventTableModel(model.shortcuts, [
          getColumnCount: {columnNames.size()},
          getColumnName: {index -> columnNames[index]},
          getColumnValue: {object, index ->
             object."${columnNames[index].toLowerCase()}"
          }] as TableFormat)
}

dialog(title: "Help", id: "helpDialog", modal: false, size: [460,400],
       iconImage: imageIcon('/griffon-icon-48x48.png').image,
       iconImages: [imageIcon('/griffon-icon-48x48.png').image,
                    imageIcon('/griffon-icon-32x32.png').image,
                    imageIcon('/griffon-icon-16x16.png').image]) {
    borderLayout()
    scrollPane(constraints: CENTER) {
       table(id: "shortcustTable", model: createTableModel())
    }
    new TableComparatorChooser(shortcustTable,
        model.shortcuts, AbstractTableComparatorChooser.SINGLE_COLUMN)
}

def keyMask = KeyEvent.getKeyModifiersText(Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()).toUpperCase()

def s = [
  [shortcut: "SHIFT + $keyMask + ESCAPE", description: "Exit the presentation"],
  [shortcut: "SHIFT + $keyMask + F", description: "Change Look & Feel"],
  [shortcut: "$keyMask + UP", description: "Jump to slide"],
  [shortcut: "$keyMask + LEFT", description: "Move backwards"],
  [shortcut: "$keyMask + RIGHT", description: "Move forward"],
  [shortcut: "Mouse Button3 (Right)", description: "Move backwards"],
  [shortcut: "Mouse Button1 (Left)", description: "Move forward"],
  [shortcut: "SHIFT + $keyMask + S", description: "Smaller editor font"],
  [shortcut: "SHIFT + $keyMask + L", description: "Larger editor font"],
  [shortcut: "$keyMask + ENTER", description: "Execute code (on editable Editor)"]
]
model.shortcuts.addAll(s)

application(title: "Griffon",
  pack: true,
  locationByPlatform: true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    gridLayout(cols: 1, rows: 3)
    button(playAction)
    // button(printAction)
    button(helpAction)
    button(quitAction)
}