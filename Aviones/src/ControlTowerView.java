import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class ControlTowerView extends BorderPane {

    public ControlTowerView(ControlTower controlTower) {
        this.controlTower = controlTower;

        TextField numavion = new TextField();
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



        HBox vBox0 = new HBox(20);
        vBox0.setPadding(new Insets(20));
        vBox0.setAlignment(Pos.CENTER);
        vBox0.getChildren().addAll(numavion);

        getChildren().addAll(vBox0);
    }

    private ControlTower controlTower;
}
