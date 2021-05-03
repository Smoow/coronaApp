package App;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        // Definição de ArrayLists que guardarão nossos objetos Pacientes e EquipeSaude.
        ArrayList<Paciente> pacienteArrayList = new ArrayList<>();
        ArrayList<EquipeSaude> equipeSaudeArrayList = new ArrayList<>();


        // Carregando dados de pacientes já cadastrados.
        pacienteArrayList = Paciente.loadAll();


        // Como não deixamos o cadastro aberto para a Equipe de Saúde, inserimos contas manualmente.
        equipeSaudeArrayList.add(new EquipeSaude("Agente Saúde 01", "saude01", "saude_pass"));
        equipeSaudeArrayList.add(new EquipeSaude("Agente Saúde 02", "saude02", "saude_pass"));
        equipeSaudeArrayList.add(new EquipeSaude("Agente Saúde 03", "saude03", "saude_pass"));

        // Entidade login - será responsável pela checagem e liberação de acesso.
        Login l1 = new Login();


        // Menu Principal
        MenuPrincipal menu = new MenuPrincipal();


        // Scanner para leitura futura - para ser usado aqui no Main e repassado onde precisar.
        Scanner sc1 = new Scanner(System.in).useDelimiter("\n");

        // Variáveis úteis para o Main.
        int menuLoop = 1;
        int choice;
        int account;


        // Menu principal.
        while (menuLoop == 1) {
            menu.info();

            // Esperando a escolha do usuário.
            choice = sc1.nextInt();
            switch (choice) {

                // Caso Login
                case 1:

                    // Verificando qual tipo de conta estará logando.
                    account = l1.state();

                    // account = 1 => Paciente | account != 1 => EquipeSaude.
                    if (account == 1) {
                        MenuPaciente.login(pacienteArrayList);
                    } else {
                        MenuEquipeSaude.login(equipeSaudeArrayList, pacienteArrayList);
                    }

                    break;

                // Caso Registrar.
                case 2:

                    // Registrando e salvando o novo paciente cadastrado.
                    Register.addPaciente(sc1, pacienteArrayList);
                    Paciente.saveAll(pacienteArrayList);
                    break;

                // Caso Sair.
                case 0:
                    System.out.println("\n\nSaindo do sistema... Até mais!");
                    menuLoop = 0;
                    sleep(300);
                    break;

                // Tratamento de entradas não definidas.
                default:
                    System.out.println("Opcao invalida...\nRetornando ao menu inicial.");
                    sleep(1000);
            }
        }
    }
}
