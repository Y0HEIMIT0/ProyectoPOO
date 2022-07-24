import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

import java.util.concurrent.Semaphore;

public class PlaneView extends Group {

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
            Vinicial = 0;
        }
        else{
            Vinicial = 50;
        }
        int Hinicial;
        if (this.pistaString == "pista A"){
            Hinicial = 0;
        }
        else{
            Hinicial = 700;
        }
        this.avion = new Rectangle(Hinicial,Vinicial,20,20);


        getChildren().add(avion);
    }
}
