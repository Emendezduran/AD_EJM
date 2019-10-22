package primitivewritechars;

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

public class PrimitiveWriteChars {

    /*
a cadea a escribir e : o tempo está xélido
a lonxitude desta cadea en carateres e: 19
pero cando se grabe co metodo writeChars vai a ocupar 38 bytes  posto que se usan 2 bytes por cada caracter  sempre
writeChars escribiu:  38bytes
writeChars escribiu:  38bytes
bytes totais escritos = 76
lemos a primeira cadea:  o tempo está xélido
o numero de bytes lidos e :38
bytes restantes por ler : 38
lemos a segunda cadea:  o tempo está xélido
o numero de bytes lidos e :38
bytes restantes por ler : 0
     */
    public static void main(String[] args) {

        File txt = new File("/home/oracle/Desktop/compartido/primitiveWriteChars/text4.txt");
        DataInputStream read = null;
        DataOutputStream write = null;
        String cadena = "o tempo está xélido";
        int escrito = 0;
        int disponible = 0;
        int leido = 0;
        
        
        System.out.println("a cadea a escribir e :" + cadena);
        System.out.println("a lonxitude desta cadea en carateres e :" + cadena.length());
        System.out.println("pero cando se grabe co metodo writeChars vai a ocupar 38 bytes  posto que se usan 2 bytes por cada caracter  sempre");
        
        //Verificacion de existencia y creacion del fichero
//        if (!txt.exists()) {
//            try {
//                txt.createNewFile();
//            } catch (IOException ex) {
//                Logger.getLogger(PrimitiveWriteChars.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }

        //Escritura duplicada de la cadena
        try {
            write = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(txt)));
            for (int i = 0; i < 2; i++) {
                write.writeChars(cadena);
                System.out.println("writeChars escribiu: " + (write.size() - escrito));
                escrito = write.size();
            }
        } catch (IOException ex) {
            Logger.getLogger(PrimitiveWriteChars.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                write.close();
            } catch (IOException ex) {
                Logger.getLogger(PrimitiveWriteChars.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                System.out.println("bytes totais escritos = " + write.size());
            }           
        }
        
        //Lectura
        try {
            read = new DataInputStream(new BufferedInputStream(new FileInputStream(txt)));
            disponible = read.available();
            for (int i = 0; i < 2; i++) {       
                StringBuilder salida = new StringBuilder();
                for (int j = 0; j < cadena.length(); j++) {
                    salida.append(read.readChar());
                }
                leido = disponible - read.available();
                System.out.println("Leemos la cadena " + i + " : " + salida.toString());
                System.out.println("Numero de bytes leidos: " + leido);
                disponible = read.available();
                System.out.println("Numero de bytes restantes: " + disponible);
            }
        } catch (IOException ex) {
            Logger.getLogger(PrimitiveWriteChars.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hfgffghfhf");
        } finally {
            try {
                read.close();
            } catch (IOException ex) {
                Logger.getLogger(PrimitiveWriteChars.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }

}
