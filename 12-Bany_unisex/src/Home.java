import java.util.Random;

public class Home extends Thread {
    private String nom;
    private BanyUnisex lavabo;
    private Random random = new Random();

    // Constructor amb nom i lavabo
    public Home(String nom, BanyUnisex lavabo) {
        this.nom = nom;
        this.lavabo = lavabo;
    }

    // Mètode d'execució 
    @Override
    public void run() {
        try {
            lavabo.entraHome(nom); // entraHome en lavabo 
            utilitzaLavabo();
            lavabo.surtHome(nom); // surtHome de lavabo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void utilitzaLavabo() throws InterruptedException {
        // Utilitza lavabo durant entre 1 i 2 segons 
        int temps = 1000 + random.nextInt(1001);
        Thread.sleep(temps);
    }
}