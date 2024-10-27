/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.examen1nicoayuda;

import java.io.FileInputStream;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author Dankrani
 */
import javax.xml.stream.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ParseXMLStAX {

    public static List<Proyecto> proyectos = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        parseXML("proyectos.xml");  // Parsear el XML

        // Mostrar todos los proyectos después de parsear
        for (Proyecto proyecto : proyectos) {
            System.out.println(proyecto);
        }

        // Invocar el menú para operaciones CRUD
        MenuXML.menu();  // Llamar al menú para operaciones de inserción, edición y borrado
    }

    public static void parseXML(String fileName) throws Exception {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        FileInputStream file = new FileInputStream(fileName);
        XMLStreamReader reader = factory.createXMLStreamReader(file);

        Proyecto proyecto = null;
        String currentElement = "";

        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {
                case XMLStreamReader.START_ELEMENT:
                    currentElement = reader.getLocalName();
                    if ("proyecto".equals(currentElement)) {
                        proyecto = new Proyecto("", "", "", "", "", "", "", "");
                    }
                    break;

                case XMLStreamReader.CHARACTERS:
                    if (proyecto != null && !reader.isWhiteSpace()) {
                        switch (currentElement) {
                            case "nombre":
                                proyecto.setNombre(reader.getText());
                                break;
                            case "equipo":
                                proyecto.setEquipo(reader.getText());
                                break;
                            case "lider_proyecto":
                                proyecto.setLiderProyecto(reader.getText());
                                break;
                            case "fecha_inicio":
                                proyecto.setFechaInicio(reader.getText());
                                break;
                            case "fecha_fin":
                                proyecto.setFechaFin(reader.getText());
                                break;
                            case "tecnologias":
                                proyecto.setTecnologias(reader.getText());
                                break;
                            case "estado":
                                proyecto.setEstado(reader.getText());
                                break;
                            case "presupuesto":
                                proyecto.setPresupuesto(reader.getText());
                                break;
                        }
                    }
                    break;

                case XMLStreamReader.END_ELEMENT:
                    if ("proyecto".equals(reader.getLocalName()) && proyecto != null) {
                        proyectos.add(proyecto);
                    }
                    break;
            }
        }
        reader.close();
    }

    public static void escribirXML(String fileName) throws Exception {
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = outputFactory.createXMLStreamWriter(new FileOutputStream(fileName), "UTF-8");

        writer.writeStartDocument("UTF-8", "1.0");
        writer.writeStartElement("coleccion");

        for (Proyecto proyecto : proyectos) {
            writer.writeStartElement("proyecto");

            writer.writeStartElement("nombre");
            writer.writeCharacters(proyecto.getNombre());
            writer.writeEndElement();

            writer.writeStartElement("equipo");
            writer.writeCharacters(proyecto.getEquipo());
            writer.writeEndElement();

            writer.writeStartElement("lider_proyecto");
            writer.writeCharacters(proyecto.getLiderProyecto());
            writer.writeEndElement();

            writer.writeStartElement("fecha_inicio");
            writer.writeCharacters(proyecto.getFechaInicio());
            writer.writeEndElement();

            writer.writeStartElement("fecha_fin");
            writer.writeCharacters(proyecto.getFechaFin());
            writer.writeEndElement();

            writer.writeStartElement("tecnologias");
            writer.writeCharacters(proyecto.getTecnologias());
            writer.writeEndElement();

            writer.writeStartElement("estado");
            writer.writeCharacters(proyecto.getEstado());
            writer.writeEndElement();

            writer.writeStartElement("presupuesto");
            writer.writeCharacters(proyecto.getPresupuesto());
            writer.writeEndElement();

            writer.writeEndElement(); // Cierra proyecto
        }

        writer.writeEndElement(); // Cierra coleccion
        writer.writeEndDocument();

        writer.flush();
        writer.close();
    }
}
