package ej02_FileStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CopyBytesTexto {

    public static void main(String[] args) {

        File txt1 = new File("/home/oracle/Desktop/compartido/CopyBytesTexto/texto1.txt");
        File txt2 = new File("/home/oracle/Desktop/compartido/CopyBytesTexto/texto2.txt");
        FileInputStream read = null;
        FileOutputStream write = null;

        try {
            txt2.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(CopyBytesTexto.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            read = new FileInputStream(txt1);
            write = new FileOutputStream(txt2, true);
            while (read.available() > 0) {
                write.write(read.read());
            }
        } catch (IOException ex) {
            Logger.getLogger(CopyBytesTexto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                read.close();
                write.close();
            } catch (IOException ex) {
                Logger.getLogger(CopyBytesTexto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
