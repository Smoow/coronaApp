package App;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Register {
    public static ArrayList<Paciente> addPaciente(Scanner scanner, ArrayList<Paciente> pacienteArrayList) throws InterruptedException {
        System.out.println("=================MENU REGISTRO=================");
        System.out.println("Informe seu CPF (APENAS NUMEROS): ");
        String tempCPF = scanner.next();
        System.out.println("Informe seu nome: ");
        String tempName = scanner.next();
        System.out.println("Informe seu telefone (DDD-NUMERO): ");
        String tempTel = scanner.next();
        System.out.println("Informe sua cidade (NOME COMPLETO): ");
        String tempCity = scanner.next();
        System.out.println("Informe seu estado (APENAS SIGLA UF): ");
        sleep(50);
        String tempState = scanner.next();
        System.out.println("Escolha um username: ");
        String tempUser = scanner.next();
        System.out.println("Escolha uma senha: ");
        String tempPass = scanner.next();

        pacienteArrayList.add(new Paciente(tempName, tempUser, tempPass, tempCPF, tempTel, tempCity, tempState));
        System.out.println("\nCadastrado com sucesso!");
        sleep(1000);

        return pacienteArrayList;
    }
}
