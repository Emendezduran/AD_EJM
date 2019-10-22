package ej11_Aleatorio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import ej07_ProductStream.Product;

public class Main10 {
    
    public static void main(String[] args) throws IOException {
    
        String[] cod = {"p1", "p2", "p3"};
        String[] desc = {"parafusos", "cravos", "tachas"};
        Integer[] prezo = {3, 4, 5};
        RandomAccessFile raf = null;
        Product p1 = new Product();
        
        File txt = new File("C:\\Users\\Emili\\Desktop\\DanielCastelao\\AD\\EjerciciosAD\\texto11.txt");
        
        
        
        try {
            raf = new RandomAccessFile(txt,"rw");
            for (int i = 0; i < 3; i++) {
                raf.writeChars(String.format("%" + 3 + "s", cod[i]));
                raf.writeChars(String.format("%" + 10 + "s", desc[i]));
                raf.writeInt(prezo[i]);
            }
            raf.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main10.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            raf = new RandomAccessFile(txt,"rw");
            
            String codigo = "";
            String descripcion = "";
            
            raf.seek(60);
            for (int i = 0; i < 3; i++) {
               codigo = codigo + raf.readChar();                
            }
            for (int i = 0; i < 10; i++) {
               descripcion = descripcion + raf.readChar();                
            }
            int precio = raf.readInt();
            
            p1.setCodigo(codigo.trim());
            p1.setDescripcion(descripcion.trim());
            p1.setPrecio(precio);
            
            raf.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main10.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(p1.toString());
    }
}
