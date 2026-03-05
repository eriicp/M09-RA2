package src;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Forquilla {
    public static final int LLIURE = -1;
    private int id;
    private int propietari;
    Lock bloqueig = new ReentrantLock(true);

    public Forquilla(int id) {
        this.id = id;
        this.propietari = LLIURE;
    }

    public void agafar(){
        bloqueig.lock();
    }

    public void deixar(){
        if(((ReentrantLock) bloqueig).isHeldByCurrentThread()){
            bloqueig.unlock();
        }
    }

    public int getPropietari() { return propietari; }
    public void setPropietari(int propietari) { this.propietari = propietari; }
    public int getId() { return id; }
}