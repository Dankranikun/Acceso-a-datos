/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ad1._xml.sax;

/**
 *
 * @author Dankrani
 */
import java.io.File;

public class UsaAccesoXMLSAX {

    public static void main(String[] args) {
        File f = new File("Libros.xml");
        AccesoXMLSAX a = new AccesoXMLSAX();
        //	a.parsearXMLconLibrosSAXhandler(f);
        a.parsearXMLconTitulosSAXhandler(f);

    }

}
