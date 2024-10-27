/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ad2.accesoabdmysql;

import java.sql.*;

/**
 *
 * @author Dankrani
 */
public class AD21AccesoABDMySQL {

    static final String DB_URL = "jdbc:mysql://localhost/jcvd";
    static final String USER = "admin";
    static final String PASS = "admin";
    static final String QUERY = "SELECT * FROM `videojuegos`";

    public static void main(String[] args) {
        // Abrir conexión
        try {
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
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

    }
}
