import java.util.Random;

public class Assistent extends Thread{
    private Esdeveniment Esdeveniment;
    private String Nom;
    private Random Random = new Random();

    public Assistent(Esdeveniment esdeveniment, String nom) {
        setEsdeveniment(esdeveniment);
        setNom(nom);
    }
    
    public Esdeveniment getEsdeveniment() {
        return Esdeveniment;
    }

    public void setEsdeveniment(Esdeveniment esdeveniment) {
        Esdeveniment = esdeveniment;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    @Override
    public void run() {
        while(true){
            int res = Random.nextInt(2);
            if(res == 1){
                Esdeveniment.ferReserva(this);
            }
            else{
                Esdeveniment.cancelaReserva(this);
            }
            try{
                sleep(Random.nextInt(1000));
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
