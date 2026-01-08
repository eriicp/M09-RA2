import java.util.Random;

public class DormAleatori extends Thread{
    private long tempsCreacio;

    public DormAleatori(String name){
        super(name);
        this.tempsCreacio = System.currentTimeMillis();
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int interval_aleatori = random.nextInt(1000);
            long tempstotal = System.currentTimeMillis() - this.tempsCreacio; 
            System.out.println(getName() + " ("+ i +") a dormir " + interval_aleatori + " total  " + tempstotal);
            try {
                    Thread.sleep(interval_aleatori);
                } catch (InterruptedException e) {
                    e.getMessage();
            }
        }
    }

    public static void main(String[] args) {
        DormAleatori Joan = new DormAleatori("Joan");
        DormAleatori Pep = new DormAleatori("Pep");

        Joan.start();
        Pep.start();

        System.out.println("--Fi de main -----------");
    }

}
