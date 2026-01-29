public class Organitzador {
    public static void main(String[] args) {
       
        Esdeveniment Esdeveniment = new Esdeveniment(5);

        for(int i = 0;i < 10; i++){
            Assistent Assistent = new Assistent(Esdeveniment,"Assistent - " + i);
            Assistent.start();
        }
    } 
}