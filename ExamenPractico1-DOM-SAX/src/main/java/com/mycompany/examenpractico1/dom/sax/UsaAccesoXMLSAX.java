/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenpractico1.dom.sax;

/**
 *
 * @author Dankrani
 */
import java.io.File;
import java.util.Scanner;

public class UsaAccesoXMLSAX {

    public static void main(String[] args) {
        int menu = 0;
        Scanner sc = new Scanner(System.in);
        File f = new File("proyectos.xml");
        AccesoXMLSAX a = new AccesoXMLSAX();
        a.parsearXMLconProyectosSAXhandler(f);

        do {
            System.out.println("MENÚ:");
            System.out.println("-------------------------");
            System.out.println("1.-Insertar\n2.-Editar\n3.-Borra");
            System.out.println("Elige: ");
            menu = sc.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("Entrado en caso1");
                    /*TODO*/
                    break;
                case 2:
                    System.out.println("Entrado en caso2");
                    /*TODO*/
                    break;
                case 3:
                    System.out.println("Entrado en caso3");
                    /*TODO*/
                    break;
                default:
                    System.out.println("Elige un número válido");
//                    throw new AssertionError();
            }
        } while (menu >= 4 && menu <= 0);

    }

}
