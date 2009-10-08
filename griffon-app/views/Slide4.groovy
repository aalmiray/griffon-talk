import net.miginfocom.swing.MigLayout
import griffon.transitions.FadeTransition2D
import java.awt.Color

transition = new FadeTransition2D(Color.BLACK)

container(new SlidePanel(footer: createFooter(count)), layout: editorLayout()) {
  label("HelloWorld.java", cssClass: "title", constraints: "wrap")
  scrollPane(constraints: "grow") {
    def script = '''public class HelloWorld {
   String name;

   public void setName(String name)
   { this.name = name; }
   public String getName(){ return name; }

   public String greet()
   { return "Hello "+ name; }

   public static void main(String[] args){
      HelloWorld helloWorld = new HelloWorld();
      helloWorld.setName("Groovy");
      System.out.println( helloWorld.greet() );
   }
}'''
    widget(createEditor(text: script))
  }
}