import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;


import static javafx.application.Application.launch;

public class Aviones extends Application{

    public void start(Stage primaryStage) throws InterruptedException {

        ControlTower CT = new ControlTower(3);


        Rectangle rectan = new Rectangle(0,0, 700,100);
        rectan.setFill(Color.LIGHTGRAY);

        HBox hBox = new HBox(20);
        hBox.setPadding(new Insets(20));
        hBox.setAlignment(Pos.CENTER);

        hBox.getChildren().addAll(rectan);

        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.CENTER);

        vBox.getChildren().addAll(CT.getView());

        VBox ABox = new VBox(20);
        ABox.setPadding(new Insets(20));
        ABox.setAlignment(Pos.CENTER);

        ABox.getChildren().addAll(CT.getAvionview());


        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(20));
        pane.setBottom(hBox);
        pane.setLeft(vBox);
        pane.setCenter(ABox);



        Scene scene = new Scene(pane, 800, 400);
        primaryStage.setTitle("Proyecto POO: Aviones");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) throws InterruptedException{

        launch(args);
    }

}

