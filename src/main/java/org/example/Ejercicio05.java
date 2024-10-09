package org.example;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.MalformedInputException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Ejercicio05 {
    public static void main(String[] args) throws URISyntaxException, IOException, MalformedInputException {
       String dir = "https://meteo-estaticos.xunta.gal/datosred/infoweb/caire/informes/ESTUDIO/GL/FC_2023.pdf";
       BufferedInputStream bis = new BufferedInputStream(new URI(dir).toURL().openStream());
       Path destino = Path.of("C:\\Users\\VSPC-BLACKFRIDAY\\Desktop\\AD");
       Files.copy(bis, destino.resolve("prueba.pdf"), StandardCopyOption.REPLACE_EXISTING);
       Path archivo = Path.of("C:\\Users\\VSPC-BLACKFRIDAY\\Desktop\\AD\\prueba.pdf");

        try (BufferedInputStream b = new BufferedInputStream(Files.newInputStream(archivo))) {
               System.out.println("Archivo abierto correctamente para lectura.");
               System.out.println("Tamaño del archivo: " + Files.size(archivo) + " bytes.");
        }
     catch (Exception e) {
        e.printStackTrace();
    }


    }
}
