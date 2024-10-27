/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenpractico1.dom.sax;

/**
 *
 * @author Dankrani
 */
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class TitulosSAXhandler extends DefaultHandler {

    private String etiqueta;

    public TitulosSAXhandler() {
        etiqueta = "";//también se puede hacer con int etiqueta 
    }

    @Override
    public void startDocument() {
        System.out.println("LISTADO DE PROYECTOS");
        System.out.println("==================");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if (qName.equals("nombre")) {
            etiqueta = "nombre";

        } else if (qName.equals("equipo")) {
            etiqueta = "equipo";

        } else if (qName.equals("lider_proyecto")) {
            etiqueta = "lider_proyecto";

        } else if (qName.equals("fecha_inicio")) {
            etiqueta = "fecha_inicio";

        } else if (qName.equals("fecha_fin")) {
            etiqueta = "fecha_fin";

        } else if (qName.equals("tecnologias")) {
            etiqueta = "tecnologias";
            
        } else if (qName.equals("estado")) {
            etiqueta = "estado";

        } else if (qName.equals("presupuesto")) {
            etiqueta = "presupuesto";

        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (etiqueta.equals("nombre")) {
            String car = new String(ch, start, length);
            car = car.replaceAll("\t", "");//quita todos los tabuladores
            car = car.replaceAll("\n", "");
            System.out.println(car);
        }
    }
}
