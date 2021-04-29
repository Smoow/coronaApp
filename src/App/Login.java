package App;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Login {
    public int run() throws IOException {
        int parseLines = 0;
        int logged = 0;

        String currentDirectory = System.getProperty("user.dir");

        List<String> fileStream = Files.readAllLines(Paths.get(currentDirectory + "\\accounts.txt"));
        int noOfLines = fileStream.size();

        Scanner scan = new Scanner(new File(currentDirectory + "/accounts.txt"));
        Scanner keyboard = new Scanner(System.in);

        String inpUser = keyboard.nextLine();
        String inpPass = keyboard.nextLine(); // gets input from user

        while (parseLines < (noOfLines / 2)) {
            String user = scan.nextLine();
            String pass = scan.nextLine(); // looks at selected file in scan

            if (inpUser.equals(user) && inpPass.equals(pass)) {
                logged = 1;
                break;
            }
            parseLines++;
        }
        if (logged == 1) {
            System.out.println("Logged in\n");
            return 1;
        } else {
            System.out.println("Account not found\n");
        }
        return 0;
    }
}
