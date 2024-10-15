/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1.ad;

import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Dankrani
 */
public class AccesoXMLDOM {
    Document doc;
    
    public void recorreYMuestraDOM(){
        String[] datos = new String[6];
        Node nodo = null;
        Node root = doc.getFirstChild();
        NodeList nodeList = root.getChildNodes();
        //Recorrer el árbol DOM. El 1º nivel de nodos hijos del raíz
        for (int i = 0; i < nodeList.getLength(); i++) {
        //  Node toma el valor de los hijos de raíz
            nodo = nodeList.item(i);
        //  Miramos todos los nodos de tipo element
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Node ntemp = null;
                int contador = 1;
            //  Sacamos el valor del atributo publicado
                datos[0] = nodo.getAttributes().item(0).getNodeValue();
            //  Sacamos los valores de los hijos de nodo
                NodeList nl2 = nodo.getChildNodes();//Obtener lista de hijos
                for (int j = 0; j < nl2.getLength(); j++) {
                    ntemp = nl2.item(j);
                    if (ntemp.getNodeType() == Node.ELEMENT_NODE) {
                        if (ntemp.getNodeType() == Node.ELEMENT_NODE) {
                            datos[contador]= ntemp.getTextContent();
                            contador++;
                        }
                    }
                    for (int k = 0; k < datos.length; k++) {
                        System.out.print(datos[k] + "--");
                        
                    }
                }
                
            }
        }
    }
}
