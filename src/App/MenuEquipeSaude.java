package App;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class MenuEquipeSaude {
    public static void login(ArrayList<EquipeSaude> equipeSaudeArrayList, ArrayList<Paciente> pacienteArrayList) throws InterruptedException, IOException {
        // Verificamos as credenciais
        Login l1 = new Login();
        int logged = l1.runSaude(equipeSaudeArrayList);
        int account_ID = l1.getID; // Capturando ID do Agente

        // Caso as credenciais não conferem
        if (logged == 0) {
            return;
        }

        // Se conferir ok, mostramos as opções do menu do Paciente
        showOptions(equipeSaudeArrayList, account_ID, pacienteArrayList);
    }

    private static void showOptions(ArrayList<EquipeSaude> equipeSaudeArrayList, int account_id, ArrayList<Paciente> pacienteArrayList) throws InterruptedException {
        Scanner sc1 = new Scanner(System.in);
        int exit = 0;

        while (exit == 0) {

            System.out.println("=============================================");
            System.out.printf("Bem vindo, %s!\n", equipeSaudeArrayList.get(account_id-1).getName());
            System.out.println("O que você deseja?\n");
            sleep(350);
            System.out.println("1 - Consultar pacientes");
            System.out.println("2 - Inserir mensagens (visitas)");
            System.out.println("\n0 - Sair da conta");

            int choice = sc1.nextInt();

            switch (choice) {
                case 1:
                    EquipeSaude.consultarPaciente(pacienteArrayList);
                    break;

                case 2:
                    EquipeSaude.inserirMensagem(pacienteArrayList);
                    break;

                case 0:
                    System.out.println("\nAté mais!!");
                    sleep(300);
                    exit = 1;
                    break;
            }
        }
    }
}
