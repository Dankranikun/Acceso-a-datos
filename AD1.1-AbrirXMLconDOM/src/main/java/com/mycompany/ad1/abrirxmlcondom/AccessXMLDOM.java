/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ad1.abrirxmlcondom;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Dankrani
 */
public class AccessXMLDOM {

    Document doc;
//codigo escrito en Practica1
//añade el nuevo método

    public void recorreDOMyMuestra() {
        String[] datos = new String[3];//lo usamos para la información de cada libro
        Node nodo = null;
        Node root = doc.getFirstChild();
        NodeList nodelist = root.getChildNodes();
        //(1)Ver dibujo del árbol
        //recorrer el árbol DOM. El 1er nivel de nodos hijos del raíz
        for (int i = 0; i < nodelist.getLength(); i++) {
            nodo = nodelist.item(i);//node toma el valor de los hijos de raíz
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {//miramos nodos de tipo Element

                Node ntemp = null;
                int contador = 1;
                //sacamos el valor del atributo publicado
                datos[0] = nodo.getAttributes().item(0).getNodeValue();
                //sacamos los valores de los hijos de nodo, Titulo y Autor
                NodeList nl2 = nodo.getChildNodes();//obtenemos lista de hijos (2)
                for (int j = 0; j < nl2.getLength(); j++) {//iteramos en esa lista 
                    ntemp = nl2.item(j);
                    if (ntemp.getNodeType() == Node.ELEMENT_NODE) {
                        if (ntemp.getNodeType() == Node.ELEMENT_NODE) {
                            //para conseguir el texto de titulo y autor, se //puedo hacer con getNodeValue(), también con  //getTextContent() si es ELEMENT
                            datos[contador] = ntemp.getTextContent(); // también datos[contador]=ntemp.getChildNodes().item(0).getNodeValue();
                            contador++;
                        }
                    }
                    //el array de String datos[] tiene los valores que necesitamos

                    System.out.println(datos[0] + "--" + datos[2] + "--" + datos[1]);
                }//
            }
        }
    }
}
