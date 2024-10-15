/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ad1.abrirxmlcondom;

/**
 *
 * @author Dankrani
 */
import java.io.File;

public class UsaAccesoDOM {

    public static void main(String[] args) {
        AccesoDOM a = new AccesoDOM();
        File f = new File("Libros.xml");//necesitamos Libros.xml en la ruta correcta
        a.abriXMLaDOM(f);
    }
}