public class Barber extends Thread {
    private String nom;

    // Constructor con nombre 
    public Barber(String nom) {
        this.nom = nom;
    }

    // Método de ejecución (run) 
    @Override
    public void run() {
        while (true) {
            Client clientActual;

            synchronized (Barberia.barberia.condBarber) {
                // Hace pasar al siguiente cliente 
                clientActual = Barberia.barberia.seguentClient();

                if (clientActual == null) {
                    System.out.println("Ningú en espera");
                    System.out.println("Barber " + nom + " dormint");
                    try {
                        // Si no hay, duerme esperando a condBarber 
                        Barberia.barberia.condBarber.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue; // Vuelve al inicio del bucle tras despertar
                }
            }

            // Fuera del bloque sincronizado para no bloquear la entrada de nuevos clientes
            System.out.println("Li toca al client " + clientActual.getNom());
            clientActual.tallarseElCabell();

            try {
                // Le corta el pelo en un tiempo de 0,9s + random 0,1s 
                int tempsTalla = 900 + (int)(Math.random() * 100);
                Thread.sleep(tempsTalla);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}