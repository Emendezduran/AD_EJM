package ej03_CopyBytesImaxe;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CopyBystesImagen {

    public static void main(String[] args) {

        File img1 = new File("/home/oracle/Desktop/compartido/CopyBystesImagen/foto.jpg");
        File img2 = new File("/home/oracle/Desktop/compartido/CopyBystesImagen/foto2.jpg");
        BufferedInputStream read = null;
        BufferedOutputStream write = null;
        boolean append = false;
        
        for (int i = 0; i < 2; i++) {
        if ( i == 1){
        append = true;    
        }
        try {
            img2.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(CopyBystesImagen.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            read = new BufferedInputStream (new FileInputStream(img1));
            write = new BufferedOutputStream(new FileOutputStream(img2, append));
            while (read.available() > 0) {
                write.write(read.read());
            }
        } catch (IOException ex) {
            Logger.getLogger(CopyBystesImagen.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                read.close();
                write.close();
            } catch (IOException ex) {
                Logger.getLogger(CopyBystesImagen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
        }    
    }
    
}
