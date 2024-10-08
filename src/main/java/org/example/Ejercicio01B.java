package org.example;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Ejercicio01B {
    public static void main(String[] args) {
        Object[] opciones = {"Copiar", "Mover"};
        int opc = JOptionPane.showOptionDialog(null, "Selecciona la operación a realizar",
                "GESTIÓN DE ARCHIVOS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        // Abrir el diálogo para seleccionar archivo
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            Path archivoSeleccionado = fc.getSelectedFile().toPath();
            if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                Path destinoCarpeta = fc.getSelectedFile().toPath();

                try {
                    if (opc == 0) {
                        Files.copy(archivoSeleccionado, destinoCarpeta, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("ARCHIVO COPIADO SATISFACTORIAMENTE a " + destinoCarpeta);

                    } else if (opc == 1) {
                        Path destino = destinoCarpeta.resolve(archivoSeleccionado.getFileName());
                        Files.move(archivoSeleccionado, destino, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("ARCHIVO MOVIDO SATISFACTORIAMENTE a " + destino);
                    }

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error durante la operación: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }
}
