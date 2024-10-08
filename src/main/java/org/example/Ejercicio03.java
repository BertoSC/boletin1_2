package org.example;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;

public class Ejercicio03 {
    public static void main(String[] args) {
        Path dir = Path.of("C:\\Users\\a23albertogc\\Desktop\\AD\\BOLETIN1_2\\src\\main\\java\\org\\example");
        try {
            Stream<Path> s = Files.list(dir);
            //debería usarse .isRegularFile
            s.filter(
                    f->f.getFileName()   // o is.RegularFile?
                            .toString().endsWith(".java"))
                            .forEach(f->System.out.println(f.getFileName()));

        } catch (IOException e) {
            System.out.println("ERROR EN LA OPERACIÓN");;
        }

        File arch = new File("C:\\Users\\a23albertogc\\Desktop\\AD\\BOLETIN1_2\\src\\main\\java\\org\\example");
        Stream<String> s= Arrays.stream(arch.list());
        s.filter(f->f.contains(".java")).forEach(f-> System.out.println(f));



    }
}
