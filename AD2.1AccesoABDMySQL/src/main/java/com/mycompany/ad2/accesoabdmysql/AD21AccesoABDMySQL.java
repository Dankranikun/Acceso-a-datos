/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ad2.accesoabdmysql;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Dankrani
 */
public class AD21AccesoABDMySQL {

    static final String DB_URL = "jdbc:mysql://localhost/jcvd";
    static final String USER = "admin";
    static final String PASS = "admin";
    static final String QUERY = "SELECT * FROM `videojuegos`";
    Connection con;
    Statement sentencia;

    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);

        int menuSelec = 0;
        do {
            MenuSQL();
            menuSelec = scan.nextInt();
            switch (menuSelec) {
                case 1:
                    buscarNombre();
                    break;
                case 2:
                    System.out.println("lanzaConsulta");
                    break;
                case 3:
                    System.out.println("nuevoRegistro");
                    break;
                case 4:
                    System.out.println("nuevoRegistro (completo)");
                    break;
                case 5:
                    System.out.println("eliminarRegistro");
                    break;
                default:
                    System.out.println("fuera de rango");
            }
        } while (menuSelec <= 0 && menuSelec >= 5);

        // Abrir conexión
        try (
                Connection con = DriverManager.getConnection(DB_URL, USER, PASS); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(QUERY)) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void MenuSQL() {
        System.out.println("¿Qué quieres hacer?");
        System.out.println("1.- Buscar por nombre\n2.- Ver consulta anterior\n3.- Añadir videojuego\n4.- Añadir videojuego (completo)\n5.- Eliminar vidoejuego.");
    }

    public static void buscarNombre() throws SQLException {
        Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
        Scanner scan = new Scanner(System.in);
        String nombre = scan.nextLine();
        String sql = "SELECT * FROM videojuegos WHERE nombre = " + nombre;
        PreparedStatement prepStat = con.prepareStatement(sql);

        prepStat.setString(1, nombre);
        ResultSet rs = prepStat.executeQuery();

        if (rs.next()) {
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Nombre: " + rs.getString("nombre"));
            System.out.println("Género: " + rs.getString("genero"));
            System.out.println("Lanzamiento: " + rs.getDate("fechaLanzamiento"));
            System.out.println("Compañía: " + rs.getString("compañia"));
            System.out.println("Precio: " + rs.getFloat("precio"));
            System.out.println("----------------------------------");
        } else {
            System.out.println("No se encontró un videojuego con el nombre: " + nombre);
        }

    }

    public void anadir(String nombre, String genero, Date fechaLanzamiento, String compañia, float precio) {
        String sql = "INSERT INTO videojuegos (nombre, genero, fechaLanzamiento, compañia, precio) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS); PreparedStatement pstmt = con.prepareStatement(sql)) {

            // Establece los parámetros de la consulta
            pstmt.setString(1, nombre);
            pstmt.setString(2, genero);
            pstmt.setDate(3, new java.sql.Date(fechaLanzamiento.getTime()));
            pstmt.setString(4, compañia);
            pstmt.setFloat(5, precio);

            // Ejecuta la consulta
            pstmt.executeUpdate();
            System.out.println("Videojuego añadido a la tabla");

        } catch (SQLException e) {
            System.err.println("SQL Error mensaje: " + e.getMessage());
            System.err.println("SQL Estado: " + e.getSQLState());
            System.err.println("SQL código específico: " + e.getErrorCode());
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

}

/*
try (
                Connection con = DriverManager.getConnection(DB_URL, USER, PASS); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(QUERY)) {
            //Extraer datos del resultado
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Género: " + rs.getString("genero"));
                System.out.println("Lanzamiento: " + rs.getDate("fechaLanzamiento"));
                System.out.println("Compañía: " + rs.getString("compañia"));
                System.out.println("Precio: " + rs.getFloat("precio"));
                System.out.println("----------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 */
