package src;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Forquilla {
    private int id;
    Lock bloqueig = new ReentrantLock(true);

    public Forquilla(int id) {
        this.id = id;
    }

    public void agafar(){
        bloqueig.lock();
    }

    public void deixar(){
        if(((ReentrantLock) bloqueig).isHeldByCurrentThread()){
            bloqueig.unlock();
        }
    }

    public int getId() { return id; }
}