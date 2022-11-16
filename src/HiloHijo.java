import java.util.concurrent.Semaphore;

public class HiloHijo extends Thread {

    //TODO 4: Creamos el contador y el contador total
    public static int cont;
    public static int contTotal = 0;
    private Semaphore semaphore;

    //TODO 2: Creamos el constructor
    public HiloHijo(String name, Semaphore semaphore) {
        super(name);
        this.semaphore = semaphore;
    }
    @Override
    public void run() {
        //TODO 6: Añadimos los colores del Main al semáforo e incrementamos los contadores
        try {
            semaphore.acquire();
            cont = 0;
            for (String color : Main.colores) {
                if (color.equalsIgnoreCase(this.getName())) {
                    cont++;
                    contTotal++;
                }
            }
            System.out.println("Soy " + this.getName() + ", tengo " + cont + " colores.");
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
