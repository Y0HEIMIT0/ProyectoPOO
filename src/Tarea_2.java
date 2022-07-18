import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Tarea_2 {

    public static void main(String[] args) throws InterruptedException{

        Semaphore pista = new Semaphore(1); // Semaforo que se utiliza para bloquear/desbloquear la pista

        System.out.println("Ingrese numero de aviones:");
        Scanner scanner = new Scanner(System.in);
        int numeroAviones = scanner.nextInt();  // El numero de aviones a generar se pide por consola

        for (int i = 1 ; i < numeroAviones + 1 ; i++){
            Random random = new Random();
            int state = random.nextInt(4);  // Se crean aviones segun 4 estados disponibles, se describen en la clase Plane
            Plane avion = new Plane(i,state,pista);
            new Thread(avion).start();      // Se ejecuta el hilo
            Thread.sleep(2000);       // Los aviones se crean cada 2 segundos
        }

    }

}
