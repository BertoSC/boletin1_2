package org.example;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Ejercicio01A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe la ruta que se va a comprobar");
        String ruta = sc.nextLine();
        Path p = Path.of(ruta);
        System.out.println(Files.exists(p)? "La ruta existe" : "La ruta no existe");
        System.out.println(p.isAbsolute() ? "La ruta es absoluta" : "La ruta es relativa");
    }
}
