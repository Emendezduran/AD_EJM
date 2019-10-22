package ej04_PrimitiveWriteUTF;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrimitiveWriteUTF1 {

    public static void main(String[] args) {

        File txt = new File("/home/oracle/Desktop/compartido/primitiveWriteUTF1/text3.txt");
        DataInputStream read = null;
        DataOutputStream write = null;
        boolean append = false;
        String cadena = "o tempo está xélido";

        for (int i = 0; i < 2; i++) {
            if (i == 1) {
                append = true;
            }
            try {
                txt.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(PrimitiveWriteUTF1.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                write = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(txt, append)));
                write.writeUTF(cadena);

            } catch (IOException ex) {
                Logger.getLogger(PrimitiveWriteUTF1.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    write.close();
                } catch (IOException ex) {
                    Logger.getLogger(PrimitiveWriteUTF1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }


            try {
                read = new DataInputStream(new BufferedInputStream(new FileInputStream(txt)));
                while(read.available() > 0){
                    System.out.println(read.readUTF());
                }
            } catch (IOException ex) {
                Logger.getLogger(PrimitiveWriteUTF1.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    read.close();
                } catch (IOException ex) {
                    Logger.getLogger(PrimitiveWriteUTF1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
    

