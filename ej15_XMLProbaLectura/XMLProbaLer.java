/*
exercicio 15
XMLproba0ler
le o documento XML que se xenerou no exercicio anterior usando os metodos apropiados
as clases a usar son moi similares:
XMLInputFactory 
XMLStreamReader

metodos da clase XMLStreamreader:

hasNext() : para preguntar se ainda quedan elementos a ler 

next(): para ler o seguinte elemento

getEventType() : retorna un enteiro que  indica o tipo de elemento. Este enteiro
 correspondese con unha constante definida por a interface XMLStreamConstants

                   START_ELEMENT
                   END_ELEMENT
                   ATTRIBUTE
                   CHARACTERS
                   COMMENT
                   SPACE
                   DTD
por exemplo para preguntar se o evento leido e un Start Element  preguntaremos por XMLStreamConstants.START_ELEMENT:

getLocalName():devolta o nome do elemento actual
getAttributeValue(posidion_do_atributo_dende_0):  devolta un string con o atributo almacenado no indice especificado
getElementText() : devolta o valor de un elemento de texto

 */
package ej15_XMLProbaLectura;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class XMLProbaLer {

    static File xml = new File("C:\\Users\\Emili\\Documents\\DanielCastelao\\AD\\Ejercicios\\ficheiros\\autores.xml");

    private static ArrayList<Autor> getAutores() {
        ArrayList<Autor> autores = new ArrayList<>();
        XMLStreamReader xmlSR = null;
        try {
            xmlSR = XMLInputFactory.newInstance().createXMLStreamReader(new FileReader(xml));
            Autor autor = null;
            while (xmlSR.hasNext()) {
                if (xmlSR.getEventType() == XMLStreamConstants.START_ELEMENT) {
                    System.out.println(xmlSR.getEventType() + " " + xmlSR.getLocalName());
                    if (xmlSR.getLocalName() == "autor") {
                        autor = new Autor();
                        autor.setCodigo(xmlSR.getAttributeValue(0));
                        autores.add(autor);
                    } else if (xmlSR.getLocalName() == "nome") {
                        autor.setNombre(xmlSR.getElementText());
                    } else if (xmlSR.getLocalName() == "titulo") {
                        if (autor.getTitulo1() == null) {
                            autor.setTitulo1(xmlSR.getElementText());
                        } else {
                            autor.setTitulo2(xmlSR.getElementText());
                        }
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
        return autores;
    }

    public static void main(String[] args) throws IOException {
        
        ArrayList<Autor> autores = getAutores();
        for (Autor autor : autores) {
            System.out.println(autor);
        }

    }

}
