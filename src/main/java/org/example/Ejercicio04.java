package org.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio04 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("INTRODUCE UNA EXTENSIÓN (por ejemplo, .java)");
        String extension = sc.nextLine();
        Path origen = Path.of("C:\\Users\\VSPC-BLACKFRIDAY\\Desktop\\EJ3\\ej3\\src");
        Path destino = Path.of("C:\\Users\\VSPC-BLACKFRIDAY\\Desktop\\AD\\boletin1_2\\src\\main\\java\\org\\example");
        try (Stream<Path> s = Files.list(origen)) {
                s.filter(f -> f.getFileName().toString().contains(extension))
                    .forEach(f -> {
                        try {
                            Files.copy(f, destino.resolve(f.getFileName()), StandardCopyOption.REPLACE_EXISTING);
                            System.out.println("ARCHIVO CREADO : " + f.getFileName());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });


        } catch (IOException e) {
            System.out.println("Ocurrió un error durante la operación.");
            e.printStackTrace();
        }
    }
}
