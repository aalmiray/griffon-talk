import java.awt.GraphicsEnvironment
import griffon.builder.css.CSSDecorator

class InitController {
   def model
   def view

   def play = { evt = null ->
      createMVCGroup("deck", "deck",[:])
      app.windowManager.windows[0].visible = false
      def graphicsEnvironment = GraphicsEnvironment.localGraphicsEnvironment
      def device = graphicsEnvironment.screenDevices.find{it.fullScreenSupported}
      device?.setFullScreenWindow(app.windowManager.windows[1])
      CSSDecorator.decorate("style", app.windowManager.windows[1])
      app.windowManager.windows[1].visible = true
   }

   def help = { evt = null ->
      showDialog("help")
   }

   def print = { evt = null ->
      // TODO
   }

   def quit = { evt = null ->
      app.shutdown()
   }

   private void showDialog(dialogName, pack = true) {
      def dialog = view."${dialogName}Dialog"
      if(dialog.visible) {
         dialog.toFront()
         return
      }
      if(pack) dialog.pack()
      int x = app.windowManager.windows[0].x + (app.windowManager.windows[0].width - dialog.width) / 2
      int y = app.windowManager.windows[0].y + (app.windowManager.windows[0].height - dialog.height) / 2
      dialog.setLocation(x, y)
      dialog.show()
   }

   private void hideDialog(dialogName) {
      def dialog = view."${dialogName}Dialog"
      dialog.hide()
   }
}
