class DeckController {
   def close = { evt = null ->
      app.appFrames.last().dispose()
      destroyMVCGroup("deck")
      app.appFrames.pop()
      app.appFrames.first().visible = true
   }

   def runScript = { script ->
      doOutside {
         try {
            new GroovyShell().evaluate(script)
         } catch(x) {x.printStackTrace()}
      }
   }
}