public class Forquilla {
    private int id;
    private boolean enUs;

    public Forquilla(int id) {
        this.id = id;
        this.enUs = false;
    }

    public synchronized boolean getEnUs() { 
        return enUs; 
    }
    
    public synchronized void setEnUs(boolean enUs) { 
        this.enUs = enUs; 
    }

    public int getId() { 
        return id; 
    }
}