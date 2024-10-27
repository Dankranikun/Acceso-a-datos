/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.examenpractico1.dom.sax;

/**
 *
 * @author Dankrani
 */
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class ProyectosSAXhandler extends DefaultHandler {

    public ProyectosSAXhandler() {
    }


@Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if (qName.equals("nombre")) {
            System.out.print("Proyecto: ");
        //Aquí uso \n en lugar de printLN porque se come líneas
        } else if (qName.equals("equipo")) {
            System.out.print("\nEquipo: ");

        } else if (qName.equals("lider_proyecto")) {
            System.out.print("\nLíder: ");

        } else if (qName.equals("fecha_inicio")) {
            System.out.print("\nFecha inicio: ");

        } else if (qName.equals("fecha_fin")) {
            System.out.print("\nFecha fin: ");

        } else if (qName.equals("tecnologias")) {
            System.out.print("\nTecnologías: ");
           
        } else if (qName.equals("estado")) {
            System.out.print("\nEstado: ");

        } else if (qName.equals("presupuesto")) {
            System.out.print("\nPresupuesto: ");

        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("Libro")) {
            System.out.println("\n-----------------------");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String car = new String(ch, start, length);
        car = car.replaceAll("\t", "");//quita todos los tabuladores
        car = car.replaceAll("\n", "");
        System.out.print(car);
    }

}
