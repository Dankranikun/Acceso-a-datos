/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

public class Conexion {

    private static String DB_URL = "jdbc:mysql://localhost/registroconcensionario";
    private static String USER = "admin";
    private static String PASS = "admin";
    private static Connection connection = null;

    public Conexion(String url, String usuario, String password) {
        DB_URL = url;
        USER = usuario;
        PASS = password;
    }

    //abrir conexión
    public static Connection abrirConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Conexión establecida");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver no encontrado " + e);
        } catch (SQLException e) {
            System.err.println("Error de conexión " + e);
        }
        return connection;
    }

    //cerrar conexión
    public static void cerrarConexion() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexion cerrada Correctamente");
            } catch (SQLException e) {
                System.err.println(" Error al cerrar coenexión " + e);
            }
        } else {
            System.out.println("No hay ninguna conexión abierta");
        }
    }

    public static void cerrarPreparedStatement(PreparedStatement pstmt) {
        if (pstmt != null) {
            try {
                pstmt.close();
                System.out.println("PreparedStatement cerrado correctamente");
            } catch (SQLException e) {
                System.err.println("Error al cerrar PreparedStatement: " + e);
            }
        } else {
            System.out.println("No hay PreparedStatement abierto para cerrar");
        }
    }

    public static void cerrarResulset(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
                System.out.println("Resulset cerrado correctamente");
            } catch (SQLException e) {
                System.err.println("Error al cerrar Resulset: " + e);
            }
        } else {
            System.out.println("No hay Resulset abierto para cerrar");
        }
    }
}
