public class Compte {
    private float saldo;
    private static Compte INSTANCE;

    private Compte(){
        this.saldo = 0f;
    }

    public static Compte getinstance(){
        if(INSTANCE == null){
            INSTANCE = new Compte();
        }
        return INSTANCE;
    }

    public synchronized float getSaldo() {
        return saldo;
    }

    public synchronized void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public synchronized void sumSaldo(float aportacio){
        setSaldo(getSaldo() + aportacio);
    }

    public synchronized void resSaldo(float aportacio){
        setSaldo(getSaldo() - aportacio);
    }
    
}
