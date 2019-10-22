package ej07_ProductStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductsStream {

    public static void main(String[] args) {

        File txt = new File("/home/oracle/Desktop/texto7.txt");
        DataInputStream read = null;
        DataOutputStream write = null;

        Product po1 = new Product("cod1", "parafusos", 3);
        Product po2 = new Product("cod2", "cravos", 4);
        Product po3 = new Product();

        try {
            write = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(txt)));
            write.writeUTF(po1.getCodigo());
            write.writeUTF(po1.getDescripcion());
            write.writeInt(po1.getPrecio());
            write.writeUTF(po2.getCodigo());
            write.writeUTF(po2.getDescripcion());
            write.writeInt(po2.getPrecio());
            write.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductsStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductsStream.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            read = new DataInputStream(new BufferedInputStream(new FileInputStream(txt)));
            po3.setCodigo(read.readUTF());
            po3.setDescripcion(read.readUTF());
            po3.setPrecio(read.readInt());

            System.out.println(po3.toString());

            po3.setCodigo(read.readUTF());
            po3.setDescripcion(read.readUTF());
            po3.setPrecio(read.readInt());
            System.out.println(po3.toString());

            read.close();
        } catch (Exception ex) {
            ex.getMessage();
        }

    }

}
