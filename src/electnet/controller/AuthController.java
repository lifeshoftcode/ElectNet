package electnet.controller;

import electnet.utils.FileManager;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AuthController {

    private static final String DEFAULT_USERNAME = "admin";
    private static final String DEFAULT_PASSWORD = "123123";
    private static final String CREDENTIALS_FILE = "database/users.txt";

     public boolean signInUser( String username, String password) throws IOException {
         
        File file = new File(CREDENTIALS_FILE);
        if (!file.exists()) {
            return false;
        }

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] credentials = line.split(";");

            if (credentials.length >= 2) {
                String storedUsername = credentials[0];
                String storedPassword = credentials[1];

                if (storedUsername.equals(username) && storedPassword.equals(password)) {
                    scanner.close();
                    return true; // Credenciales coinciden
                }
            }
        }
        scanner.close();
        return false; // Credenciales no encontradas
    }

    public void checkAdminUser() {
        try {
            File file = new File(CREDENTIALS_FILE);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileManager fileManager = new FileManager();
            String credentials = DEFAULT_USERNAME + ";" + DEFAULT_PASSWORD;
            String foundCredentials = fileManager.findDataById(CREDENTIALS_FILE, DEFAULT_USERNAME);

            if (foundCredentials == null) {
                // Si las credenciales predeterminadas no están presentes, añadirlas
                fileManager.writeToFile(CREDENTIALS_FILE, credentials);
                System.out.println("Credenciales predeterminadas añadidas.");
            }
        } catch (Exception e) {
            System.out.println("Error al verificar o escribir las credenciales predeterminadas: " + e.getMessage());
        }
    }
}
