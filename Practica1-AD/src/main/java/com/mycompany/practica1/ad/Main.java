/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1.ad;

import java.io.File;

/**
 *
 * @author Dankrani
 */
public class Main {

    public static void main(String[] args) {
        AccesoDOM a = new AccesoDOM();
        AccesoXMLDOM b = new AccesoXMLDOM();
        File f = new File("books.xml");
        a.abrirXMLaDOM(f);
        b.recorreYMuestraDOM();
        
    }
}
