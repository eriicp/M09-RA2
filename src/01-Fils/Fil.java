public class Fil extends Thread {
    private boolean esEstricte;

    public Fil(String nom, boolean esEstricte) {
        super(nom);
        this.esEstricte = esEstricte;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 9; i++) {
            System.out.println(getName() + " " + i);

            if (esEstricte) {
                try {
                    Thread.sleep(1); // 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                for (int j = 0; j < 1000; j++) {
                }
            }
        }
        System.out.println("Acaba el fil " + getName());
    }
}
