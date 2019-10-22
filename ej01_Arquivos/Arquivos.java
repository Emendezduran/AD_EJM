package ej01_Arquivos;

import java.io.File;
import java.io.IOException;

public class Arquivos {

    public static void main(String[] args) {

        //1
        System.out.println("1");

        File arquivosdir = new File("/home/oracle/NetBeansProjects/Arquivos/arquivosdir");
        if (arquivosdir.exists()) {
            System.out.println(arquivosdir.getAbsolutePath() + " Directorio Existente");
        } else {
            arquivosdir.mkdir();
            System.out.println(arquivosdir.getAbsolutePath() + " Directorio Creado");
        }

        //2
        System.out.println("2");

        File products1 = null;

        try {
            products1 = new File("/home/oracle/NetBeansProjects/Arquivos/arquivosdir/products1.txt");
            if (!products1.exists()) {
                products1.createNewFile();
                System.out.println(arquivosdir.getAbsolutePath() + " Fichero Creado");
            } else {
                System.out.println(products1.getAbsolutePath() + " Fichero Existente");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        //3
        System.out.println("3");

        if (arquivosdir.exists()) {
            System.out.println(arquivosdir.getAbsolutePath() + " Ruta verificada");
        } else {
            System.out.println("Error en la ruta directorio");
        }
        if (products1.exists()) {
            System.out.println(products1.getAbsolutePath() + " Ruta verificada");
        } else {
            System.out.println("Error en la ruta fichero");
        }
        
        //4
        System.out.println("4");

            File subdir = new File("/home/oracle/NetBeansProjects/Arquivos/arquivosdir/subdir");
            if (subdir.exists()) {
                System.out.println(subdir.getAbsolutePath() + " Directorio Existente");
            } else {
                subdir.mkdir();
                System.out.println(subdir.getAbsolutePath() + " Directorio Creado");
            }

            File products2 = null;

            try {
                products2 = new File("/home/oracle/NetBeansProjects/Arquivos/arquivosdir/subdir/products2.txt");
                if (!products2.exists()) {
                    products2.createNewFile();
                    System.out.println(products2.getAbsolutePath() + " Fichero Creado");
                } else {
                    System.out.println(products2.getAbsolutePath() + " Fichero Existente");
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            
            //5
            System.out.println("5");
            
            File[] ficheros = arquivosdir.listFiles();
            System.out.println(ficheros.length);
                for (int x=0;x<ficheros.length;x++){
                System.out.println(ficheros[x].getName());
            }      
            
            //6
            System.out.println("6");
            
            System.out.println(arquivosdir.getAbsolutePath() + " Fue el primer directorio creado");
            
            //7
            System.out.println("7");
            System.out.println("Nombre: " + products1.getName());
            System.out.println("Ruta: " + products1.getAbsolutePath());
            System.out.println("Escritura: " + products1.canWrite());
            System.out.println("Lectura: " + products1.canRead());
            System.out.println("Longitud: " + products1.length());
            
            //8
            System.out.println("8");
            System.out.println("Transformado a solo lectura");
            products1.setReadOnly();
            
            //9
            System.out.println("9");
            System.out.println("Recuperando permiso de escritura");
            products1.setWritable(true);
            
            //10
            System.out.println("10");
            System.out.println("Borrando archivo products1");
            products1.delete();
            
            //11
            System.out.println("11");
            System.out.println("Borrado Completo");
            arquivosdir.getAbsolutePath();
            products2.delete();
            subdir.delete();
            System.out.println("ruta:" + arquivosdir.getPath());
            if(arquivosdir.delete()){
             System.out.println("borrado correctamente");
            }else {
                System.out.println("borrado fallo");
            }
            
            
                
    }
}
    

