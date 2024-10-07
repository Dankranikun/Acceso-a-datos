/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad2.pkg2_lecturayescrituradearchivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dankrani
 */
public class AD22_LecturaYEscrituraDeArchivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String rutaArchivo = "C:\\Users\\Dankrani\\Documents\\GitHub\\Acceso-a-datos\\AD2.2_LecturaYEscrituraDeArchivos\\alumnosNotas.txt";
        List<String> listadoNotas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] separados = linea.split(":");
                for (String elemento : separados) {
                    listadoNotas.add(elemento.trim());
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        
        System.out.println("Elementos separados:");
        for (String elemento : listadoNotas) {
            System.out.println(elemento);
        }

    }

}