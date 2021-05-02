package App;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        ArrayList<Paciente> pacienteArrayList = new ArrayList<>();
        ArrayList<EquipeSaude> equipeSaudeArrayList = new ArrayList<>();

        // Carregando dados de pacientes já cadastrados
        pacienteArrayList = Paciente.loadAll();


        // Como não deixamos o cadastro aberto para a Equipe de Saúde, inserimos contas manualmente
        equipeSaudeArrayList.add(new EquipeSaude("Agente Saúde 01", "saude01", "saude_pass"));
        equipeSaudeArrayList.add(new EquipeSaude("Agente Saúde 02", "saude02", "saude_pass"));
        equipeSaudeArrayList.add(new EquipeSaude("Agente Saúde 03", "saude03", "saude_pass"));

        Login l1 = new Login();

        // Menu Principal
        MenuPrincipal menu = new MenuPrincipal();

        // Scanner para leitura futura
        Scanner sc1 = new Scanner(System.in).useDelimiter("\n");

        int menuLoop = 1;
        int choice;
        int account;

        // Menu principal
        while (menuLoop == 1) {
            menu.info();

            choice = sc1.nextInt();
            switch (choice) {

                // Caso Login
                case 1:
                    // Verificando qual tipo de conta estará logando
                    account = l1.state();

                    // Se a conta for do tipo PACIENTE
                    if (account == 1) {
                        MenuPaciente.login(pacienteArrayList);
                    } else {
                        MenuEquipeSaude.login(equipeSaudeArrayList, pacienteArrayList);
                    }

                    break;

                // Caso Registrar
                case 2:
                    // Registrando e salvando o novo paciente cadastrado
                    Register.addPaciente(sc1, pacienteArrayList);
                    Paciente.saveAll(pacienteArrayList);
                    break;

                case 0:
                    System.out.println("\n\nSaindo do sistema... Até mais!");
                    sleep(300);
                    menuLoop = 0;
                    break;

                default:
                    System.out.println("Opcao invalida...\nRetornando ao menu inicial.");
                    sleep(1000);
            }
        }
    }
}
