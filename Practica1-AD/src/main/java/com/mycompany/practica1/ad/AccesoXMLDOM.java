/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1.ad;

import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Dankrani
 */
public class AccesoXMLDOM {

    Document doc;

    public void recorreYMuestraDOM() {
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
                            datos[contador] = ntemp.getTextContent();
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

    public int insertarLibroEnDOM(String titulo, String autor, String fecha) {
        try {
            System.out.println("Añadir libro al árbol DOM:" + titulo + ";" + autor + ";" + fecha);

            //crea los nodos=>los añade al padre desde las hojas a la raíz
            //CREATE TITULO con el texto en medio
            Node ntitulo = doc.createElement("Titulo");//crea etiquetas <Titulo>...</Titulo>
            Node ntitulo_text = doc.createTextNode(titulo);//crea el nodo texto para el Titulo
            ntitulo.appendChild(ntitulo_text);//añade el titulo a las etiquetas=><Titulo>titulo</Titulo>

            //Node nautor=doc.createElement("Autor").appendChild(doc.createTextNode(autor));//one line doesn't work
            //CREA AUTOR
            Node nautor = doc.createElement("Autor");
            Node nautor_text = doc.createTextNode(autor);
            nautor.appendChild(nautor_text);

            //CREA LIBRO, con atributo y nodos Título y Autor 
            Node nLibro = doc.createElement("Libro");
            ((Element) nLibro).setAttribute("publicado", fecha);
            nLibro.appendChild(ntitulo);
            nLibro.appendChild(nautor);
            //APPEND LIBRO TO THE ROOT

            nLibro.appendChild(doc.createTextNode("\n"));//para insertar saltos de línea

            Node raiz = doc.getFirstChild();//tb. doc.getChildNodes().item(0)
            raiz.appendChild(nLibro);
            System.out.println("Libro insertado en DOM.");
            return 0;

        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }

    public int deleteNode(String tit) {
        System.out.println("Buscando el Libro " + tit + " para borrarlo");
        try {
            //Node root=doc.getFirstChild();
            Node raiz = doc.getDocumentElement();
            NodeList nl1 = doc.getElementsByTagName("Titulo");
            Node n1;
            for (int i = 0; i < nl1.getLength(); i++) {
                n1 = nl1.item(i);
                if (n1.getNodeType() == Node.ELEMENT_NODE) {//redundante por getElementsByTagName,
                                                            //no lo es si buscamos getChildNodes()
                    if (n1.getChildNodes().item(0).getNodeValue().equals(tit)) {
                        System.out.println("Borrando el nodo <Libro> con título " + tit);
                        
                        //n1.getParentNode().removeChild(n1); //borra <Titulo> tit </Titulo>, pero deja Libro y Autor
                        n1.getParentNode().getParentNode().removeChild(n1.getParentNode());
                    }

                }
            }
            System.out.println("Nodo borrado");
            //Guardar el arbol DOM en un nuevo archivo para mantener nuestro archivo original
            //guardarDOMcomoArchivo("LibrosBorrados.xml");

            return 0;
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            return -1;
        }
    }

}
