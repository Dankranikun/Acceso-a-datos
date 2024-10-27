/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenpractico1.dom.sax;

import java.io.FileWriter;
import java.io.IOException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

/**
 *
 * @author Dankrani
 */
public class EditarXML {

    public void EditarXML() throws IOException {
        try {
            FileWriter escritor = new FileWriter("proyectos2.xml");

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformador = TransformerFactory.newInstance().newTransformer();
            
//            transformador.setOutputProperty(OutputKeys.INDENT,"yes");
//            transformador.transform(src, (java.xml.transform.Result) srt);
            
        } catch (Exception e) {
        }
    }
}
