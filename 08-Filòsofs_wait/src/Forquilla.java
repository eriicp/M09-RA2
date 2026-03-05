package src;
public class Forquilla {
    public static final int LLIURE = -1;
    private int id;
    private int propietari;

    public Forquilla(int id) {
        this.id = id;
        this.propietari = LLIURE;
    }

    public int getPropietari() { return propietari; }
    public void setPropietari(int propietari) { this.propietari = propietari; }
    public int getId() { return id; }
}