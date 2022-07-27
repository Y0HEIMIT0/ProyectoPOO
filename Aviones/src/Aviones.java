import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;


import java.util.Scanner;

import static java.lang.String.valueOf;
import static javafx.application.Application.launch;


public class Aviones extends Application{

    public void start(Stage primaryStage) throws InterruptedException {

        System.out.println("Number of planes");
        Scanner sc = new Scanner(System.in);
        int numeroAviones = sc.nextInt();

        ControlTower CT = new ControlTower(numeroAviones);


        Rectangle rectan = new Rectangle(0,0, 1400,100);
        rectan.setFill(Color.LIGHTGRAY);

        HBox hBox = new HBox(20);
        hBox.setPadding(new Insets(20));
        hBox.setAlignment(Pos.CENTER);

        hBox.getChildren().addAll(rectan);

        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.CENTER);

        vBox.getChildren().addAll(CT.getView());

        StackPane ABox = new StackPane();
        ABox.setPadding(new Insets(20));
        ABox.setAlignment(Pos.CENTER);


        for (int i = 0; i < numeroAviones; i++) {
            ABox.getChildren().add(CT.getAvionview(i));
        }


        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(20));
        pane.setBottom(hBox);
        pane.setLeft(vBox);
        pane.setCenter(ABox);



        Scene scene = new Scene(pane, 1500, 700);
        primaryStage.setTitle("Proyecto POO: Aviones");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) throws InterruptedException{

        launch(args);
    }

}

