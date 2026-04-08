import java.util.Random;

public class Dona extends Thread {
    private String nom;
    private BanyUnisex lavabo;
    private Random random = new Random();

    // Constructor amb nom i lavabo 
    public Dona(String nom, BanyUnisex lavabo) {
        this.nom = nom;
        this.lavabo = lavabo;
    }

    // Mètode d'execució
    @Override
    public void run() {
        try {
            lavabo.entraDona(nom); // entraDona en lavabo 
            utilitzaLavabo();
            lavabo.surtDona(nom); // surt Dona de lavabo 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void utilitzaLavabo() throws InterruptedException {
        // Utilitza lavabo durant entre 2 i 3 segons 
        int temps = 2000 + random.nextInt(1001);
        Thread.sleep(temps);
    }
}