/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.practica1.ad;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
/**
 *
 * @author Dankrani
 */
public class AccesoDOM {

    Document doc;

    public int abrirXMLaDOM(File f) {
        try {
            System.out.println("Abriendo XML y generando DOM.");
            //Creamos nuevo objeto DocumentBuilder al que apunta la variable factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Ignorar comentarios y espacios blancos
            factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(true);
            //DocumentBuilder tiene el método parse que es el que genera DOM en memoria
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Se rompe aquí creo
            doc = builder.parse(f);
            //Ahora doc apunta al árbol DOM y podemos recorrerlo
            System.out.println("DOM creado.");

            return 0; //Si funciona
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1; //Si no funciona
    }

    public int guardarDOMcomoArchivo(String ruta) {
        int retorno = -1; //Si no se guarda, devuelve error
        if (ruta != null) {//Si el String es nulo, no hago nada
            File archivoDestino = new File(ruta);
            try {
                //  Si file no es directorio 
                if (!archivoDestino.isDirectory()
                        && //o no existe, creo uno nuevo, si existe, sobreescribo    ) 
                        (archivoDestino.createNewFile()) || archivoDestino.canWrite()) {
                    try {
                        //  Definimos el origen
                        Source src = new DOMSource(doc);
                        //  Definimos el resultado
                        StreamResult srt = new StreamResult(new File(ruta));
                        Transformer transformador = TransformerFactory.newInstance().newTransformer();

                        //  Opción para identar el archivo
                        transformador.setOutputProperty(OutputKeys.INDENT, "yes");
                        retorno = 0; //Si  llego aquí, fue todo bien
                        System.out.println("Archivo guardado con éxito.");
                    } catch (TransformerConfigurationException ex) {
                        System.out.println(ex);
                    } catch (TransformerException ex) {
                        System.out.println(ex);
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return retorno;
    }
    
    
}
