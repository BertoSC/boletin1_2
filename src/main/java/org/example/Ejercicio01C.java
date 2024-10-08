package org.example;
import javax.swing.*;
import java.nio.file.Path;

public class Ejercicio01C {
    public static void main(String[] args) {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
            Path archivoSeleccionado = fc.getSelectedFile().toPath();
            System.out.println(archivoSeleccionado.getFileName());
            System.out.println(archivoSeleccionado.toString().substring(archivoSeleccionado.toString().lastIndexOf(".") + 1));
            System.out.println(archivoSeleccionado.toString().lastIndexOf('\\')); // o esto o .

        }
    }
}
