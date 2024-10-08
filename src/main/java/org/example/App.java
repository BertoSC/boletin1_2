package org.example;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a la aplicación de gestión de archivos y directorios");
        System.out.println();
        System.out.println("1. Crear un directorio");
        System.out.println("2. Listar archivos y subdirectorios");
        System.out.println("3. Eliminar archivo o directorio");
        System.out.println("4. Mover o renombrar un archivo o directorio");
        System.out.println("5. Salir del programa");
        System.out.println();
        System.out.println("Seleccione una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:
                crearDirectorio();
                break;
            case 2:
                listar();
                break;
            case 3:
                eliminar();
                break;
            case 4:
                moverAr();
                break;
            case 5:
                System.out.println("Gracias por usar la aplicación");
                break;
            default:
                System.out.println("Opción inválida o ruta inexistente");
        }

    }

    public static void crearDirectorio() {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            if (file.mkdir()) {
                System.out.println("Se ha creado el directorio " + file.getName());
            } else {
                System.out.println("No se ha podido crear el directorio");
            }

        } else {
            System.out.println("Se ha cancelado la operacion");
        }

    }

    public static void listar() {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            if (file.isDirectory()) {
                System.out.println("Listando archivos y subdirectorios de " + file.getName());
                listarSub(file, "");
            } else {
                System.out.println("No es un directorio");
            }
        
        } else {
            System.out.println("Se ha cancelado la operacion");
        }

    }

    public static void listarSub(File fil, String space) {
        File[] files = fil.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println(space + file.getName());
                listarSub(file, space + " ");
            } else {
                System.out.println(space + file.getName());
            }
        }

    }

    public static void eliminar() {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int returnVal = fc.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            if (file.isDirectory()){
                System.out.println("Eliminando archivos y subdirectorios de " + file.getName());
                borrarAr(file);
            } else {
                if (file.delete()) {
                    System.out.println("Se ha eliminado el archivo " + file.getName());
                } else {
                    System.out.println("No se ha podido eliminar el archivo");
                }
            }
        }    

    }

    public static void borrarAr(File fil) {
        File [] files= fil.listFiles();
        for (File f: files){
            if (f.isDirectory()){
                borrarAr(f);
            } else {
                if (f.delete()){
                    System.out.println("Se ha eliminado el archivo " + f.getName());
                } else {
                    System.out.println("No se ha podido eliminar el archivo");
                }
            }
        }
        if (fil.delete()) {
            System.out.println("Se ha eliminado el directorio " + fil.getName());
        } else {
            System.out.println("No se ha podido eliminar el directorio " + fil.getName());
        }

    }

    public static void moverAr() {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int returnVal = fc.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            String file = fc.getSelectedFile().getAbsolutePath();
            Path archOr= Paths.get(file);
            String nuevo = JOptionPane.showInputDialog("Ingresa la nueva ruta o nombre del archivo o directorio");
            Path nuevoAr = Paths.get(nuevo);
            try {
            // Mover el archivo a la nueva ubicación
            Files.move(archOr, nuevoAr, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Archivo movido exitosamente a " + nuevoAr.toString());
        } catch (IOException e) {
            System.out.println("Error al mover el archivo: " + e.getMessage());
        }
           
        } else {
            System.out.println("Se ha cancelado la operacion");
        }

    }

}