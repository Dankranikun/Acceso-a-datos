/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author nicop
 */
import DTO.DTOPersonaVehiculo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaVehiculoDAO extends GenericDAO<DTOPersonaVehiculo> {

    private static final String URL = "jdbc:mysql://localhost:3306/registroconcesionario";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    @Override
    public boolean create(DTOPersonaVehiculo personaVehiculo) {
        String sql = "INSERT INTO registro (id_persona, id_vehiculo, nombre, matricula, anyo, marca, modelo, fecha_inicio, fecha_fin, genero) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, personaVehiculo.getId_persona());
            statement.setInt(2, personaVehiculo.getId_vehiculo());
            statement.setString(3, personaVehiculo.getNombre());
            statement.setString(4, personaVehiculo.getMatricula());
            statement.setString(5, personaVehiculo.getAnyo());
            statement.setString(6, personaVehiculo.getMarca());
            statement.setString(7, personaVehiculo.getModelo());
            statement.setDate(8, java.sql.Date.valueOf(personaVehiculo.getFecha_inicio()));
            statement.setDate(9, java.sql.Date.valueOf(personaVehiculo.getFecha_fin()));
            statement.setString(10, personaVehiculo.getGenero());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public DTOPersonaVehiculo read(int id) {
        String sql = "SELECT id, id_persona, id_vehiculo, nombre, matricula, anyo, marca, modelo, fecha_inicio, fecha_fin, genero FROM registro WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new DTOPersonaVehiculo(resultSet.getInt("id"),
                                           resultSet.getInt("id_persona"),
                                           resultSet.getInt("id_vehiculo"),
                                           resultSet.getString("nombre"),
                                           resultSet.getString("matricula"),
                                           resultSet.getString("anyo"),
                                           resultSet.getString("marca"),
                                           resultSet.getString("modelo"),
                                           resultSet.getDate("fecha_inicio").toString(),
                                           resultSet.getDate("fecha_fin").toString(),
                                           resultSet.getString("genero"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<DTOPersonaVehiculo> readAll() {
        List<DTOPersonaVehiculo> registros = new ArrayList<>();
        String sql = "SELECT id, id_persona, id_vehiculo, nombre, matricula, anyo, marca, modelo, fecha_inicio, fecha_fin, genero FROM registro";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                registros.add(new DTOPersonaVehiculo(resultSet.getInt("id"),
                                                  resultSet.getInt("id_persona"),
                                                  resultSet.getInt("id_vehiculo"),
                                                  resultSet.getString("nombre"),
                                                  resultSet.getString("matricula"),
                                                  resultSet.getString("anyo"),
                                                  resultSet.getString("marca"),
                                                  resultSet.getString("modelo"),
                                                  resultSet.getDate("fecha_inicio").toString(),
                                                  resultSet.getDate("fecha_fin").toString(),
                                                  resultSet.getString("genero")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    @Override
    public boolean update(DTOPersonaVehiculo DTOPersonaVehiculo) {
        String sql = "UPDATE registro SET id_persona = ?, id_vehiculo = ?, nombre = ?, matricula = ?, anyo = ?, marca = ?, modelo = ?, fecha_inicio = ?, fecha_fin = ?, genero = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, DTOPersonaVehiculo.getId_persona());
            statement.setInt(2, DTOPersonaVehiculo.getId_vehiculo());
            statement.setString(3, DTOPersonaVehiculo.getNombre());
            statement.setString(4, DTOPersonaVehiculo.getMatricula());
            statement.setString(5, DTOPersonaVehiculo.getAnyo());
            statement.setString(6, DTOPersonaVehiculo.getMarca());
            statement.setString(7, DTOPersonaVehiculo.getModelo());
            statement.setDate(8, java.sql.Date.valueOf(DTOPersonaVehiculo.getFecha_inicio()));
            statement.setDate(9, java.sql.Date.valueOf(DTOPersonaVehiculo.getFecha_fin()));
            statement.setString(10, DTOPersonaVehiculo.getGenero());
            statement.setInt(11, DTOPersonaVehiculo.getId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM registro WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

