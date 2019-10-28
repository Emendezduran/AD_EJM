/*
exercicio 16
XMLwriter
ler dende o  ficheiro que creache no  exercicio Serializacion2 os obxectos que almacenaches nel
 e almacenaos en formato XML nun ficheiro denominado "products.xml"
 IMPORTANTE: debes importar o proxecto denominado serialiazion2 para usar a sua clase Product para ler os obxectos
  que almacenaches en dito exercicio  , NON debes copiar e pegar a clase Product en ningún caso.
 */
package ej16_XMLwriter;

import ej13_Serializacion2.Producto;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class XMLWriter {

    public static File txt = new File("/home/oracle/NetBeansProjects/AD_Ejercicios/AD_EJM/ficheiros/texto13.txt");

    public static void main(String[] args) throws IOException {

        ArrayList<Producto> productos = leerProductos(txt);

        for (int i = 0; i < productos.size(); i++) {
            System.out.println(productos.get(i).toString());
        }

        File xml = new File("/home/oracle/NetBeansProjects/AD_Ejercicios/AD_EJM/ficheiros/texto16.xml");

        try {
            XMLStreamWriter xmlSW = XMLOutputFactory.newInstance().createXMLStreamWriter(new FileWriter(xml));

            //VersionXML DeclaracionInicial
            xmlSW.writeStartDocument("1.0");

            //EtiquetaRaizApertura
            //<productos>
            xmlSW.writeStartElement("productos");

            for (Producto producto : productos) {

                //<producto codigo="cod">
                xmlSW.writeStartElement("producto");
                xmlSW.writeAttribute("codigo", producto.getCodigo());

                //<descripcion>
                xmlSW.writeStartElement("descripcion");
                xmlSW.writeCharacters(producto.getDescripcion());
                //</nome>
                xmlSW.writeEndElement();

                //<titulo>
                xmlSW.writeStartElement("precio");
                xmlSW.writeCharacters(Double.toString(producto.getPrecio()));
                //</titulo>
                xmlSW.writeEndElement();

                //</producto>
                xmlSW.writeEndElement();

            }

            //EtiquetaRaizCierre
            //</autores>
            xmlSW.writeEndElement();
            xmlSW.close();
        } catch (XMLStreamException ex) {
            ex.printStackTrace();
        }

    }

    public static ArrayList<Producto> leerProductos(File txt) {

        ArrayList<Producto> productosLeidos = new ArrayList<>();

        ObjectInputStream read;
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
        return productosLeidos;
    }
}
