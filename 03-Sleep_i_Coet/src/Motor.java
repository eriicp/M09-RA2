import java.util.Random;

public class Motor extends Thread {
    private int id;
    private int potenciaActual;
    private int potenciaObjectiu;
    private Random random;
    
    private boolean iniciat = false;

    public Motor(int id) {
        this.id = id;
        this.potenciaActual = 0;
        this.potenciaObjectiu = 0;
        this.random = new Random();
    }

    public void setPotencia(int p) {
        this.potenciaObjectiu = p;
        this.iniciat = true;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(random.nextInt(1000) + 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!iniciat) {
                continue;
            }

            if (potenciaObjectiu == 0 && potenciaActual == 0) {
                break;
            }

            if (potenciaActual == potenciaObjectiu) {
                continue; 
            }

            String accio = "FerRes";

            if (potenciaActual < potenciaObjectiu) {
                potenciaActual++;
                accio = "Incre.";
            } else if (potenciaActual > potenciaObjectiu) {
                potenciaActual--;
                accio = "Decre.";
            } else {
                accio = "FerRes";
            }

            System.out.printf("Motor %d: %s Objectiu: %d Actual: %d%n", 
                              id, accio, potenciaObjectiu, potenciaActual);
        }
    }
}