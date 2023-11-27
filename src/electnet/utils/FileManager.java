/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electnet.utils;

/**
 *
 * @author jonat
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class FileManager {

    // Método para verificar si un ID ya existe en el archivo
    private boolean idExists(String pathname, String idToCheck) throws IOException {
        File file = new File(pathname);
        if (!file.exists()) {
            return false;
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            // Separar la línea usando ";" y verificar el primer elemento (ID)
            String[] parts = line.split(";");
            if (parts[0].equals(idToCheck)) {
                reader.close();
                return true; // ID encontrado
            }
        }
        reader.close();
        return false; // ID no encontrado
    }
    
    public String findDataById(String pathname, String idToFind) throws IOException {
        try {
            File file = new File(pathname);

            if (!file.exists()) {
                return null; // Archivo no existe
            }

            Scanner scanner = new Scanner(file);
            boolean found = false;
            while (scanner.hasNextLine() && !found) {
                String lineaActual = scanner.nextLine();

                Scanner s1 = new Scanner(lineaActual);
                s1.useDelimiter("\\s*;\\s*");

                if (s1.next().equals(idToFind)) {
                    scanner.close();
                    System.out.println("Encontrado");
                    return lineaActual; // Datos encontrados
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error");
        }

        return null; // ID no encontrado
    }
    //Metodo separador por ";"
    
    public String[] splitString(String data, String delimiter) {
        return data.split(delimiter);
    }
    
    // Método modificado para escribir en un archivo
    public void writeToFile(String pathname, String content) {
        try {
            // Obtener el ID desde el contenido
            String id = content.split(";")[0];

            // Verificar si el ID ya existe
            if (idExists(pathname, id)) {
                System.out.println("ID ya existe en el archivo.");
                return;
            }

            // Continuar con la escritura si el ID no existe
            File file = new File(pathname);
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("Archivo creado: " + file.getName());
                } else {
                    System.out.println("No se pudo crear el archivo.");
                    return;
                }
            }

            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(writer);

            bw.write(content);
            bw.newLine();
            bw.close();
            System.out.println("Operación de escritura exitosa.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
            e.printStackTrace();
        }
    }
    // Metodo para modificar 
    public void editFile(String filePath, String oldContent, String newContent) throws IOException {
        File originalFile = new File(filePath);
        File tempFile = new File(originalFile.getAbsolutePath() + ".tmp");

        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(originalFile));
            writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            // Copiando cada línea al archivo temporal, excepto la que se va a editar
            while((currentLine = reader.readLine()) != null) {
                // Si la línea no es la que queremos editar, la copiamos tal cual
                if(!currentLine.trim().equals(oldContent)) {
                    writer.write(currentLine + System.lineSeparator());
                } else {
                    // Si es la línea que queremos editar, escribimos el nuevo contenido
                    writer.write(newContent + System.lineSeparator());
                }
            }

            // Cerramos los recursos
            writer.close();
            reader.close();

            // Eliminamos el archivo original y renombramos el temporal
            if (!originalFile.delete()) {
                System.out.println("No se pudo eliminar el archivo original");
            }
            if (!tempFile.renameTo(originalFile)) {
                System.out.println("No se pudo renombrar el archivo temporal");
            }

        } catch (IOException e) {
            // Manejo de excepciones
            e.printStackTrace();
        } finally {
            // Asegurándonos de cerrar los recursos
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    // Método para leer un archivo
    public void readFile(String pathname) {
        try {
            File file = new File(pathname);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            e.printStackTrace();
        }
    }
}
