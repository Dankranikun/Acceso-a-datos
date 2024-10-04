/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listadodirectorio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;

/**
 *
 * @author Dankrani
 */
public class ListadoDirectorio {

    public static void main(String[] args) throws IOException {
        String ruta = "C:\\AD_test";

        if (args.length >= 1) {
            ruta = args[0];
        }

        File fich = new File(ruta);
        // Si llamé al programa con parámetros (ruta) uso esta

        File dirLogs = new File(ruta + "\\logs");
        File fileLogs = new File(ruta + "\\logs" + "\\logs.txt");

        boolean resul = dirLogs.mkdir();

        PrintStream out = new PrintStream(new FileOutputStream(fileLogs, true));
        System.setOut(out);

        if (resul) {
            System.out.println("Directorio \"Logs\" creado.");
        } else {
            System.out.println("Directorio \"logs\" no creado");
        }

        if (!fich.exists()) {
            System.out.println("No existe el directorio (" + ruta + ").");
        } else {
            //Si la ruta es un archivo
            if (fich.isFile()) {
                System.out.println(ruta + " es un fichero.");
            } // Si la ruta es una carperta
            else {
                System.out.println(ruta + " es una carpeta. Contenido: ");
                // Array de File que recorremos comprobando si es archivo o carpeta
                File[] ficheros = fich.listFiles();
                for (File f : ficheros) {
                    String textoDescr = f.isDirectory() ? "/"
                            : f.isFile() ? "_" : "?"; //Operador ternario, ¿es carpeta?
                    /*
                    //Alternativa sin operador ternario
                    String textoDescr1;
                    if (f.isDirectory()) {
                        textoDescr1 = "/";
                    } else if (f.isFile()) {
                        textoDescr1 = "_";
                    } else {
                        textoDescr1 = "?";
                    }
                     */
                    String pR = "", pW = "", pE = "";

                    if (f.canRead()) {
                        pR = "Escritura";
                    }
                    if (f.canWrite()) {
                        pW = "Lectura";
                    }
                    if (f.canExecute()) {
                        pE = "Ejecución";
                    }
                    if (!f.canRead() && !f.canWrite() && !f.canExecute()) {
                        pR = "Ninguno";
                    }

                    System.out.println("(" + textoDescr + ") " + f.getName() + ""
                            + ", " + f.length() + "bytes, permisos: " + pR + ", " + pW + ", " + pE);
                }
            }
            boolean logCreado = fileLogs.createNewFile();
            if (logCreado) {
                System.out.println("Archivo creado.");
            }

        }

    }

}
