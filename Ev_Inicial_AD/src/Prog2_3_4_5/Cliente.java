/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prog2_3_4_5;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Dankrani
 */
public class Cliente {

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.pedirDatos();
        cliente.verCliente();
        cliente.guardarDatos();
    }
    int cliente;
    String nombre;
    String direccion;
    String telefono;

    public void verCliente() {
        System.out.println("Cliente{" + "cliente=" + cliente + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + "}");
    }

    public void pedirDatos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce los datos del cliente:\n Nombre: ");
        nombre = sc.nextLine();
        System.out.println("Dirección: ");
        direccion = sc.nextLine();
        System.out.println("Teléfono: ");
        telefono = sc.nextLine();
    }

    public void guardarDatos() {
//        try {
//            FileWriter archivo = new FileWriter("datos_cliente.txt");
//            PrintWriter escritor = new PrintWriter(archivo);
//
//            escritor.println("Datos del cliente:");
//            escritor.println("Nombre: " + nombre);
//            escritor.println("Dirección: " + direccion);
//            escritor.println("Teléfono: " + telefono);
//
//            escritor.close();
//            System.out.println("Los datos se han guardado en 'datos_cliente.txt'.");
//
//        } catch (IOException e) {
//            System.out.println("Ocurrió un error al guardar los datos en el archivo.");
//            e.printStackTrace();
//        }
    }

}
