import javax.swing.UIManager
import javax.swing.SwingUtilities
import javax.swing.SwingConstants
import java.awt.Font

actions {
  action(id: "previousAction",
    closure: {deck.layout.previous(deck)})
  action(id: "nextAction",
    closure: {deck.layout.next(deck)})
  action(id: "closeAction",
    closure: controller.close)
  action(id: "lookupAction",
    closure: {
      input.text = ""
      lookupPopup.showPopup(SwingConstants.SOUTH_EAST, frame)
    })
  action(id: "showLafsAction",
    closure: {
      lafsPopup.showPopup(SwingConstants.SOUTH_EAST, frame)
    })
  action(id: "jumpAction",
    closure: {
      lookupPopup.hidePopup(true)
      def page = "page${input.text}"
      input.text = ""
      deck.layout.show(deck, page)
    })
  action(id: "lafAction",
    closure: {
      lafsPopup.hidePopup(true)
      UIManager.setLookAndFeel(model.lafs[lafList.selectedValue])
      [frame, lookupPopup, lafsPopup].each {c -> SwingUtilities.updateComponentTreeUI(c)}
    })
  action(id: "biggerFontAction",
    closure: {modifyFont(it.source.textEditor, {it > 40}, +2)})
  action(id: "smallerFontAction",
    closure: {modifyFont(it.source.textEditor, {it < 5}, -2)})
}

modifyFont = { target, sizeFilter, sizeMod ->
  def currentFont = target.font
  if(sizeFilter(currentFont.size)) return
  target.font = new Font('Monospaced', currentFont.style, currentFont.size + sizeMod)
}