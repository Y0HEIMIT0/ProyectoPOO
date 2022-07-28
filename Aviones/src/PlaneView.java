import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;


public class PlaneView extends Group{

    private Rectangle avion;
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

        getChildren().add(avion);

        BorderPane pane = new BorderPane();
        getChildren().add(pane);


    }

    public Rectangle getAvion() {
        return avion;
    }
}
