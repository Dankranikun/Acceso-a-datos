package DAO;

import DTO.DTOPersona;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO extends GenericDAO<DTOPersona, String> {

    private static final String URL = "jdbc:mysql://localhost:3306/registroconcensionario";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    @Override
    public boolean create(DTOPersona persona) {
        String sql = "INSERT INTO persona (dni, nombre, genero) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, persona.getDni());
            statement.setString(2, persona.getNombre());
            statement.setString(3, persona.getGenero());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public DTOPersona read(String dni) {
        String sql = "SELECT dni, nombre, genero FROM persona WHERE dni = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, dni);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new DTOPersona(resultSet.getString("dni"),
                                      resultSet.getString("nombre"),
                                      resultSet.getString("genero"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<DTOPersona> readAll() {
        List<DTOPersona> personas = new ArrayList<>();
        String sql = "SELECT dni, nombre, genero FROM persona";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                personas.add(new DTOPersona(resultSet.getString("dni"),
                                            resultSet.getString("nombre"),
                                            resultSet.getString("genero")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personas;
    }

    @Override
    public boolean update(DTOPersona persona) {
        String sql = "UPDATE persona SET nombre = ?, genero = ? WHERE dni = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, persona.getNombre());
            statement.setString(2, persona.getGenero());
            statement.setString(3, persona.getDni());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String dni) {
        String sql = "DELETE FROM persona WHERE dni = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, dni);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
