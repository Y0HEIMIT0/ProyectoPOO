import javafx.scene.Group;
import javafx.scene.layout.BorderPane;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ControlTower {

    public ControlTower(int numeroAviones) throws InterruptedException {
        this.numeroAviones = numeroAviones;
        view = new ControlTowerView(this);
        avionview = new PlaneView(24,PlaneState.ON_AIR,"pista B"); // Se genera un solo PLaneView.
    }

    public void setNumeroAviones(int numeroAviones) {
        this.numeroAviones = numeroAviones;
    }

    public ControlTowerView getView() {
        return view;
    }

    public PlaneView getAvionview() {
        return avionview;
    }

    public void control() throws InterruptedException {
        Semaphore pista = new Semaphore(1); // Semaforo que se utiliza para bloquear/desbloquear la pista



        for (int i = 0; i < numeroAviones + 1; i++){
            Random random = new Random();
            int state = random.nextInt(4);  // Se crean aviones segun 4 estados disponibles, se describen en la clase Plane
            Plane avion = new Plane(i, state, pista);
        //    avionview = new PlaneView(avion.getId(),avion.getState(),avion.getPistaString());
            new Thread(avion).start();      // Se ejecuta el hilo
            Thread.sleep(2000);       // Los aviones se crean cada 2 segundos
        }

    }

    private int numeroAviones;
    private ControlTowerView view;
    private PlaneView avionview;

}
