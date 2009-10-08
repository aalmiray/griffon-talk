import net.miginfocom.swing.MigLayout

container(new SlidePanel(footer: createFooter(count)), layout: editorLayout()) {
  label("GroovierHelloWorld.groovy", cssClass: "title", constraints: "wrap")
  scrollPane(constraints: "grow") {
    def script = '''class HelloWorld {
   String name
   def greet() { "Hello $name" }
}

def helloWorld = new HelloWorld(name:"Groovy")
println helloWorld.greet()'''
    widget(createEditor(text: script))
  }
}
