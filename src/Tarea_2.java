import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Tarea_2 {

    public static void main(String[] args) throws InterruptedException{

        Semaphore pistaA = new Semaphore(1);
        Semaphore pistaB = new Semaphore(1);

        System.out.println("Ingrese numero de aviones:");
        Scanner scanner = new Scanner(System.in);
        int numeroAviones = scanner.nextInt();

        for (int i = 1 ; i < numeroAviones + 1 ; i++){
            Random random = new Random();
            int state = random.nextInt(4);
            new Thread(new Plane(i,state,pistaA,pistaB)).start();
        }


    }

}
