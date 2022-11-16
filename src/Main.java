import java.util.concurrent.Semaphore;

public class Main {

    //TODO 3: Creamos el Array
    public static String[] colores;

    //TODO 5: Creamos el static con los colores que tendrá el semáforo
    static {
        colores = new String[]{"rojo", "verde", "azul", "rojo", "verde"};
    }

    public static void main(String[] args) {
        //TODO 1: Creamos el hijo
        //TODO 7: Añadimos los colores al semáforo y los runeamos
        Semaphore semaphore = new Semaphore(1);
        HiloHijo rojo = new HiloHijo("rojo", semaphore);
        HiloHijo verde = new HiloHijo("verde", semaphore);
        HiloHijo azul = new HiloHijo("azul", semaphore);

        rojo.start();
        verde.start();
        azul.start();

        try {
            rojo.join();
            verde.join();
            azul.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Total colores: " + HiloHijo.contTotal);

    }
}