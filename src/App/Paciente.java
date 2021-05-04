package App;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Paciente extends Usuario {

    private String cpf;
    private String telefone;
    private String cidade;
    private String estado;
    private String sintomas;
    private String mensagens;



    public Paciente(String name, String user, String pass, String cpf, String telefone, String cidade, String estado, String sintomas, String msg) {
        this.id = ++Usuario.idCount;
        this.name = name;
        this.username = user;
        this.password = pass;
        this.cpf = cpf;
        this.telefone = telefone;
        this.cidade = cidade;
        this.estado = estado;

        if (sintomas.isEmpty() || sintomas.isBlank()) {
            this.sintomas = " ";
        } else {
            this.sintomas = sintomas;
        }

        if (msg.isEmpty() || msg.isBlank()) {
            this.mensagens = " ";
        } else {
            this.mensagens = msg;
        }

    }


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public void setMensagens(String mensagens) {
        this.mensagens = mensagens;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getCidade() {
        return this.cidade;
    }

    public String getEstado() {
        return this.estado;
    }

    public String getSintomas() {
        return this.sintomas;
    }

    public String getMensagens() {
        return this.mensagens;
    }

    public void getInfo() {
        System.out.println("---------------------------------");
        System.out.printf("ID: %d\n", getID());
        System.out.printf("CPF: %s\n", getCpf());
        System.out.printf("Nome: %s\n", getName());
        System.out.printf("Telefone: %s\n", getTelefone());
        System.out.printf("Cidade: %s\n", getCidade());
        System.out.printf("Estado: %s\n", getEstado());
        System.out.printf("Sintomas: %s\n", getSintomas());
        System.out.printf("Username: %s\n", getUser());
        System.out.println("---------------------------------\n");
    }

    public static void saveAll(ArrayList<Paciente> pacienteArrayList) throws IOException {

        // Obtendo o diretório atual
        String currentDirectory = System.getProperty("user.dir");

        File file1 = new File(currentDirectory + "/pacientsAccounts.txt");
        FileWriter fw_tmp = new FileWriter(file1, false);
        PrintWriter pw = new PrintWriter(fw_tmp);

        fw_tmp.close();

        pw.print("");

        for (Paciente paciente : pacienteArrayList) {
            String outputText = paciente.getName()
                    + "|" + paciente.getUser() + "|" + paciente.getPass()
                    + "|" + paciente.getCpf() + "|" + paciente.getTelefone()
                    + "|" + paciente.getCidade() + "|" + paciente.getEstado()
                    + "|" + paciente.getSintomas() + "|" + paciente.getMensagens()
                    + "|";

            FileWriter fw = new FileWriter(file1, true);
            PrintWriter pw_final = new PrintWriter(fw);

            pw_final.println(outputText);
            pw.close();
            fw.close();
        }


    }

    public static ArrayList<Paciente> loadAll() throws IOException {

        String currentDirectory = System.getProperty("user.dir");

        File file = new File(currentDirectory + "/pacientsAccounts.txt");
        Scanner sc1 = new Scanner(file);

        ArrayList<Paciente> pacienteArrayList = new ArrayList<Paciente>();

        while (sc1.hasNextLine()) {
            String line = sc1.nextLine();

            String[] items = line.split("\\|");

            // Colocar nos objetos
            String name = items[0];
            String user = items[1];
            String pass = items[2];
            String cpf = items[3];
            String telefone = items[4];
            String cidade = items[5];
            String estado = items[6];
            String sintomas = items[7];
            String mensagens = items[8];



            Paciente pc = new Paciente(name, user, pass, cpf, telefone, cidade, estado, sintomas, mensagens);
            pacienteArrayList.add(pc);
        }


        return pacienteArrayList;
    }

}
