package App;

import java.io.FileWriter;
import java.io.IOException;

public class Paciente extends Usuario {
    private String cpf;
    private String telefone;
    private String cidade;
    private String estado;
    private String sintomas;



    public Paciente(String name, String user, String pass, String cpf, String telefone, String cidade, String estado) {
        this.id = ++Usuario.idCount;
        this.name = name;
        this.username = user;
        this.password = pass;
        this.cpf = cpf;
        this.telefone = telefone;
        this.cidade = cidade;
        this.estado = estado;

        try {
            FileWriter writer = new FileWriter("pacientsAccounts.txt", true);
            writer.write(user + '\n');
            writer.write(pass + '\n');
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
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

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void getInfo() {
        System.out.printf("ID: %d\n", getID());
        System.out.printf("CPF: %s\n", getCpf());
        System.out.printf("Nome: %s\n", getName());
        System.out.printf("Telefone: %s\n", getTelefone());
        System.out.printf("Cidade: %s\n", getCidade());
        System.out.printf("Estado: %s\n", getEstado());
        System.out.printf("Sintomas: %s\n", getSintomas());
        System.out.printf("Username: %s\n", getUser());
        System.out.printf("Pass: %s\n\n", getPass());
    }


}
