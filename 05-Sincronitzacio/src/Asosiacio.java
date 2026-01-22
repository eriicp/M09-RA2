public class Asosiacio {
    private int numSocis = 1000;
    private Soci[] socis = new Soci[numSocis];

    public Asosiacio(){

    }

 
    public void iniciaCompteTempsSocis(){
        for (int i = 0; i < numSocis; i++){
            socis[i] = new Soci(i +1);
            socis[i].start();
        }
    }

    public void esperaPeriodeSocis(){
        for (int i = 0; i < numSocis; i++){
            try{
                socis[i].join();
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }

    }

    public void mostraBalancComptes(){
        System.out.println("Saldo final: " + Compte.getinstance().getSaldo());
    }

    public static void main(String[] args) {
        Asosiacio asosiacio = new Asosiacio();
        asosiacio.iniciaCompteTempsSocis();
        asosiacio.esperaPeriodeSocis();
        asosiacio.mostraBalancComptes();
    }
}
