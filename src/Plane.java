import java.util.concurrent.Semaphore;

public class Plane implements Runnable{
    private final int id;
    private PlaneState state;
    private String pista1String;
    private Semaphore pista1, pista2;

    public Plane(int id, int state, Semaphore pistaA, Semaphore pistaB) {
        this.id = id;
        switch (state) {
            case 0 -> {                 // Avion que quiere despegar desde la pista A
                System.out.println("Ha llegado el Avion " + id + " queriendo despegar desde A");
                this.state = PlaneState.ON_GROUND;
                this.pista1 = pistaA;
                this.pista2 = pistaB;
                this.pista1String = "pista A";
            }
            case 1 -> {                 // Avion que quiere despegar desde la pista B
                System.out.println("Ha llegado el Avion " + id + " queriendo despegar desde B");
                this.state = PlaneState.ON_GROUND;
                this.pista1 = pistaB;
                this.pista2 = pistaA;
                this.pista1String = "pista B";
            }
            case 2 -> {                 // Avion que quiere aterrizar desde la pista A
                System.out.println("Ha llegado el Avion " + id + " queriendo aterrizar por A");
                this.state = PlaneState.ON_AIR;
                this.pista1 = pistaA;
                this.pista2 = pistaB;
                this.pista1String = "pista A";
            }
            case 3 -> {                 // Avion que quiere aterrizar desde la pista B
                System.out.println("Ha llegado el Avion " + id + " queriendo aterrizar por B");
                this.state = PlaneState.ON_AIR;
                this.pista1 = pistaB;
                this.pista2 = pistaA;
                this.pista1String = "pista B";
            }
        }
    }

    public synchronized void movimientoNaranja(){
        if (state == PlaneState.ON_AIR){        // Caso para aviones que buscan aterrizar
            System.out.println("El Avi " + id + " se esta acercando a la pista " + pista1String);
        }
        else {                                  // Caso para aviones que buscan despegar
            System.out.println("El Avion " + id + " se ha posicionado en la pista " + pista1String);
        }
    }

    @Override
    public void run() {
        synchronized (pista1){
            if (state == PlaneState.ON_GROUND) System.out.println("El Avion " + id + " se ha posicionado en la " + pista1String);
            else System.out.println("El Avion " + id + " se acerca a la pista " + pista1String);
            synchronized (pista2){
                if (state == PlaneState.ON_GROUND) System.out.println("El Avion " + id + " procede a despegar.");
                else System.out.println("El Avion " + id + " procede a aterrizar");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
