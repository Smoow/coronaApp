package App;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Login {

    public int getID;

    public int state() throws InterruptedException {
        // return 1 = paciente | return 2 = saude
        int account;

        while (true) {
            System.out.println("Por favor, informe seu perfil:");
            System.out.println("1 - Paciente");
            System.out.println("2 - Equipe de Saude");
            Scanner sc1 = new Scanner(System.in);
            account = sc1.nextInt();

            switch (account) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                default:
                    System.out.println("\nOpcao invalida\nTente novamente.");
                    sleep(600);
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
                }
        }
    }
    public int runPaciente(ArrayList<Paciente> pacienteArrayList) throws InterruptedException {
        int logged = 0;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Usuario:");
        String inpUser = keyboard.nextLine();
        System.out.println("Senha:");
        String inpPass = keyboard.nextLine(); // gets input from user


        // Método de checagem
        for (Paciente paciente : pacienteArrayList) {
            int tempID = paciente.getID();
            String tempUser = paciente.getUser();
            String tempPass = paciente.getPass();

            // Checando credenciais
            if (inpUser.equals(tempUser) && inpPass.equals(tempPass)) {
                logged = 1;
                this.getID = tempID;
                break;
            }
        }

        if (logged == 1) {
            System.out.println("\n\n[PACIENTE] Logado com sucesso!\n");
            sleep(300);
            return 1;
        } else {
            System.out.println("\n\nConta nao encontrada.\n");
            return 0;
        }
    }

    public int runSaude(ArrayList<EquipeSaude> equipeSaudeArrayList) throws InterruptedException {
        int logged = 0;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Usuario:");
        String inpUser = keyboard.nextLine();
        System.out.println("Senha:");
        String inpPass = keyboard.nextLine(); // gets input from user


        // Método de checagem
        for (EquipeSaude equipeSaude : equipeSaudeArrayList) {
            int tempID = equipeSaude.getID();
            String tempUser = equipeSaude.getUser();
            String tempPass = equipeSaude.getPass();

            // Checando credenciais
            if (inpUser.equals(tempUser) && inpPass.equals(tempPass)) {
                logged = 1;
                this.getID = tempID;
                break;
            }
        }

        if (logged == 1) {
            System.out.println("\n\n[SAÚDE] Logado com sucesso!\n");
            sleep(300);
            return 1;
        } else {
            System.out.println("\n\nConta nao encontrada.\n");
            return 0;
        }
    }
}
