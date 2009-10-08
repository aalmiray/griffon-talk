import java.awt.LayoutManager
import java.awt.BorderLayout
import java.awt.Component
import javax.swing.JComponent
import javax.swing.JPanel

class SlidePanel extends JPanel {
  private final JPanel _content

  SlidePanel() {
    super.setLayout(new BorderLayout())
    _content = new JPanel()
    super.add(_content, BorderLayout.CENTER)
  }

  void setHeader(JComponent header) {
     super.add(header, BorderLayout.NORTH)
  }

  void setFooter(JComponent footer) {
     super.add(footer, BorderLayout.SOUTH)
  }

  void setLayout(LayoutManager layout) {
    if(_content) _content.layout = layout
  }

  Component add(Component component) {
    return _content.add(component)
  }

  void add(Component component, Object constraints) {
    _content.add(component, constraints)
  }
}