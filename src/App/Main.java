package App;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Login l1 = new Login();
        ArrayList<Paciente> pacienteArrayList = new ArrayList<>();

        // Menu Principal
        MenuPrincipal menu = new MenuPrincipal();

        // Scanner para leitura futura
        Scanner sc1 = new Scanner(System.in).useDelimiter("\n");

        int menuLoop = 1;
        int choice;
        int account;
        int account_ID;

        // Menu principal
        while (menuLoop == 1) {
            menu.info();

            choice = sc1.nextInt();
            switch (choice) {

                // Caso Login
                case 1:
                    int register;
                    int logged;

                    // Verificando qual tipo de conta estará logando
                    account = l1.state();

                    // Se a conta for do tipo PACIENTE
                    if (account == 1) {

                        // Verificamos as credenciais
                        logged = l1.runPaciente(pacienteArrayList);
                        account_ID = l1.getID; // Capturando ID do Paciente

                        // Caso as credenciais não conferem
                        if (logged == 0) {
                            break;
                        }

                        // Se conferir ok, mostramos as opções do menu do Paciente
                        MenuPaciente.showOptions(pacienteArrayList, account_ID);
                    } else {
                        logged = l1.runSaude();
                    }

                    if (logged == 0) {
                        register = menu.askRegister();
                        switch (register) {
                            case 1:
                                Register.addPaciente(sc1, pacienteArrayList);
                                break;

                            case 2:
                                System.out.println("Até mais!!");
                                sleep(1000);
                                return;
                        }
                    }

                    if (logged == 1) {
                        menuLoop = 0;
                        break;
                    }

                    break;

                // Caso Registrar
                case 2:
                    Register.addPaciente(sc1, pacienteArrayList);
                    break;


                default:
                    System.out.println("Opcao invalida...\nRetornando ao menu inicial.");
                    sleep(1000);
            }
        }
    }
}
