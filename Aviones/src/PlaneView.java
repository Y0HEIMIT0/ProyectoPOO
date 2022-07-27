import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;


public class PlaneView extends Group{

    private Rectangle avion;
    private Rectangle avion2;
    private int id;
    private PlaneState state;
    private String pistaString;

    public PlaneView(int id, PlaneState state, String pistaString) {;
        this.id = id;
        this.state = state;
        this.pistaString = pistaString;


        int Vinicial;

       if (this.state == PlaneState.ON_GROUND) {
            Vinicial = 10;
        }
        else{
            Vinicial = 500;
        }
        int Hinicial;
        if (this.pistaString == "pista A"){
            Hinicial = 10;
        }
        else{
            Hinicial = 1000;
        }
        this.avion = new Rectangle(Hinicial,Vinicial,100,20);
        // Para la animación hay que modificar la posición del avión en base al estado del avion
        // Usando AnimationTimer
/*        if(){
           this.avion.setX();
           this.avion.setY();
        }
*/
        getChildren().add(avion);

        //Image img = new Image(getClass().getResourceAsStream("D:/UTFSM/2022-1/SSOO/Tarea2/Tarea_SSOO/Aviones"));
       // ImageView imgView = new ImageView(img);
        BorderPane pane = new BorderPane();
        getChildren().add(pane);

    }
}
