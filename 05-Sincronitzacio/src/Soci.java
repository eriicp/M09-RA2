import java.util.Random;

public class Soci extends Thread{
    private Compte compte;
    private float aportacio = 10f;
    private int esperaMax = 100;
    private int maxAnys = 10;
    private Random random;
    private int id;
    
    public Soci(int id) {
        this.compte = Compte.getinstance();
        this.random = new Random();
        this.id = id;
    }

    public Compte getCompte() {
        return compte;
    }

    @Override
    public void run(){
        try{
            for(int i = 1;i <= maxAnys;i++){
                for(int j = 1;j <= 12;j++){
                    if(j%2==0){
                        compte.sumSaldo(aportacio);
                    }
                    else{
                        compte.resSaldo(aportacio);
                    }
                }

                int espera = random.nextInt(esperaMax);
                Thread.sleep(espera);
            }
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
