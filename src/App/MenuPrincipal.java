package App;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class MenuPrincipal {
    public void info() {
        System.out.println("===================================");
        System.out.println("Bem-vindo!\nO que deseja fazer?\n");
        System.out.println("1 - Realizar Login");
        System.out.println("2 - Realizar Cadastro");
        System.out.println("\n0. - Sair do sistema ");
        System.out.println("===================================");
    }

    public static int askRegister() throws InterruptedException {
        int register = 0;
        Scanner sc1 = new Scanner(System.in);

        System.out.println("Deseja realizar um cadastro?");
        sleep(250);
        System.out.println("1 - Sim");
        System.out.println("2 - Nao");

        register = sc1.nextInt();
        return register;
    }
}
