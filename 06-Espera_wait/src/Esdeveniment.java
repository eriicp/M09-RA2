import java.util.ArrayList;
import java.util.List;

public class Esdeveniment {
    private List<Assistent> Assistents;
    private int placesDisponibles;
    private int placesMaximes = 10;

    public Esdeveniment(int placesMaximes) {
        Assistents = new ArrayList<>();
        this.placesMaximes = placesMaximes;
        placesDisponibles = placesMaximes;
    }

    public Esdeveniment() {
        Assistents = new ArrayList<>();
        placesDisponibles = placesMaximes;
    }

    public synchronized void ferReserva(Assistent Assistent){
        while(placesDisponibles == 0){
            try{
                wait();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

        Assistents.add(Assistent);
        placesDisponibles--;
        System.out.println(Assistent.getNom() + " ha fet una reserva. Places disponibles: " + placesDisponibles);
    
    }

    public synchronized void cancelaReserva(Assistent Assistent){
        if(Assistents.contains(Assistent)){
            Assistents.remove(Assistent); 
            placesDisponibles++;
            System.out.println(Assistent.getNom() + " ha cancel·lat una reserva. Places disponibles: " + placesDisponibles);
            notifyAll();
        }
        else{
            System.out.println(Assistent.getNom() + " no ha pogut cancel·lar una reserva inexistent. Places disponibles: " +placesDisponibles);
        }
    }

    
    
}