package src;
import java.util.Random;

public class Filosof extends Thread {
    private int idComensal;
    private Forquilla esquerra, dreta;
    private long iniciGana = System.currentTimeMillis();
    private long fiGana;
    private long gana = 0;
    private Random random = new Random();

    public Filosof(int idComensal, Forquilla esquerra, Forquilla dreta) {
        this.idComensal = idComensal;
        this.esquerra = esquerra;
        this.dreta = dreta;
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filosof: fil" + idComensal + " pensant");
        Thread.sleep(1000 + random.nextInt(1001)); 
    }

    private void agafarForquilles() throws InterruptedException {
        agafarForquillaEsquerra();
        agafarForquillaDreta();
        calcularGana();
        System.out.println("Filosof: fil" + idComensal + " gana = " + gana);
        Thread.sleep(500 + random.nextInt(501)); // Espera 0.5s-1s
    }

    private boolean agafarForquillaEsquerra() {
        esquerra.agafar();
        System.out.println("Filosof: fil" + idComensal + " agafa la forquilla esquerra " + esquerra.getId());
        return true;
    }

    private boolean agafarForquillaDreta() {
        dreta.agafar();
        System.out.println("Filosof: fil" + idComensal + " agafa la forquilla dreta " + dreta.getId());
        return true;
    }
    

    private void deixarForquilles() {
        dreta.deixar();
        esquerra.deixar();
    }

    private void menjar() throws InterruptedException {
        agafarForquilles();
        System.out.println("Filosof: fil" + idComensal + " menja");
        Thread.sleep(1000 + random.nextInt(1001)); 
        System.out.println("Filosof: fil" + idComensal + " ha acabat de menjar");
        resetGana();
        deixarForquilles();
    }

    private void calcularGana(){
        fiGana = System.currentTimeMillis();
        gana = (fiGana - iniciGana)/1000; 
    }

    private void resetGana(){
        iniciGana = System.currentTimeMillis();
        gana = 0;
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                menjar();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}