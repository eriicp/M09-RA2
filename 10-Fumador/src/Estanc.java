import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estanc extends Thread {
    private List<Tabac> llistaTabac;
    private List<Paper> llistaPaper;
    private List<Llumi> llistaLlumins;
    private boolean obert;
    private Random random;

    public Estanc() {
        llistaTabac = new ArrayList<>();
        llistaPaper = new ArrayList<>();
        llistaLlumins = new ArrayList<>();
        obert = true;
        random = new Random();
    }

    public synchronized void addTabac() {
        llistaTabac.add(new Tabac());
        System.out.println("Afegint tabac");
        notifyAll();
    }

    public synchronized void addPaper() {
        llistaPaper.add(new Paper());
        System.out.println("Afegint Paper");
        notifyAll();
    }

    public synchronized void addLlumi() {
        llistaLlumins.add(new Llumi());
        System.out.println("Afegint Llumi");
        notifyAll();
    }

    public synchronized void nouSubministrament() {
        int r = random.nextInt(3);
        if (r == 0) {
            addTabac();
        } else if (r == 1) {
            addPaper();
        } else {
            addLlumi();
        }
    }

    public synchronized Tabac venTabac(int id) throws InterruptedException {
        System.out.println("Fumador " + id + " comprant Tabac");
        while (llistaTabac.isEmpty() && obert) {
            wait();
        }
        if (!llistaTabac.isEmpty()) {
            return llistaTabac.remove(0);
        }
        return null;
    }

    public synchronized Paper venPaper(int id) throws InterruptedException {
        System.out.println("Fumador " + id + " comprant Paper");
        while (llistaPaper.isEmpty() && obert) {
            wait();
        }
        if (!llistaPaper.isEmpty()) {
            return llistaPaper.remove(0);
        }
        return null;
    }

    public synchronized Llumi venLlumi(int id) throws InterruptedException {
        System.out.println("Fumador " + id + " comprant Llumi");
        while (llistaLlumins.isEmpty() && obert) {
            wait();
        }
        if (!llistaLlumins.isEmpty()) {
            return llistaLlumins.remove(0);
        }
        return null;
    }

    public synchronized void tancarEstanc() {
        obert = false;
        System.out.println("Estanc tancat");
        notifyAll();
    }

    @Override
    public void run() {
        System.out.println("Estanc obert");
        while (obert) {
            nouSubministrament();
            try {
                Thread.sleep(500 + random.nextInt(1001));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}