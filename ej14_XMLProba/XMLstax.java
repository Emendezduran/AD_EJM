/* 
exemplo 14:
XMLproba0

informacion:
SAX (simple API for XML: usado para convertir datos a XML e viceversa)

un docuemnto XML esta composto de elementos 
todo elemento XML comeza e remata cunha etiqueta ou tag 
o tag inical e o final dun elemento teñen o mesmo nome que e elexido polo disenador do ducumento.
o contido(content) dun elemento e o que vai situado entre os tags iniciais e final do elemento
exemplo de elemento:   <titulo> blade runner </titulo>
tag inicial: <titulo>
contido: blade runner
tag final: </titulo>
o elemento de mais alto nivel ou elemento pai (parent element) e o denominado elemento raiz
un documento XML so pode conter un elemento raiz
dentro dun elemento poden atoparse mais elementos denominados elementos fillos (child elements)
o primeiro elemento dun documento XML e a declaracion que indica a version do XML que vai ser usada polo documento
un elemento pode conter un ou varios tributos , que son pares variable=valor que se utilizan normalmente para identificar certos elementos dun documento XML
exemplo de elemento con atributo:
<tenda codigo="t1">
Para escribir e ler documentos XML imos usar StAX  - Streaming API for XML 
Antes de escribir nun documento XML necesitamos crear un obxecto que implemente  a interface XMLStreamWriter
Para facer isto debemos primeiro invocar o metodo estático newInstance() da clase XMLOutputFactory par crear un obxecto XMLOutputFactory
Despois podemos xa crear un obxecto XMLStreamWriter invocando o metodo createXMLStreamWriter(FileWriter object) do obxecto XMLOutputFactory creado anteriormente
A partires dese momento xa se poden usar os metodos propios do obxecto XMLStreamWriter par escribir o documento 

Metodos da clase XMLStreamWriter:
writeStartDocument("1.0")   
   //escribe a declaracion XML con a Version especificada

writeStartElement("tenda");
 //escribe o tag de inicio de un elemento

writeAttribute("codigo","t1");
    //escribe un atributo para o lemento actual

writeCharacters("urzaiz");
    //escribe o contido do elemento 

 writer.writeEndElement();
    //escribe o tag de peche do elemento actual
   
  
exercicio:
xmlproba0
graba este documento XML co nome autores.xml dende java usando os metodos apropiados
<?xm version="1.0"?>
<autores>
    <autor codigo ="a1">
    <nome>Alexandre Dumas </nome>
    <titulo> El conde de montecristo</titulo>
    <titulo> Los miserables </titulo>
    </autor>
    <autor codigo ="a2">
    <nome>Fiodor Dostoyevski</nome>
    <titulo> El idiota</titulo>
    <titulo> Noches blancas </>
    </autor>
<autores>
*/
package ej14_XMLProba;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 *
 * @author Emendu
 */
public class XMLstax {
    
    public static void main(String[] args) throws IOException {
        
        File xml = new File("C:\\Users\\Emili\\Documents\\DanielCastelao\\AD\\Ejercicios\\ficheiros\\autores.xml");
        System.out.println(xml.getAbsolutePath());
    
        try
        {
            XMLStreamWriter xmlSW = XMLOutputFactory.newInstance().createXMLStreamWriter(new FileWriter(xml));
            
            //VersionXML DeclaracionInicial
            xmlSW.writeStartDocument("1.0");
            
            //EtiquetaRaizApertura
            //<autores>
            xmlSW.writeStartElement("autores");
            
            //1 <autor codigo="cod">
            xmlSW.writeStartElement("autor");
            xmlSW.writeAttribute("codigo", "a1");
            
                //<nome>
                xmlSW.writeStartElement("nome");
                xmlSW.writeCharacters("Alexandre Dumas");
                //</nome>
                xmlSW.writeEndElement();

                //<titulo>
                xmlSW.writeStartElement("titulo");
                xmlSW.writeCharacters("El conde de montecristo");
                //</titulo>
                xmlSW.writeEndElement();

                //<titulo>
                xmlSW.writeStartElement("titulo");
                xmlSW.writeCharacters("Los miserables");
                //</titulo>
                xmlSW.writeEndElement();
            
            //1 </autor>
            xmlSW.writeEndElement();
            
            //2 </autor codigo="cod">
            xmlSW.writeStartElement("autor");
            xmlSW.writeAttribute("codigo", "a2");
            
                //<nome>
                xmlSW.writeStartElement("nome");
                xmlSW.writeCharacters("Fiodor Dostoyevski");
                //</nome>
                xmlSW.writeEndElement();

                //<titulo>
                xmlSW.writeStartElement("titulo");
                xmlSW.writeCharacters("El idiota");
                //</titulo>
                xmlSW.writeEndElement();  

                //<titulo>
                xmlSW.writeStartElement("titulo");
                xmlSW.writeCharacters("Noches blancas");
                //</titulo>
                xmlSW.writeEndElement();

            //2 </autor>
            xmlSW.writeEndElement();
            
            //EtiquetaRaizCierre
            //</autores>
            xmlSW.writeEndElement();
            xmlSW.close();
        }catch (XMLStreamException ex) 
        {
            ex.printStackTrace();
        }
        
    }  
    
}


