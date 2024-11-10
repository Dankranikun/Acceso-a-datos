/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author nicop
 */
import DTO.DTOVehiculo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDAO extends GenericDAO<DTOVehiculo> {

    private static final String URL = "jdbc:mysql://localhost:3306/registroconcensionario";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    @Override
    public boolean create(DTOVehiculo vehiculo) {
        String sql = "INSERT INTO vehiculo (matricula, marca, modelo, fecha) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, vehiculo.getMatricula());
            statement.setString(2, vehiculo.getMarca());
            statement.setString(3, vehiculo.getModelo());
            statement.setDate(4, java.sql.Date.valueOf(vehiculo.getFecha()));
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public DTOVehiculo read(int id) {
        String sql = "SELECT matricula, marca, modelo, fecha FROM vehiculo WHERE idV = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new DTOVehiculo(id,
                        resultSet.getString("matricula"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getDate("fecha").toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<DTOVehiculo> readAll() {
        List<DTOVehiculo> vehiculos = new ArrayList<>();
        String sql = "SELECT matricula, marca, modelo, fecha FROM vehiculo";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                vehiculos.add(new DTOVehiculo(0, // ID is not displayed or used
                        resultSet.getString("matricula"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getDate("fecha").toString()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehiculos;
    }

    @Override
    public boolean update(DTOVehiculo vehiculo) {
        String sql = "UPDATE vehiculo SET matricula = ?, marca = ?, modelo = ?, fecha = ? WHERE idV = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, vehiculo.getMatricula());
            statement.setString(2, vehiculo.getMarca());
            statement.setString(3, vehiculo.getModelo());
            statement.setDate(4, java.sql.Date.valueOf(vehiculo.getFecha()));
            statement.setInt(5, vehiculo.getIdV());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM vehiculo WHERE idV = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
