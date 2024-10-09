package org.example;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Ejercicio05grafico {
    public static void main(String[] args) {
        String title = "Introduzca la URL";
        String message = "Por favor, introduzca la URL del archivo que desea descargar:";
        String dir = JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);

        if (dir == null || dir.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se ha introducido ninguna URL.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            Path destino = Path.of(fc.getSelectedFile().toString());
            Path archivoDestino = destino.resolve("prueba2.pdf");

            try (BufferedInputStream bis = new BufferedInputStream(new URI(dir).toURL().openStream())) {
                Files.copy(bis, archivoDestino, StandardCopyOption.REPLACE_EXISTING);
                JOptionPane.showMessageDialog(null, "Archivo descargado correctamente en: " + archivoDestino);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al descargar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
