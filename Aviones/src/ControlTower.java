import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class ControlTower {

    public ControlTower(int numeroAviones) throws InterruptedException {
        this.numeroAviones = numeroAviones;
        view = new ControlTowerView(this);
        avionview = new PlaneView[numeroAviones]; //Inicializa el arreglo con el tamaño que se haya ingresado en textfield
    }


    public ControlTowerView getView() {
        return view;
    }

    public PlaneView getAvionview(int i) {
        return avionview[i];
    }

    public int getNumeroAviones() {
        return numeroAviones;
    }

    public void control() throws InterruptedException {
        Semaphore pista = new Semaphore(1); // Semaforo que se utiliza para bloquear/desbloquear la pista

        for (int i = 0; i < numeroAviones + 1; i++){
            Random random = new Random();
            int state = random.nextInt(4);  // Se crean aviones segun 4 estados disponibles, se describen en la clase Plane
            Plane avion = new Plane(i, state, pista);
            avionview[i] = new PlaneView(avion.getId(),avion.getState(),avion.getPistaString());

            new Thread(avion).start();      // Se ejecuta el hilo
            Thread.sleep(2000);       // Los aviones se crean cada 2 segundos
        }

    }

    private int numeroAviones;
    private ControlTowerView view;
    private PlaneView [] avionview;
}
