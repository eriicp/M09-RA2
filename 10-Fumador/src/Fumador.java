import java.util.Random;

class Fumador extends Thread {
    private Estanc estanc; 
    private int id; 
    private Tabac tabac;
    private Llumi llumi; 
    private Paper paper;
    private int numFumades;
    private Random random;

    public Fumador(Estanc estanc, int id) {
        this.estanc = estanc;
        this.id = id;
        this.numFumades = 0;
        this.random = new Random();
    }

    public void compraTabac() throws InterruptedException {
        tabac = estanc.venTabac(id);
    }

    public void compraPaper() throws InterruptedException {
        paper = estanc.venPaper(id);
    }

    public void compraLlumi() throws InterruptedException {
        llumi = estanc.venLlumi(id);
    }

    public void fuma() throws InterruptedException {
        if (tabac != null && paper != null && llumi != null) {
            System.out.println("Fumador " + id + " fumant");
            Thread.sleep(500 + random.nextInt(501)); 
            tabac = null;
            paper = null;
            llumi = null;
            numFumades++;
            System.out.println("Fumador " + id + " ha fumat " + numFumades + " vegades");
        }
    }

    @Override
    public void run() {
        try {
            while (numFumades < 3) {
                compraTabac();
                compraPaper();
                compraLlumi();
                fuma();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}