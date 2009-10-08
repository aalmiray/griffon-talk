import java.awt.GraphicsEnvironment
import griffon.builder.css.CSSDecorator

class InitController {
   def model
   def view

   def play = { evt = null ->
      createMVCGroup("deck", "deck",[:])
      app.appFrames[0].visible = false
      def graphicsEnvironment = GraphicsEnvironment.localGraphicsEnvironment
      def device = graphicsEnvironment.screenDevices.find{it.fullScreenSupported}
      // device?.setFullScreenWindow(app.appFrames[1])
      CSSDecorator.decorate("style", app.appFrames[1])
      app.appFrames[1].visible = true
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
      int x = app.appFrames[0].x + (app.appFrames[0].width - dialog.width) / 2
      int y = app.appFrames[0].y + (app.appFrames[0].height - dialog.height) / 2
      dialog.setLocation(x, y)
      dialog.show()
   }

   private void hideDialog(dialogName) {
      def dialog = view."${dialogName}Dialog"
      dialog.hide()
   }
}
