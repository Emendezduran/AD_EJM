package ejercicio13;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main13 {

    public static void main(String[] args) {

        File txt = new File("C:\\Users\\Emili\\Documents\\DanielCastelao\\AD\\Ejercicios\\ficheiros\\texto13.txt");
        
        ObjectOutputStream write;
        ObjectInputStream read;
        
        String[] cod = {"p1", "p2", "p3"};
        String[] desc = {"parafusos", "cravos ", "tachas"};
        Double[] prezo = {3.0, 4.0, 5.0};

        Productos p1 = new Productos();
        Productos p2 = new Productos();
        Productos p3 = new Productos();
        
        ArrayList<Productos> listaProductos = new ArrayList<>();

        for (int i = 0; i < cod.length; i++) {
             listaProductos.add(new Productos(cod[i], desc[i], prezo[i]));
        }
        
        try 
        {
            write = new ObjectOutputStream(new FileOutputStream(txt)); 
            for(Productos producto : listaProductos)
            {
            write.writeObject(producto);
            }
            write.writeObject(null);
            write.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        ArrayList<Productos> productosLeidos = new ArrayList<>();
        try {
            read = new ObjectInputStream(new BufferedInputStream(new FileInputStream(txt)));
            while(true){
                Object obj = read.readObject();
                if (obj == null){
                    break;
                }
            productosLeidos.add((Productos)obj);
            }
            read.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
