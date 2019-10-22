package ej08_TextoDelimitado;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import ej07_ProductStream.Product;


/**
 *
 * @author Emendu
 */
public class Main08 {

    public static void main(String[] args) throws IOException {

        File txt = new File("C:\\Users\\Emili\\Desktop\\EjerciciosAD\\texto8.txt");
        PrintWriter write = null;
        BufferedReader read = null;

        String[] cod = {"p1", "p2", "p3"};
        String[] desc = {"parafusos", "cravos", "tachas"};
        Integer[] prezo = {3, 4, 5};

        try {
            write = new PrintWriter(new BufferedWriter(new FileWriter(txt)));
            
            write.print(cod[0]);
            write.print("\t");
            write.print(desc[0]);
            write.print("\t");
            write.println(prezo[0]);
            write.print(cod[1]);
            write.print("\t");
            write.print(desc[1]);
            write.print("\t");
            write.println(prezo[1]);
            write.print(cod[2]);
            write.print("\t");
            write.print(desc[2]);
            write.print("\t");
            write.println(prezo[2]);

            write.close();
        } catch (IOException ex) {

        }

        try {
            read = new BufferedReader(new FileReader(txt));
            
            String[] puente = read.readLine().split("\t");
            Product po1 = new Product(puente[0].toString(), puente[1].toString(), Integer.parseInt(puente[2]));
            System.out.println(po1.toString());
            puente = read.readLine().split("\t");
            Product po2 = new Product(puente[0].toString(), puente[1].toString(), Integer.parseInt(puente[2]));
            System.out.println(po2.toString());
            puente = read.readLine().split("\t");
            Product po3 = new Product(puente[0].toString(), puente[1].toString(), Integer.parseInt(puente[2]));
            System.out.println(po3.toString());
           
            read.close();
        } catch (IOException ex) {

        }

    }
}
