package App;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class MenuPaciente {
    public static void showSymptoms(ArrayList<Paciente> pacienteArrayList, int account_ID) throws IOException {
        System.out.println("=============================================");
        System.out.println("Os principais sintomas da covid sao:");
        System.out.println("1 - Febre         |    2 - Dor de cabeca");
        System.out.println("3 - Tosse seca    |    4 -  Cansaco");
        System.out.println("5 - Dor de cabeça |    6 -  Perda de paladar");
        System.out.println("=============================================\n");
        getSymptomsInfo(pacienteArrayList, account_ID);
    }

    public static void showOptions(ArrayList<Paciente> pacienteArrayList, int account_ID) throws InterruptedException, IOException {
        Scanner sc1 = new Scanner(System.in);
        int exit = 0;

        while (exit == 0) {

            // Solução para o caso de tentar logar em uma conta que acabou de registrar, sem fechar o sistema e voltar.
            if (account_ID > pacienteArrayList.size()) {
                account_ID = pacienteArrayList.size();
            }

            System.out.println("=============================================");
            System.out.printf("Bem vindo, %s!\n", pacienteArrayList.get(account_ID-1).getName());
            System.out.println("O que você deseja?\n");
            sleep(350);
            System.out.println("1 - Verificar e inserir sintomas");
            System.out.println("2 - Visualizar sintomas inseridos");
            System.out.println("3 - Visualizar mensagens disponíveis");
            System.out.println("\n0 - Sair da conta");

            int choice = sc1.nextInt();
            switch (choice) {
                case 1:
                    showSymptoms(pacienteArrayList, account_ID);
                    break;

                case 2:
                    String sintomas_atuais = pacienteArrayList.get(account_ID-1).getSintomas();
                    System.out.println("=============================================");

                    // Caso não houver sintomas para o paciente
                    if (sintomas_atuais.length() < 3) {
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
                    if (mensagens_atuais.length() < 3) {
                        System.out.println("Não há mensagens disponíveis");
                        sleep(300);
                        break;
                    }

                    // Se houver mensagens para o paciente
                    System.out.println("Mensagens disponíveis:");
                    String[] mensagens = mensagens_atuais.split(":");
                    for (String mensagem : mensagens) {
                        System.out.printf("%s\n", mensagem);
                    }
                    sleep(300);
                    break;

                case 0:
                    System.out.println("\nAté mais!!");
                    sleep(300);
                    exit = 1;
                    break;
            }
        }
    }

    public static void getSymptomsInfo(ArrayList<Paciente> pacienteArrayList, int account_ID) throws IOException {
        Scanner sc1 = new Scanner(System.in).useDelimiter("\n");
        String flag;

        System.out.println("[*] Voce esta sentindo algum dos sintomas? (S/N)");
        flag = sc1.next();
        if (flag.equalsIgnoreCase("n")) {
            System.out.println("Obrigado pelas informacoes!!\nCuide-se!\n");
        } else {
            String tempSintomas = "";
            StringBuilder sintomas = new StringBuilder();
            System.out.println("Quais? (INFORME 1 PALAVRA POR VEZ) - Digite S para enviar");
            while (true) {
                tempSintomas = sc1.next();
                if (tempSintomas.equalsIgnoreCase("s")) {
                    pacienteArrayList.get(account_ID-1).setSintomas(sintomas.toString());
                    Paciente.saveAll(pacienteArrayList);
                    return;
                }
                sintomas.append(tempSintomas).append(", ");
            }
        }
    }

    public static void login(ArrayList<Paciente> pacienteArrayList) throws InterruptedException, IOException {
        // Verificamos as credenciais
        Login l1 = new Login();
        int logged = l1.runPaciente(pacienteArrayList);
        int account_ID = l1.getID; // Capturando ID do Paciente

        // Caso as credenciais não conferem
        if (logged == 0) {
            return;
        }

        // Se conferir ok, mostramos as opções do menu do Paciente
        showOptions(pacienteArrayList, account_ID);
    }
}
