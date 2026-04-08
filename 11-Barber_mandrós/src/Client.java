public class Client {
    private String nom;

    // Constructor con id entero que se convierte a nombre 
    public Client(int id) {
        this.nom = "Client-" + id;
    }

    // Método tallarseElCabell
    public void tallarseElCabell() {
        System.out.println("Tallant cabell a " + nom);
    }

    // Getter de nom 
    public String getNom() {
        return nom;
    }
}