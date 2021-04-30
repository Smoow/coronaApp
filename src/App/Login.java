package App;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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
                    System.out.println("Opcao invalida\nTente novamente.");
                    sleep(1000);
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
                }
        }
    }
    public int runPaciente(ArrayList<Paciente> pacienteArrayList) throws IOException, InterruptedException {
        int parseLines = 0;
        int logged = 0;


        // Método de checagem - COM PERSISTENCIA (NAO ESTÁ SENDO UTILIZADO NO MOMENTO)
        String currentDirectory = System.getProperty("user.dir");

        List<String> fileStream = Files.readAllLines(Paths.get(currentDirectory + "\\pacientsAccounts.txt"));
        int noOfLines = fileStream.size();

        Scanner scan = new Scanner(new File(currentDirectory + "/pacientsAccounts.txt"));
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Usuario:");
        String inpUser = keyboard.nextLine();
        System.out.println("Senha:");
        String inpPass = keyboard.nextLine(); // gets input from user

        while (parseLines < (noOfLines / 2)) {
            String user = scan.nextLine();
            String pass = scan.nextLine(); // looks at selected file in scan

            if (inpUser.equals(user) && inpPass.equals(pass)) {
                logged = 1;
                break;
            }
            parseLines++;
        }

        // Método de checagem - SEM PERSISTENCIA (EM USO)
        for (int counter = 0; counter < pacienteArrayList.size(); counter++) {
            int tempID = pacienteArrayList.get(counter).getID();
            String tempUser = pacienteArrayList.get(counter).getUser();
            String tempPass = pacienteArrayList.get(counter).getPass();

            // Checando credenciais - SEM PERSISTENCIA
            if (inpUser.equals(tempUser) && inpPass.equals(tempPass)) {
                logged = 1;
                getID = tempID;
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

    public int runSaude() throws IOException {
        int parseLines = 0;
        int logged = 0;

        String currentDirectory = System.getProperty("user.dir");

        List<String> fileStream = Files.readAllLines(Paths.get(currentDirectory + "\\staffAccounts.txt"));
        int noOfLines = fileStream.size();

        Scanner scan = new Scanner(new File(currentDirectory + "/staffAccounts.txt"));
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Usuario:");
        String inpUser = keyboard.nextLine();
        System.out.println("Senha:");
        String inpPass = keyboard.nextLine(); // gets input from user

        while (parseLines < (noOfLines / 2)) {
            String user = scan.nextLine();
            String pass = scan.nextLine(); // looks at selected file in scan

            if (inpUser.equals(user) && inpPass.equals(pass)) {
                logged = 1;
                break;
            }
            parseLines++;
        }
        if (logged == 1) {
            System.out.println("\n\n[EQUIPE] Logado com sucesso!\n");
            return 1;
        } else {
            System.out.println("\n\nConta nao encontrada.\n");
        }
        return 2;
    }
}
