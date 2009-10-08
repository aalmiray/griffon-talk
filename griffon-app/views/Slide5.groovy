import net.miginfocom.swing.MigLayout
import com.bric.image.transition.Transition2D
import com.bric.image.transition.spunk.FlurryTransition2D

transition = new FlurryTransition2D(Transition2D.OUT)

container(new SlidePanel(footer: createFooter(count)), layout: editorLayout()) {
  label("HelloWorld.groovy", cssClass: "title", constraints: "wrap")
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