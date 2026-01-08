import java.util.Scanner;

public class Coet {
    private Motor[] motors;

    public Coet() {
        motors = new Motor[4];
        for (int i = 0; i < motors.length; i++) {
            motors[i] = new Motor(i);
        }
    }

    public void arranca() {
        for (Motor m : motors) {
            m.start();
        }
    }

    public void passaAPotencia(int p) {
        if (p < 0 || p > 10) {
            System.out.println("Error: La potència ha d'estar entre 0 i 10.");
            return;
        }

        System.out.println("Passant a potència " + p);
        
        for (Motor m : motors) {
            m.setPotencia(p);
        }
    }

    public static void main(String[] args) {
        Coet coet = new Coet();
        
        coet.arranca();

        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            if (scanner.hasNextInt()) {
                int p = scanner.nextInt();
                
                coet.passaAPotencia(p);

                if (p == 0) {
                    break;
                }
            }
        }
        scanner.close();
    }
}