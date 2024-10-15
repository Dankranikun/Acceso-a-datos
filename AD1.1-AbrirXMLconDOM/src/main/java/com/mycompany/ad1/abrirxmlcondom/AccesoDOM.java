/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ad1.abrirxmlcondom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import java.io.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class AccesoDOM {

    Document doc;

    public int abriXMLaDOM(File f) {
        try {
            System.out.println("Abriendo archivo XML file y generando DOM ...");
            //creamos nuevo objeto DocumentBuilder al que apunta la variable factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //ignorar comentarios y espacios blancos
            factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(true);
            //DocumentBuilder tiene el método parse que es el que genera DOM en memoria
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(f);
            // ahora doc apunta al arbol DOM y podemos recorrerlo
            System.out.println("DOM creado con éxito.");
            return 0;//si el método funciona
        } catch (Exception e) {
            System.out.println(e);
            return -1;//if the method aborta en algún punto
        }

    }

    public int guardarDOMcomoArchivo(String ruta) {
        int retorno = -1; //Si no se guarda, devuelve error
        //Si el String es nulo no hago nada
        if (ruta != null) {
            File archivoDestino = new File(ruta);
            try {
                // Su el file no es un directorio y
                if (!archivoDestino.isDirectory()
                        && // o no existe y crearé uno nuevo, o existente y puedo sobreescribir encima    
                        (archivoDestino.createNewFile() || archivoDestino.canWrite())) {
                    try {
                        Source src = new DOMSource(doc); //Definimos el origen
                        StreamResult srt = new StreamResult(new File(ruta)); //Definimos resultado
                        Transformer tranformador = TransformerFactory.newInstance().newTransformer();

                        //Opción para identar el archivo
                        tranformador.setOutputProperty(OutputKeys.INDENT, "yes");
                        //Aqui es cuando escribo
                        tranformador.transform(src, (javax.xml.transform.Result) srt);
                        retorno = 0; //si llego aquí todo fue bien
                        System.out.println("Archivo creado con exito.");
                    } catch (TransformerConfigurationException ex) {
                        System.out.println(ex);
                    } catch (TransformerException ex) {
                        System.out.println(ex);
                    }

                }
            } catch (Exception e) {
            }
        }

        return 0;
    }

}//fin clase

