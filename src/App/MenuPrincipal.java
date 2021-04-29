package App;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class MenuPrincipal {
    public void info() {
        System.out.println("===================================");
        System.out.println("Bem-vindo!\nO que deseja fazer?\n");
        System.out.println("1. Realizar Login");
        System.out.println("2. Realizar Cadastro");
        System.out.println("===================================");
    }

    public int askRegister() throws InterruptedException {
        int register = 0;
        Scanner sc1 = new Scanner(System.in);

        System.out.println("Deseja realizar um cadastro?");
        sleep(250);
        System.out.println("1 - Sim");
        System.out.println("2 - Nao");

        register = sc1.nextInt();
        return register;
    }

    public void showSymptoms() {
        System.out.println("=============================================");
        System.out.println("Os principais sintomas da covid sao:");
        System.out.println("1 - Febre         |    2 - Dor de cabeca");
        System.out.println("3 - Tosse seca    |    4 -  Cansaco");
        System.out.println("5 - Dor de cabeça |    6 -  Perda de paladar");
        System.out.println("=============================================\n");
    }

    public int getSymptoms() {
        Scanner sc1 = new Scanner(System.in);
        String flag = "N";

        System.out.println("[*] Voce esta sentindo algum dos sintomas? (S/N)");
        sc1.next();
        if (flag.toLowerCase().equals("n")) {
            System.out.println("Obrigado pelas informacoes!!\nCuide-se!\n");
            return 0;
        } else {
            System.out.println("..");
        }
        return 0;
    }
}
