import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

import java.util.concurrent.Semaphore;

public class Plane implements Runnable {

    //--------------------- Atributos de la clase ---------------------------------------

    private final int id;
    private PlaneState state;
    private String pistaString;
    private Semaphore semPista;
    private PlaneView view;

    //--------------------- Constructor -------------------------------------------------


    public Plane(int id, int state, Semaphore pista) {
        this.id = id;
        switch (state) {
            case 0 -> {                 // Avion que quiere despegar desde la pista A
                this.state = PlaneState.ON_GROUND;
                this.semPista = pista;
                this.pistaString = "pista A";
            }
            case 1 -> {                 // Avion que quiere despegar desde la pista B
                this.state = PlaneState.ON_GROUND;
                this.semPista = pista;
                this.pistaString = "pista B";
                //this.pocicion = 50;
            }
            case 2 -> {                 // Avion que quiere aterrizar desde la pista A
                this.state = PlaneState.ON_AIR;
                this.semPista = pista;
                this.pistaString = "pista A";
            }
            case 3 -> {                 // Avion que quiere aterrizar desde la pista B
                this.state = PlaneState.ON_AIR;
                this.semPista = pista;
                this.pistaString = "pista B";
            }
        }
        view = new PlaneView(this.id,this.state,pistaString);
    }

    //----------------------- Funciones a utilizar ----------------------------------------

    public void aterrizar() throws InterruptedException {   // Funcion para aterrizar una vez se haya adquirido el semaforo
        System.out.println("El Avion " + id + " procede a aterrizar.");
        Thread.sleep(3000);                           // Simula el tiempo de aterrizaje


    }

    public void tryAterrizar() throws InterruptedException {    // Funcion para intentar adquirir el semaforo
        semPista.acquire();                                     // Una vez que se adquiere el semaforo
        aterrizar();                                            // Se ejecuta la funcion aterrizar()
        semPista.release();                                     // Se libera el semaforo
        System.out.println("La pista se encuentra disponible"); // Luego se informa que la pista se libera
    }

    public void despegar() throws InterruptedException {        // Funcion para despegar una vez se haya adquirido el semaforo
        System.out.println("El Avion " + id + " procede a despegar.");
        Thread.sleep(3000);                               // Simula el tiempo de despegue
    }

    public void tryDespegar() throws InterruptedException { // Funcion para despegar una vez se haya adquirido el semaforo
        if (semPista.tryAcquire()) {                        // Se intenta adquirir cuando se llama a la funcion
            despegar();                                     // Si se adquiere, se ejecuta despegar()
            semPista.release();                             // Se libera el semaforo
            System.out.println("La pista se encuentra disponible"); // Se informa que la pista se libera
        } else {                          // De no lograr adquirirse el semaforo, se esperan 2 segundos y se vuelve a intentar
            wait(2000);
            tryDespegar();
        }
    }

    public synchronized void movimiento() throws InterruptedException {

        //          ACCION INICIAL PARA POSICIONAR LOS AVIONES SEGUN SU ESTADO Y PISTA INICIAL

        if (state == PlaneState.ON_AIR) {        // Caso para aviones que buscan aterrizar
            System.out.println("El Avion " + id + " ha llegado, necesita aterrizar desde el lado " + pistaString + " de la pista.");
        } else {                                  // Caso para aviones que buscan despegar
            System.out.println("El Avion " + id + " requiere despegar desde el lado  " + pistaString + " de la pista.");
        }

        //          Se ejecutan las funciones para despegue o aterrizaje segun el estado del avion

        try {
            if (state == PlaneState.ON_AIR) {
                tryAterrizar();
            } else
                tryDespegar();
        } catch (Exception ee) {
            ee.getCause();  // En el caso de de que se genere una excepcion, se imprime la causa
        }

    }

    @Override
    public void run() {         // Metodo run, necesario para la creacion de los hilos
        try {
            movimiento();    // Corre el metodo movimiento cuando se generen los hilos
        } catch (InterruptedException e) {
            throw new RuntimeException(e);  // De no poder ejecutarse, se arroja una excepcion
        }
    }

    public PlaneView getView() {
        return view;
    }

    public int getId() {
        return id;
    }

    public PlaneState getState() {
        return state;
    }

    public String getPistaString() {
        return pistaString;
    }


    

    }


}

