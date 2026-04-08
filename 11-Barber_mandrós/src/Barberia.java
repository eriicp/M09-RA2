import java.util.LinkedList;
import java.util.Queue;

public class Barberia extends Thread {
    // Instancia estática de barberia
    public static Barberia barberia;

    // Cola implementada con LinkedList para salaEspera
    private Queue<Client> salaEspera;
    
    // Número máximo de sillas 
    private int maxCadires;
    
    // Objeto para la sincronía 
    public final Object condBarber = new Object();

    // Constructor con el número de sillas 
    public Barberia(int maxCadires) {
        this.maxCadires = maxCadires;
        this.salaEspera = new LinkedList<>();
        barberia = this; 
    }

    // Retorna el siguiente de la cola o null si no hay nadie 
    public Client seguentClient() {
        return salaEspera.poll();
    }

    // Acepta un cliente, entra a la sala si hay sitio y despierta al barbero, o se va 
    public void entrarClient(Client client) {
        synchronized (condBarber) {
            if (salaEspera.size() < maxCadires) {
                salaEspera.add(client);
                System.out.println("Client " + client.getNom() + " en espera");
                condBarber.notify(); // Despierta al barbero
            } else {
                System.out.println("No queden cadires, client " + client.getNom() + " se'n va");
            }
        }
    }

    // Método de ejecución de la barbería 
    @Override
    public void run() {
        // Hace entrar a 10 clientes, uno cada 0,5 segundos
        for (int i = 1; i <= 10; i++) {
            Client c = new Client(i);
            entrarClient(c);
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }

        // Espera 10 segundos 
        try { Thread.sleep(10000); } catch (InterruptedException e) {}

        // Hace entrar a 10 clientes más, uno cada 0,5 segundos
        for (int i = 11; i <= 20; i++) {
            Client c = new Client(i);
            entrarClient(c);
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }

    // Método main
    public static void main(String[] args) {
        // Crea la barbería con 3 sillas 
        Barberia b = new Barberia(3);
        
        // Crea al barbero con nombre (Pepe, según la salida esperada)
        Barber pepe = new Barber("Pepe");
        
        // Inicia al barbero
        pepe.start();
        
        // Inicia la barbería 
        b.start();
    }
}