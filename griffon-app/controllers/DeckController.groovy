class DeckController {
   def close = { evt = null ->
      app.windowManager.windows.last().dispose()
      destroyMVCGroup("deck")
      app.windowManager.windows.pop()
      app.windowManager.windows.first().visible = true
   }

   def runScript = { script ->
      doOutside {
         try {
            new GroovyShell().evaluate(script)
         } catch(x) {x.printStackTrace()}
      }
   }
}
