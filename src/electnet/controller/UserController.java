
package electnet.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import electnet.model.User;

public class UserController {
   public void saveUser(User user) {
        String filePath = "users.txt"; // Ruta y nombre del archivo de texto
        File file = new File(filePath);

        try {
            // Verificar si el archivo existe, crearlo si no existe
            if (!file.exists()) {
                file.createNewFile();
            }

            // FileWriter y BufferedWriter para escribir en el archivo
            FileWriter fileWriter = new FileWriter(file, true); // true para añadir al archivo en lugar de sobrescribir
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Escribir los detalles del usuario en el archivo
            bufferedWriter.write(userToString(user));
            bufferedWriter.newLine();

            // Cerrar el BufferedWriter
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();// Manejo de excepciones
        }
    }
}
