package App;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Contas testes
        Paciente p1 = new Paciente("Pedro", "4414");
        Paciente p2 = new Paciente("Jose", "nova_senha");

        // Menu Principal
        MenuPrincipal menu = new MenuPrincipal();

        // Scanner para leitura futura
        Scanner sc1 = new Scanner(System.in);
        int menuLoop = 1;
        int choice = 0;

        // Menu principal
        while (menuLoop == 1) {
            menu.info();

            choice = sc1.nextInt();
            switch (choice) {
                // Caso Login
                case 1:
                    int register = 0;
                    int logged = 0;

                    Login l1 = new Login();
                    logged = l1.run();

                    if (logged == 1) {
                        menuLoop = 0;
                        break;
                    }

                    register = menu.askRegister();



                    switch (register) {
                        case 1:
                            System.out.println("Implementar CADASTRO");
                            break;

                        case 2:
                            System.out.println("Até mais!!");
                            sleep(1000);
                            return;
                    }


            }


        }


    }
}
