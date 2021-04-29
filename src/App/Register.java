package App;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Register {
    public static ArrayList<Paciente> addPaciente(Scanner scanner, ArrayList<Paciente> pacienteArrayList) throws InterruptedException {
        System.out.println("Escolha um username: ");
        String tempUser = scanner.next();
        System.out.println("Escolha uma senha: ");
        String tempPass = scanner.next();

        pacienteArrayList.add(new Paciente(tempUser, tempPass));
        System.out.println("Cadastrado com sucesso!");
        sleep(1000);

        return pacienteArrayList;
    }
}
