package App;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class MenuPaciente {
    public static void showSymptoms(ArrayList<Paciente> pacienteArrayList, int account_ID) {
        System.out.println("=============================================");
        System.out.println("Os principais sintomas da covid sao:");
        System.out.println("1 - Febre         |    2 - Dor de cabeca");
        System.out.println("3 - Tosse seca    |    4 -  Cansaco");
        System.out.println("5 - Dor de cabeça |    6 -  Perda de paladar");
        System.out.println("=============================================\n");
        getSymptomsInfo(pacienteArrayList, account_ID);
    }

    public static void showOptions(ArrayList<Paciente> pacienteArrayList, int account_ID) throws InterruptedException {
        Scanner sc1 = new Scanner(System.in);
        int exit = 0;

        while (exit == 0) {

            System.out.println("=============================================");
            System.out.printf("Bem vindo, %s!\n", pacienteArrayList.get(account_ID - 1).getName());
            System.out.println("O que você deseja?\n");
            sleep(350);
            System.out.println("1 - Verificar e inserir sintomas");
            System.out.println("2 - Visualizar sintomas inseridos");
            System.out.println("3 - Visualizar mensagens disponíveis");
            System.out.println("\n4 - Sair da conta");
            int choice = sc1.nextInt();

            switch (choice) {
                case 1:
                    showSymptoms(pacienteArrayList, account_ID);
                    break;

                case 2:
                    String sintomas_atuais = pacienteArrayList.get(account_ID-1).getSintomas();
                    System.out.println("=============================================");

                    // Caso não houver sintomas para o paciente
                    if (sintomas_atuais == null) {
                        System.out.println("Sem sintomas registrados");
                        sleep(300);
                        break;
                    }

                    System.out.printf("Sintomas registrados: %s\n", sintomas_atuais);
                    break;

                case 3:
                    String mensagens_atuais = pacienteArrayList.get(account_ID-1).getMensagens();
                    System.out.println("=============================================");

                    // Caso não houver mensagens para o paciente
                    if (mensagens_atuais == null) {
                        System.out.println("Não há mensagens disponíveis");
                        sleep(300);
                        break;
                    }

                    // Se houver mensagens para o paciente
                    System.out.println("Mensagens disponíveis:");
                    System.out.printf("%s", mensagens_atuais);
                    sleep(300);
                    break;

                case 4:
                    System.out.println("\nAté mais!!");
                    sleep(300);
                    exit = 1;
                    break;
            }
        }
    }

    public static void getSymptomsInfo(ArrayList<Paciente> pacienteArrayList, int account_ID) {
        Scanner sc1 = new Scanner(System.in).useDelimiter("\n");
        String flag;

        System.out.println("[*] Voce esta sentindo algum dos sintomas? (S/N)");
        flag = sc1.next();
        if (flag.toLowerCase().equals("n")) {
            System.out.println("Obrigado pelas informacoes!!\nCuide-se!\n");
        } else {
            String tempSintomas = "";
            String sintomas = "";
            System.out.println("Quais? (INFORME 1 PALAVRA POR VEZ) - Digite S para enviar");
            while (true) {
                tempSintomas = sc1.next();
                if (tempSintomas.toLowerCase().equals("s")) {
                    pacienteArrayList.get(account_ID-1).setSintomas(sintomas);
                    return;
                }
                sintomas += tempSintomas + ", ";
            }
        }
    }
}
