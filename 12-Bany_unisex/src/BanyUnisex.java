import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class BanyUnisex {
    // Constantes de estado 
    public static final int BANY_BUIT = 0;
    public static final int BANY_AMB_HOMES = 1;
    public static final int BANY_AMB_DONES = 2;

    // Variables de control
    private int estatActual = BANY_BUIT;
    private int ocupants = 0;
    public final int CAPACITAT_MAX = 3;

    // Semáforo (fair=true) y ReentrantLock
    private final Semaphore capacitat = new Semaphore(CAPACITAT_MAX, true);
    private final ReentrantLock lockEstat = new ReentrantLock(true);

    public void entraHome(String nom) throws InterruptedException {
        System.out.println(nom + " vol entrar al bany");
        while (true) { // Intenta infinitamente 
            lockEstat.lock(); // Bloquea el estado 
            try {
                if (estatActual == BANY_BUIT || estatActual == BANY_AMB_HOMES) {
                    if (capacitat.tryAcquire()) { // Intenta obtener ticket 
                        estatActual = BANY_AMB_HOMES;
                        ocupants++; // Incrementa ocupantes 
                        System.out.println("Home entra al bany. Ocupants: " + ocupants);
                        break; // Sale del bucle infinito si tiene éxito
                    }
                }
            } finally {
                lockEstat.unlock(); // Finalmente desbloquea el estado 
            }
            Thread.sleep(50); // Pausa para evitar consumo excesivo de CPU en espera activa
        }
    }

    public void surtHome(String nom) {
        lockEstat.lock(); // Bloquea el estado 
        try {
            ocupants--; // Disminuye ocupantes 
            System.out.println("Home surt del bany. Ocupants: " + ocupants);
            if (ocupants == 0) {
                estatActual = BANY_BUIT; // Actualiza estado si corresponde 
                System.out.println("El bany està buit");
            }
            capacitat.release(); // Torna un tiquet 
        } finally {
            lockEstat.unlock(); // Desbloquea el estado 
        }
        System.out.println(nom + " ha acabat d'usar el bany");
    }

    public void entraDona(String nom) throws InterruptedException {
        System.out.println(nom + " vol entrar al bany");
        while (true) {
            lockEstat.lock(); // Bloquea el estado
            try {
                if (estatActual == BANY_BUIT || estatActual == BANY_AMB_DONES) {
                    if (capacitat.tryAcquire()) { // Intenta obtener ticket 
                        estatActual = BANY_AMB_DONES;
                        ocupants++; // Incrementa ocupantes 
                        System.out.println("Dona entra en el bany. Ocupants: " + ocupants);
                        break;
                    }
                }
            } finally {
                lockEstat.unlock(); // Finalmente desbloquea el estado
            }
            Thread.sleep(50);
        }
    }

    public void surtDona(String nom) {
        lockEstat.lock(); // Bloquea el estado
        try {
            ocupants--; // Disminuye ocupantes
            System.out.println("Dona surt del bany. Ocupants: " + ocupants);
            if (ocupants == 0) {
                estatActual = BANY_BUIT; // Actualiza estado si corresponde 
                System.out.println("El bany està buit");
            }
            capacitat.release();
        } finally {
            lockEstat.unlock(); // Desbloquea el estado 
        }
        System.out.println(nom + " ha acabat d'usar el bany");
    }

    // Mètode principal 
    public static void main(String[] args) {
        BanyUnisex bany = new BanyUnisex();

        // Lanza 5 hilos de hombre y 5 de mujer 
        for (int i = 0; i < 5; i++) {
            new Home("Home-" + i, bany).start();
            new Dona("Dona-" + i, bany).start();
        }
    }
}