package ej06_PrimitiveUTFChars;

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

public class PrimitiveUTFChars {

    public static void main(String[] args) {

        File txt = new File("/home/oracle/Desktop/compartido/primitiveUTFChars/text6.txt");
        DataInputStream read = null;
        DataOutputStream write = null;
        boolean append = false;
        String cadena = "Está en casa";

        //escritura UTF, Chars, UTF
        try {
            write = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(txt)));
            write.writeUTF(cadena);
            System.out.println("writeUTF escribiu: " + cadena);
            write.writeChars(cadena);
            System.out.println("writeChars escribiu: " + cadena);
            write.writeUTF(cadena);
            System.out.println("writeUTF escribiu: " + cadena);
            write.close();
        } catch (IOException ex) {
            Logger.getLogger(PrimitiveUTFChars.class.getName()).log(Level.SEVERE, null, ex);
        }

        //lectura UTF, Chars, UTF
        try {
            read = new DataInputStream(new BufferedInputStream(new FileInputStream(txt)));
            System.out.println("lemos a primeira cadea mediante  readUTF: " + read.readUTF());
            StringBuilder salida = new StringBuilder();
            for (int j = 0; j < cadena.length(); j++) {
                salida.append(read.readChar());
            }
            System.out.println("lemos a segunda cadea mediante readChar (con bucle): " + salida);
            System.out.println("lemos a terceira cadea  mediante readUTF: " + read.readUTF());
            read.close();
        } catch (IOException ex) {
            Logger.getLogger(PrimitiveUTFChars.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
