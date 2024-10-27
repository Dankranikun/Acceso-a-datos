/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen1nicoayuda;

import java.util.Scanner;

/**
 *
 * @author Dankrani
 */
public class MenuXML {

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Insertar proyecto");
            System.out.println("2. Editar proyecto");
            System.out.println("3. Borrar proyecto");
            System.out.println("4. Mostrar proyectos");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    insertarProyecto(sc);
                    break;
                case 2:
                    editarProyecto(sc);
                    break;
                case 3:
                    borrarProyecto(sc);
                    break;
                case 4:
                    mostrarProyectos();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        sc.close();
    }

    public static void insertarProyecto(Scanner sc) {
        System.out.println("Insertar nuevo proyecto...");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Equipo: ");
        String equipo = sc.nextLine();
        System.out.print("Líder del proyecto: ");
        String lider = sc.nextLine();
        System.out.print("Fecha de inicio: ");
        String fechaInicio = sc.nextLine();
        System.out.print("Fecha de fin: ");
        String fechaFin = sc.nextLine();
        System.out.print("Tecnologías: ");
        String tecnologias = sc.nextLine();
        System.out.print("Estado: ");
        String estado = sc.nextLine();
        System.out.print("Presupuesto: ");
        String presupuesto = sc.nextLine();

        Proyecto nuevoProyecto = new Proyecto(nombre, equipo, lider, fechaInicio, fechaFin, tecnologias, estado, presupuesto);
        ParseXMLStAX.proyectos.add(nuevoProyecto);
        System.out.println("Proyecto agregado exitosamente.");
    }

    public static void editarProyecto(Scanner sc) {
        System.out.println("Editar proyecto...");
        mostrarProyectos();
        System.out.print("Elija el número del proyecto a editar: ");
        int index = sc.nextInt() - 1;
        sc.nextLine(); // Consumir la nueva línea

        if (index >= 0 && index < ParseXMLStAX.proyectos.size()) {
            Proyecto proyecto = ParseXMLStAX.proyectos.get(index);

            System.out.print("Nuevo nombre (" + proyecto.getNombre() + "): ");
            String nombre = sc.nextLine();
            if (!nombre.isEmpty()) {
                proyecto.setNombre(nombre);
            }

            System.out.print("Nuevo equipo (" + proyecto.getEquipo() + "): ");
            String equipo = sc.nextLine();
            if (!equipo.isEmpty()) {
                proyecto.setEquipo(equipo);
            }

            System.out.print("Nuevo líder (" + proyecto.getLiderProyecto() + "): ");
            String lider = sc.nextLine();
            if (!lider.isEmpty()) {
                proyecto.setLiderProyecto(lider);
            }

            System.out.print("Nueva fecha de inicio (" + proyecto.getFechaInicio() + "): ");
            String fechaInicio = sc.nextLine();
            if (!fechaInicio.isEmpty()) {
                proyecto.setFechaInicio(fechaInicio);
            }

            System.out.print("Nueva fecha de fin (" + proyecto.getFechaFin() + "): ");
            String fechaFin = sc.nextLine();
            if (!fechaFin.isEmpty()) {
                proyecto.setFechaFin(fechaFin);
            }

            System.out.print("Nuevas tecnologías (" + proyecto.getTecnologias() + "): ");
            String tecnologias = sc.nextLine();
            if (!tecnologias.isEmpty()) {
                proyecto.setTecnologias(tecnologias);
            }

            System.out.print("Nuevo estado (" + proyecto.getEstado() + "): ");
            String estado = sc.nextLine();
            if (!estado.isEmpty()) {
                proyecto.setEstado(estado);
            }

            System.out.print("Nuevo presupuesto (" + proyecto.getPresupuesto() + "): ");
            String presupuesto = sc.nextLine();
            if (!presupuesto.isEmpty()) {
                proyecto.setPresupuesto(presupuesto);
            }

            System.out.println("Proyecto editado exitosamente.");
        } else {
            System.out.println("Número de proyecto no válido.");
        }
    }

    public static void borrarProyecto(Scanner sc) {
        System.out.println("Borrar proyecto...");
        mostrarProyectos();
        System.out.print("Elija el número del proyecto a borrar: ");
        int index = sc.nextInt() - 1;
        sc.nextLine(); // Consumir la nueva línea

        if (index >= 0 && index < ParseXMLStAX.proyectos.size()) {
            ParseXMLStAX.proyectos.remove(index);
            System.out.println("Proyecto borrado exitosamente.");
        } else {
            System.out.println("Número de proyecto no válido.");
        }
    }

    public static void mostrarProyectos() {
        System.out.println("Lista de proyectos:");
        for (int i = 0; i < ParseXMLStAX.proyectos.size(); i++) {
            Proyecto p = ParseXMLStAX.proyectos.get(i);
            System.out.println((i + 1) + ". "
                    + "Nombre: " + p.getNombre() + "\n"
                    + "Equipo: " + p.getEquipo() + "\n"
                    + "Líder del Proyecto: " + p.getLiderProyecto() + "\n"
                    + "Fecha de Inicio: " + p.getFechaInicio() + "\n"
                    + "Fecha de Fin: " + p.getFechaFin() + "\n"
                    + "Tecnologías: " + p.getTecnologias() + "\n"
                    + "Estado: " + p.getEstado() + "\n"
                    + "Presupuesto: " + p.getPresupuesto() + "\n");
        }
    }
}
