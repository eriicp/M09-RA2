public class Administracio {
    
    private static final int NUM_POBLACIO_ACTIVA = 50;
    private Treballador[] poblacio_activa = new Treballador[NUM_POBLACIO_ACTIVA];

    public Administracio() {
        for (int i = 0; i < NUM_POBLACIO_ACTIVA; i++) {
            poblacio_activa[i] = new Treballador("Ciutadà-" + i, 25000, 20, 65);
        }
    }

    public static void main(String[] args) {
        Administracio admin = new Administracio();
        
        for (Treballador t : admin.poblacio_activa) {
            t.start();
        }

       
        for (Treballador t : admin.poblacio_activa) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Treballador t : admin.poblacio_activa) {
            System.out.printf("%s -> edat: %d / total: %.2f%n", 
                t.getName(), 
                t.getEdat(), 
                t.getCobrat());
        }
    }
}