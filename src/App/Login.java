package App;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Login {
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
    public int runPaciente() throws IOException {
        int parseLines = 0;
        int logged = 0;

        String currentDirectory = System.getProperty("user.dir");

        List<String> fileStream = Files.readAllLines(Paths.get(currentDirectory + "\\accounts.txt"));
        int noOfLines = fileStream.size();

        Scanner scan = new Scanner(new File(currentDirectory + "/accounts.txt"));
        Scanner keyboard = new Scanner(System.in);

        String inpUser = keyboard.nextLine();
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
            System.out.println("Logado com sucesso!\n");
            return 1;
        } else {
            System.out.println("Conta nao encontrada.\n");
        }
        return 0;
    }

    public int runSaude() throws IOException {
        int parseLines = 0;
        int logged = 0;

        String currentDirectory = System.getProperty("user.dir");

        List<String> fileStream = Files.readAllLines(Paths.get(currentDirectory + "\\accounts.txt"));
        int noOfLines = fileStream.size();

        Scanner scan = new Scanner(new File(currentDirectory + "/accounts.txt"));
        Scanner keyboard = new Scanner(System.in);

        String inpUser = keyboard.nextLine();
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
            System.out.println("Logado com sucesso!\n");
            return 1;
        } else {
            System.out.println("Conta nao encontrada.\n");
        }
        return 0;
    }
}
