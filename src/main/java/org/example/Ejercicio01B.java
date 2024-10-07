package org.example;
import javax.swing.*;

public class Ejercicio01B {
    public static void main(String[] args) {
        Object[] opciones = {"Copiar", "Mover"};
        int opc = JOptionPane.showOptionDialog(null, "Selecciona la operación a realizar", "GESTIÓN DE ARCHIVOS",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, opciones, opciones[0], opciones[1]);
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {


        }

    }
}