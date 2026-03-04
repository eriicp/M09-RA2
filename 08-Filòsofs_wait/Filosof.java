import java.util.Random;

public class Filosof extends Thread {
    private int idComensal;
    private Forquilla esquerra, dreta;
    private int gana = 0;
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
        boolean potMenjar = false;
        while (!potMenjar) {
            if (agafarForquillaEsquerra()) {
                if (agafarForquillaDreta()) {
                    potMenjar = true;
                } else {
                    deixarForquilles(); // Allibera l'esquerra si la dreta està ocupada
                }
            }
            
            if (!potMenjar) {
                gana++;
                System.out.println("Filosof: fil" + idComensal + " gana = " + gana);
                Thread.sleep(500 + random.nextInt(501)); // Espera 0.5s-1s
            }
        }
    }

    private boolean agafarForquillaEsquerra() {
        synchronized (esquerra) {
            if (esquerra.getPropietari() == Forquilla.LLIURE) {
                esquerra.setPropietari(idComensal);
                System.out.println("Filosof: fil" + idComensal + " agafa la forquilla esquerra " + esquerra.getId());
                return true;
            }
            return false;
        }
    }

    private boolean agafarForquillaDreta() {
        synchronized (dreta) {
            if (dreta.getPropietari() == Forquilla.LLIURE) {
                dreta.setPropietari(idComensal);
                System.out.println("Filosof: fil" + idComensal + " agafa la forquilla dreta " + dreta.getId());
                return true;
            }
            return false;
        }
    }

    private void deixarForquilles() {
        synchronized (esquerra) {
            if (esquerra.getPropietari() == idComensal) {
                esquerra.setPropietari(Forquilla.LLIURE);
                esquerra.notifyAll(); 
            }
        }
        synchronized (dreta) {
            if (dreta.getPropietari() == idComensal) {
                dreta.setPropietari(Forquilla.LLIURE);
                dreta.notifyAll();
            }
        }
    }

    private void menjar() throws InterruptedException {
        agafarForquilles();
        System.out.println("Filosof: fil" + idComensal + " menja");
        Thread.sleep(1000 + random.nextInt(1001)); 
        System.out.println("Filosof: fil" + idComensal + " ha acabat de menjar");
        gana = 0; 
        deixarForquilles();
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