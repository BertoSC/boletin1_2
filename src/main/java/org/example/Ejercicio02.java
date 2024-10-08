package org.example;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio02 {
    public static void main(String[] args) throws IOException {
        Path dir = Path.of("C:\\Users\\VSPC-BLACKFRIDAY\\desktop\\AD\\directorio");
        Path arch = Path.of("C:\\Users\\VSPC-BLACKFRIDAY\\desktop\\AD\\directorio\\archivo.txt");
        try {
            Files.createDirectory(dir);
            System.out.println("Directorio creado en: " + dir.toAbsolutePath());
            Files.createFile(arch);
            System.out.println("Archivo creado en:" +arch.toAbsolutePath());
        } catch (FileAlreadyExistsException e) {
            System.out.println("El directorio ya existe: " + dir.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear el directorio.");
            e.printStackTrace();
        }
    }
}


