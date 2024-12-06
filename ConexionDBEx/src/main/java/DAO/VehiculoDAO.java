package DAO;

import DTO.DTOVehiculo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDAO extends GenericDAO<DTOVehiculo, String> {

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
            statement.setString(4, vehiculo.getFecha());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public DTOVehiculo read(String matricula) {
        String sql = "SELECT matricula, marca, modelo, fecha FROM vehiculo WHERE matricula = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, matricula);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new DTOVehiculo(resultSet.getString("matricula"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("fecha"));
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
                vehiculos.add(new DTOVehiculo(resultSet.getString("matricula"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("fecha")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehiculos;
    }

    @Override
    public boolean update(DTOVehiculo vehiculo) {
        String sql = "UPDATE vehiculo SET marca = ?, modelo = ?, fecha = ? WHERE matricula = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, vehiculo.getMarca());
            statement.setString(2, vehiculo.getModelo());
            statement.setString(3, vehiculo.getFecha());
            statement.setString(4, vehiculo.getMatricula());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String matricula) {
        String sql = "DELETE FROM vehiculo WHERE matricula = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, matricula);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> obtenerMarcas() {
        List<String> marcas = new ArrayList<>();
        String sql = "SELECT DISTINCT marca FROM vehiculo";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                marcas.add(resultSet.getString("marca"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return marcas;
    }

    public List<String> obtenerModelosPorMarca(String marca) {
        List<String> modelos = new ArrayList<>();
        String sql = "SELECT modelo FROM vehiculo WHERE marca = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, marca);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                modelos.add(resultSet.getString("modelo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modelos;
    }
}
