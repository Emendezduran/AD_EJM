package ej13_Serializacion2;

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

        //File txt = new File("C:\\Users\\Emili\\Documents\\DanielCastelao\\AD\\Ejercicios\\ficheiros\\texto13.txt");
        File txt = new File("/home/oracle/NetBeansProjects/AD_Ejercicios/AD_EJM/ficheiros/texto13.txt");

        ObjectOutputStream write;
        ObjectInputStream read;

        String[] cod = {"p1", "p2", "p3"};
        String[] desc = {"parafusos", "cravos ", "tachas"};
        Double[] prezo = {3.0, 4.0, 5.0};

        ArrayList<Producto> listaProductos = new ArrayList<>();

        for (int i = 0; i < cod.length; i++) {
            listaProductos.add(new Producto(cod[i], desc[i], prezo[i]));
            System.out.println("insertado");
        }

        try {
            write = new ObjectOutputStream(new FileOutputStream(txt));
            for (Producto producto : listaProductos) {
                write.writeObject(producto);
            }
            write.writeObject(null);
            write.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        ArrayList<Producto> productosLeidos = new ArrayList<>();

        try {
            read = new ObjectInputStream(new BufferedInputStream(new FileInputStream(txt)));
            while (true) {
                Object obj = read.readObject();
                if (obj == null) {
                    break;
                }
                productosLeidos.add((Producto) obj);
            }
            read.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < cod.length; i++) {
            System.out.println(productosLeidos.get(i).toString());
        }

    }
}
