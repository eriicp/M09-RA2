public class Futbolista extends Thread{
    private int ngols;
    private int ntirades;
    private final int NUM_JUGADORS = 11;
    private final int NUM_TIRADES = 20;
    private final float PROBABILITAT = 0.5f ;

    public Futbolista(){
        this.ngols = 0;
        this.ntirades = 0;
    }
    public Futbolista(String nom) {
        super(nom); // Usamos super para el nombre, no una variable String nueva [cite: 15, 16]
        this.ngols = 0; // Inicializar a 0 [cite: 10]
        this.ntirades = 0;
    }

    // Getters para las estadísticas
    public int getNgols() {
        return ngols;
    }

    public int getNtirades() {
        return ntirades;
    }

    @Override
    public void run() {
        Random random = new Random();
        
        // Cada jugador tira NUM_TIRADES veces [cite: 17]
        for (int i = 0; i < NUM_TIRADES; i++) {
            this.ntirades++; // Actualizamos tiradas
            
            // Si el número aleatorio es menor que la probabilidad, marca gol
            if (random.nextFloat() < PROBABILITAT) {
                this.ngols++; // Actualizamos goles [cite: 17]
            }
        }
    }
}

import java.util.ArrayList;
import java.util.List;

public class MainFutbol {
    public static void main(String[] args) {
        // Nombres basados en el ejemplo de salida [cite: 27, 29, 32, 35, 41, 42, 43, 45, 47, 49, 52]
        String[] noms = {
            "Piqué", "Vinicius", "Torres", "Ramos", "Ronaldo", 
            "Lewan", "Belli", "Arnau", "Aspas", "Messi", "MBapé"
        };

        List<Futbolista> equip = new ArrayList<>();

        System.out.println("Inici dels xuts"); // [cite: 24]

        // 1. Crear todos los hilos [cite: 19]
        for (String nom : noms) {
            equip.add(new Futbolista(nom));
        }

        // 2. Iniciar todos los hilos [cite: 20]
        for (Futbolista f : equip) {
            f.start();
        }

        // 3. Esperar a que todos los hilos terminen [cite: 21]
        for (Futbolista f : equip) {
            try {
                f.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Fi dels xuts"); // [cite: 25]
        System.out.println("Estadístiques"); // [cite: 26]

        // 4. Mostrar estadísticas [cite: 22]
        for (Futbolista f : equip) {
            System.out.println(f.getName() + " -> " + f.getNgols() + " gols");
        }
    }
}