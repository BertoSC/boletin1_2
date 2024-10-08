package org.example;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Ejercicio05 {
    public static void main(String[] args) throws URISyntaxException, IOException {
       String dir = "https://mestre.iessanclemente.net/pluginfile.php/28480/mod_assign/introattachment/0/UD1%20-%20Estrutura%20web%20b%C3%A1sica%20v2.pdf?forcedownload=1";
       BufferedInputStream bis = new BufferedInputStream(new URI(dir).toURL().openStream());
       Path destino = Path.of("C:\\Users\\VSPC-BLACKFRIDAY\\Desktop\\AD");
       Files.copy(bis, destino.resolve("bajadodeinternet.pdf"), StandardCopyOption.REPLACE_EXISTING);
       Path archivo = Path.of("C:\\Users\\VSPC-BLACKFRIDAY\\Desktop\\AD\\bajadodeinternet.pdf");
       BufferedReader br= Files.newBufferedReader(archivo);
       String linea;
       while ((linea=br.readLine())!=null){
           System.out.println(linea);
       }

    }
}
