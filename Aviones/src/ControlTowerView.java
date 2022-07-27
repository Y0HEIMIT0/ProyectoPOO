import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.awt.*;

public class ControlTowerView extends BorderPane {

    public ControlTowerView(ControlTower controlTower) {
        this.controlTower = controlTower;

        Button numavion = new Button("Iniciar");

        numavion.setOnAction(e -> {
            try {
                controlTower.control();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
    /*    TextField numavion = new TextField();
        numavion.setMinSize(50,30);
        numavion.setAlignment(Pos.CENTER);

        numavion.setOnAction( e -> {
            try {
                int numero = Integer.parseInt(numavion.getText());
                controlTower.setNumeroAviones(numero);
                controlTower.control();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
    */


        HBox vBox0 = new HBox(20);
        vBox0.setPadding(new Insets(20));
        vBox0.setAlignment(Pos.CENTER);
        vBox0.getChildren().addAll(numavion);

        getChildren().addAll(vBox0);
    }
    public Rectangle cuadrado1 = new Rectangle(0,0,100,20);
    private ControlTower controlTower;
}
