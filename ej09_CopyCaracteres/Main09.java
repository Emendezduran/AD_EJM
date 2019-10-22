package ej09_CopyCaracteres;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Emendu
 */
public class Main09 {

    public static void main(String[] args) {

        File txt1 = new File("C:\\Users\\Emili\\Desktop\\EjerciciosAD\\texto91.txt");
        File txt2 = new File("C:\\Users\\Emili\\Desktop\\EjerciciosAD\\texto92.txt");
        FileWriter write = null;
        FileReader read = null;

        try {
            read = new FileReader(txt1);
            write = new FileWriter(txt2);
            while (read.read() != -1) {              
                write.write(read.read());
            }    
            read.close();
            write.close();
            
        } catch (Exception ex) {

        }

    }

}
