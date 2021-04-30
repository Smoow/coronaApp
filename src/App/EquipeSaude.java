package App;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class EquipeSaude extends Usuario {

    public EquipeSaude(String name, String user, String pass) {
        this.id = ++Usuario.idCount;
        this.name = name;
        this.username = user;
        this.password = pass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser(String user) {
        this.username = user;
    }

    public void setPass(String pass) {
        this.password = pass;
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getUser() {
        return this.username;
    }

    public String getPass() {
        return this.password;
    }

    public static void consultarPaciente(ArrayList<Paciente> pacienteArrayList) {
        int loop = 1;
        Scanner sc1 = new Scanner(System.in);

        while (loop == 1) {

            System.out.println("=========================");
            System.out.println("1 - Exibir todos os pacientes");
            System.out.println("2 - Exibir pacientes por estado");
            System.out.println("3 - Exibir pacientes por cidade");
            System.out.println("4 - Exibir pacientes com sintomas");
            System.out.println("\n0 - Voltar ao menu anterior");
            int choice = sc1.nextInt();

            switch (choice) {
                case 1:
                    for (int counter = 0; counter < pacienteArrayList.size(); counter++) {
                        pacienteArrayList.get(counter).getInfo();
                    }
                    break;

                case 2:
                    System.out.println("Por favor, digite a sigla do estado. (ex: SP)");
                    String estado = sc1.next();

                    for (int counter = 0; counter < pacienteArrayList.size(); counter++) {
                        if (pacienteArrayList.get(counter).getEstado().toLowerCase().equals(estado)) {
                            pacienteArrayList.get(counter).getInfo();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Por favor, digite o nome da cidade ou parte do nome da cidade. (ex: Catanduva ou Catan)");
                    String cidade = sc1.next();

                    for (int counter = 0; counter < pacienteArrayList.size(); counter++) {
                        if (pacienteArrayList.get(counter).getCidade().toLowerCase().contains(cidade)) {
                            pacienteArrayList.get(counter).getInfo();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Por favor, escolha uma opção:");
                    System.out.println("1 - Exibir pacientes com algum sintoma");
                    System.out.println("2 - Selecionar pacientes com sintoma especifico");
                    int choice_sintoma = sc1.nextInt();

                    switch (choice_sintoma) {
                        case 1:
                            for (int counter = 0; counter < pacienteArrayList.size(); counter++) {
                                if (pacienteArrayList.get(counter).getSintomas() != null) {
                                    pacienteArrayList.get(counter).getInfo();
                                }
                            }
                            break;

                        case 2:
                            System.out.println("=============================================");
                            System.out.println("Possiveis sintomas:");
                            System.out.println("1 - Febre         |    2 - Dor de cabeca");
                            System.out.println("3 - Tosse seca    |    4 -  Cansaco");
                            System.out.println("5 - Dor de cabeça |    6 -  Perda de paladar");
                            System.out.println("=============================================\n");
                            System.out.println("Qual? (Informe o nome ou começo do nome)");
                            String sintoma = sc1.next();

                            for (int counter = 0; counter < pacienteArrayList.size(); counter++) {
                                if (pacienteArrayList.get(counter).getSintomas().toLowerCase().contains(sintoma)) {
                                    pacienteArrayList.get(counter).getInfo();
                                }
                            }
                            break;
                    }

                case 0:
                    loop = 0;
                    break;

                default:
                    System.out.println("Opção inválida!\nTente novamente.");
                    break;

            }
        }
    }

    public static void inserirMensagem(ArrayList<Paciente> pacienteArrayList) {
        int flag = 0;
        System.out.println("Pacientes cadastrados:");

        for (int counter = 0; counter < pacienteArrayList.size(); counter++) {
            System.out.println("--------------------------------------------------------");
            System.out.printf("ID: %d | Nome: %s | Telefone: %s\n", pacienteArrayList.get(counter).getID(), pacienteArrayList.get(counter).getName(), pacienteArrayList.get(counter).getTelefone());
            System.out.println("--------------------------------------------------------");
        }

        System.out.println("Por favor, insira o ID do paciente que deseja registrar a mensagem");
        Scanner sc1 = new Scanner(System.in).useDelimiter("\n");
        int id_digitado = sc1.nextInt();
        int id_atual = 0;

        for (int counter = 0; counter < pacienteArrayList.size(); counter++) {
            if (pacienteArrayList.get(counter).getID() == id_digitado) {
                id_atual = counter;
                flag = 1;
                break;
            }
        }

        if (flag == 0) {
            System.out.println("ID não encontrado.");
            return;
        }

        System.out.println("Insira o conteúdo da mensagem:");
        String msg = pacienteArrayList.get(id_atual).getMensagens();

        if (msg == null) {
            msg = "";
        }

        String msg_nova = sc1.next();
        msg_nova = msg_nova + "\n\n" + msg;
        pacienteArrayList.get(id_atual).setMensagens(msg_nova);
    }
}
