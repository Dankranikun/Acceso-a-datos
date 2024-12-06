/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.sql.Connection;
import java.sql.Statement;
import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

/**
 *
 * @author nicop
 */
public class ConnectionPool {
        public static void main(String[] args) {
        try {
            //Crea la instancia con el pool.
            
            PoolDataSource pds = PoolDataSourceFactory.getPoolDataSource();
            
            //Introduce las condiciones de conexión.
            
            pds.setConnectionFactoryClassName("oracle.jdbc.pool.OracleDataSource");
            pds.setURL("jdbc:mysql://localhost/registroconcensionario");
            pds.setUser("admin");
            pds.setPassword("admin");
            pds.setInitialPoolSize(5);
            
            //Obtener la conexión con la BBDD
            
            Connection conn = pds.getConnection();
            
            System.out.println("\nConnection obtained from UniversalConnectionPool\n");
            
            //Se ejecutan las operaciones con las BBDD
            
            Statement stmt = conn.createStatement();
            stmt.execute("select * from vehiculo");
            
            //Se cierra la conexión
            
            conn.close();
            conn = null;
            
            System.out.println("Connection returned to the UniversalConnectionPoool\n");
            
        } catch (Exception e) {
        }
    }
}
