package App;

import java.io.FileWriter;
import java.io.IOException;

public class Paciente extends Usuario {
    public Paciente(String user, String pass) {
        this.username = user;
        this.password = pass;
        this.id = ++Usuario.idCount;

        try {
            FileWriter writer = new FileWriter("accounts.txt", true);
            writer.write(user + '\n');
            writer.write(pass + '\n');
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void getInfo() {
        System.out.printf("ID: %d\n", this.id);
        System.out.printf("Name: %s\n", this.username);
        System.out.printf("Pass: %s\n\n", this.password);
    }
}
