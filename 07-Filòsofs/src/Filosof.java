import java.util.Random;

public class Filosof extends Thread {
    private String nom;
    private Forquilla forquillaEsquerra, forquillaDreta;
    private int gana = 0;
    private Random random = new Random();

    public Filosof(String nom, Forquilla esquerra, Forquilla dreta) {
        this.nom = nom;
        this.forquillaEsquerra = esquerra;
        this.forquillaDreta = dreta; 
    }

    public Forquilla getEsquerra() {
        return forquillaEsquerra;
    }

    public Forquilla getDreta() {
        return forquillaDreta;
    }


    private void pensar() throws InterruptedException {
        System.out.println("Filosof: " + nom + " pensant"); 
        Thread.sleep(1000 + random.nextInt(1001)); 
    }

    private void menjar() throws InterruptedException {
        System.out.println("Filosof: " + nom + " agafa la forquilla esquerra " + forquillaEsquerra.getId());
        
        synchronized (forquillaEsquerra) {
            if (!forquillaEsquerra.getEnUs()) {
                forquillaEsquerra.setEnUs(true);
                
                synchronized (forquillaDreta) {
                    if (!forquillaDreta.getEnUs()) {
                        forquillaDreta.setEnUs(true);
                        System.out.println("Filosof: " + nom + " agafa la forquilla dreta " + forquillaDreta.getId());
                        System.out.println("Filosof: " + nom + " menja");
                        
                        Thread.sleep(1000 + random.nextInt(1001)); 
                        
                        System.out.println("Filosof: " + nom + " ha acabat de menjar");
                        forquillaDreta.setEnUs(false);
                        forquillaEsquerra.setEnUs(false);
                        gana = 0; 
                        return;
                    }
                }
                forquillaEsquerra.setEnUs(false);
                System.out.println("Filosof: " + nom + " deixa l'esquerra (" + forquillaEsquerra.getId() + ") i espera (dreta ocupada)");
            }
        }
        
        gana++; 
        System.out.println("Filosof: " + nom + " gana = " + gana);
        Thread.sleep(500 + random.nextInt(501)); 
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar(); 
                menjar(); 
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}