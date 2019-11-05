/*
   Exercicio 17
XMLreader
 ler dende o ficheiro products.xml que creaches no exercicio XMLwriter os datos que almacenache nel
  e crear un Arraylist de obxectos product  imprimindo as variables de ditos    obxectos dende o Arraylist
 */
package ej17_XMLreader;

import ej13_Serializacion2.Producto;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author oracle
 */
public class XMLreader {
    
       static File xml = new File("/home/oracle/NetBeansProjects/AD_Ejercicios/AD_EJM/ficheiros/texto16.xml");

    private static ArrayList<Producto> getProducto() {
        ArrayList<Producto> productos = new ArrayList<>();
        XMLStreamReader xmlSR = null;
        try {
            xmlSR = XMLInputFactory.newInstance().createXMLStreamReader(new FileReader(xml));
            Producto producto = null;
            while (xmlSR.hasNext()) {
                if (xmlSR.getEventType() == XMLStreamConstants.START_ELEMENT) {
                    if (xmlSR.getLocalName() == "producto") {
                        producto = new Producto();     
                        producto.setCodigo(xmlSR.getAttributeValue(0));
                        productos.add(producto);
                        
                    } else if (xmlSR.getLocalName() == "descripcion") {
                        producto.setDescripcion(xmlSR.getElementText());
                    } else if (xmlSR.getLocalName() == "precio") {
                        producto.setPrecio(Double.parseDouble(xmlSR.getElementText()));
                        }
                    }
                    xmlSR.next();
                }
                  
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();

        } catch (XMLStreamException ex) {
            ex.printStackTrace();
        } finally {
            try {
                xmlSR.close();
            } catch (XMLStreamException ex) {
                ex.printStackTrace();
            }
        }
        return productos;
    }
    
    public static void main(String[] args) {

        ArrayList<Producto> productos = getProducto();
        
        for (int i = 0; i < productos.size(); i++) {
            System.out.println(productos.get(i).toString());
        }
        
    }
    
}
