import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class ControlTowerView extends BorderPane {

    public ControlTowerView(ControlTower controlTower) {
        this.controlTower = controlTower;

        TextField numavion = new TextField();
        numavion.setMinSize(300,300);
       /* Button numavion = new Button("5 aviones");
        numavion.setMinSize(100,100);
        numavion.setOnAction( e -> {
            try {
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

    private ControlTower controlTower;
}
