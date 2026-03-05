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
        System.out.println("Fil" + idComensal + " pensant"); 
        Thread.sleep(1000 + random.nextInt(1001)); 
    }

    private void agafarForquilles() throws InterruptedException {
        agafarForquillaEsquerra();
        agafarForquillaDreta();
        calcularGana();
        System.out.println("Fil" + idComensal + " té forquilles esq (" + esquerra.getId() + ") dreta (" + dreta.getId() + ")");
        Thread.sleep(500 + random.nextInt(501)); 
    }

    private boolean agafarForquillaEsquerra() {
        esquerra.agafar();
        return true;
    }

    private boolean agafarForquillaDreta() {
        dreta.agafar();
        return true;
    }
    

    private void deixarForquilles() {
        dreta.deixar();
        esquerra.deixar();
        System.out.println("Fil" + idComensal + " deixa les forquilles"); 
    }

    private void menjar() throws InterruptedException {
        agafarForquilles();
        System.out.println("Fil" + idComensal + " menja amb gana " + gana);
        Thread.sleep(1000 + random.nextInt(1001)); 
        System.out.println("Fil" + idComensal + " ha acabat de menjar"); 
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