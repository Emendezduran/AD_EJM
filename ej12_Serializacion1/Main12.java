package ej12_Serializacion1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main12 {
    
    public static void main(String[] args) {
               
        ObjectOutputStream write = null;
        ObjectInputStream read = null;        
        
        File txt = new File("C:\\Users\\Emili\\Desktop\\DanielCastelao\\AD\\EjerciciosAD\\texto12.txt");
        
        Mclase m1 = new Mclase("ola",-7,2.7E10);
        
        try {
        write = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(txt)));
        write.writeObject(m1);
        write.close();
        } catch (IOException ex) {   
        }
        
        try {
        read = new ObjectInputStream(new BufferedInputStream(new FileInputStream(txt)));
        Mclase m2 = (Mclase)read.readObject();
        System.out.println(m2.toString());
        read.close();
        } catch (IOException | ClassNotFoundException ex) {   
        }   
    }  
}
