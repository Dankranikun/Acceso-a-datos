package DAO;

import DTO.DTOPersonaVehiculo;
import DTO.PersonaVehiculoDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PersonaVehiculoDAO extends GenericDAO<DTOPersonaVehiculo, Integer> {

    private static final String URL = "jdbc:mysql://localhost:3306/registroconcensionario";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";
    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;

    // Método para insertar un nuevo registro en la base de datos
    @Override
    public boolean create(DTOPersonaVehiculo personaVehiculo) {
        String sql = "INSERT INTO registro (id_persona, id_vehiculo, nombre, matricula, anyo, marca, modelo, fecha_inicio, fecha_fin, genero) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement statement = connection.prepareStatement(sql)) {
            // Establecer los valores para la inserción
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

    // Método para leer un registro específico por su ID
    @Override
    public DTOPersonaVehiculo read(Integer id) {
        String sql = "SELECT id, id_persona, id_vehiculo, nombre, matricula, anyo, marca, modelo, fecha_inicio, fecha_fin, genero FROM registro WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Crear y devolver el objeto con los datos obtenidos
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

    // Método para leer todos los registros de la base de datos
    @Override
    public List<DTOPersonaVehiculo> readAll() {
        List<DTOPersonaVehiculo> registros = new ArrayList<>();
        String sql = "SELECT id, id_persona, id_vehiculo, nombre, matricula, anyo, marca, modelo, fecha_inicio, fecha_fin, genero FROM registro";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                // Agregar cada registro a la lista
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

    // Método para actualizar un registro existente en la base de datos
    @Override
    public boolean update(DTOPersonaVehiculo personaVehiculo) {
        String sql = "UPDATE registro SET id_persona = ?, id_vehiculo = ?, nombre = ?, matricula = ?, anyo = ?, marca = ?, modelo = ?, fecha_inicio = ?, fecha_fin = ?, genero = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement statement = connection.prepareStatement(sql)) {
            // Establecer los valores para la actualización
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
            statement.setInt(11, personaVehiculo.getId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar un registro de la base de datos por su ID
    @Override
    public boolean delete(Integer id) {
        String sql = "DELETE FROM registro WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<PersonaVehiculoDTO> filtrarPersonasConVehiculos(String nombre, String marca, String modelo, String genero, Integer año, Integer numPropietarios, int limit, int offset) {
        List<PersonaVehiculoDTO> listaPersonas = new ArrayList<>();

        // Validar entradas para evitar inyecciones SQL o entradas inválidas
        if (!limpiarEntradaNombre(nombre) || (año != null && !limpiarEntradaAnio(año)) || (numPropietarios != null && !limpiarEntradaNumPropietarios(numPropietarios))) {
            return listaPersonas; // Si falla, devolver una lista vacía
        }

        // Construir la consulta con  filtros 
        StringBuilder query = new StringBuilder(
                "SELECT nombre, matricula, año, marca, modelo "
                + "FROM historico h "
                + "WHERE h.fecha_fin IS NULL"
        );

        // Lista para almacenar los parámetros de la consulta
        List<Object> parametros = new ArrayList<>();

        // añado condiciones de filtro según los parámetros 
        if (nombre != null && !nombre.isEmpty()) {
            query.append(" AND nombre LIKE ?");
            parametros.add("%" + nombre.trim() + "%"); // Buscar nombre que contenga el valor
        }

        if (marca != null && !marca.equals("Todos")) {
            query.append(" AND marca = ?");
            parametros.add(marca.trim()); // Filtro por marca
        }

        if (modelo != null && !modelo.equals("Todos")) {
            query.append(" AND modelo = ?");
            parametros.add(modelo.trim()); // Filtro por modelo
        }

        if (genero != null && !genero.isEmpty()) {
            query.append(" AND genero = ?");
            parametros.add(genero.trim()); // Filtro por género
        }

        if (año != null && año > 0) {
            query.append(" AND año = ?");
            parametros.add(año); // Filtro por año del vehículo
        }

        if (numPropietarios != null && numPropietarios > 0) {
            query.append(" AND (SELECT COUNT(*) FROM historico h2 WHERE h2.nombre = h.nombre AND h2.fecha_fin IS NULL) = ?");
            parametros.add(numPropietarios); // Filtro por número de propietarios
        }

        // Validar paginación para evitar valores negativos o sea que sea mayor o igual a 0
        limit = Math.max(limit, 0);
        offset = Math.max(offset, 0);

        // Añadir la paginación a la consulta
        query.append(" LIMIT ? OFFSET ?");
        parametros.add(limit);  // Límite de resultados por página
        parametros.add(offset); // Desplazamiento de los resultados

        try {
            conn = ConexionBDD.abrirConexion();

            // Preparar la consulta y convertir a string
            pstmt = conn.prepareStatement(query.toString());

            // Añadir los parámetros a la consulta con un bucle 
            for (int i = 0; i < parametros.size(); i++) {
                pstmt.setObject(i + 1, parametros.get(i)); // Establecer el valor del parámetro en el PreparedStatement
            }

            rs = pstmt.executeQuery();

            // Procesar los resultados de la consulta
            while (rs.next()) {
                String nombrePersona = rs.getString("nombre");
                String matricula = rs.getString("matricula");
                int añoVehiculo = rs.getInt("año");
                String marcaVehiculo = rs.getString("marca");
                String modeloVehiculo = rs.getString("modelo");

                // Crear el objeto PersonaVehiculoDTO y agregarlo a la lista
                PersonaVehiculoDTO personaVehiculo = new PersonaVehiculoDTO(nombrePersona, matricula, añoVehiculo, marcaVehiculo, modeloVehiculo);
                listaPersonas.add(personaVehiculo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        } finally {
            ConexionBDD.cerrarResulset(rs);
            ConexionBDD.cerrarPreparedStatement(pstmt);
            ConexionBDD.cerrarConexion();
        }

        return listaPersonas;
    }

    private boolean limpiarEntradaNombre(String filtro) {
        boolean filtroValido = true;

        if (filtro == null || filtro.isEmpty()) {
            return true; // si el filtro esta vacio me sirve
        }

        // Expresión regular para permitir letras (con tildes y "ñ"), mayúsculas y minúsculas, y espacios
        if (!filtro.matches("^[\\p{L}\\s]{1,40}$")) {  // Limitar a 40 caracteres
            if (filtroValido) {
                JOptionPane.showMessageDialog(null, "El filtro de nombre contiene caracteres no permitidos. Solo se permiten letras y espacios, y un máximo de 40 caracteres.", "Error de filtro", JOptionPane.ERROR_MESSAGE);
                filtroValido = false;
            }
        }

        return filtroValido;
    }

    private boolean limpiarEntradaAnio(Integer filtro) {
        boolean filtroValido = true;

        // Verificar si el filtro es nulo o tiene un valor negativo o cero
        if (filtro == null || filtro <= 0) {
            return true; // Campo nulo o cero se considera válido en este contexto
        } else {
            // Convertir el filtro a cadena y verificar si contiene solo dígitos del 0 al 9
            if (!filtro.toString().matches("^[0-9]+$")) {
                JOptionPane.showMessageDialog(null, "El filtro de año solo permite números del 0 al 9.", "Error de filtro", JOptionPane.ERROR_MESSAGE);
                filtroValido = false;
            }
        }

        return filtroValido;
    }

    private boolean limpiarEntradaNumPropietarios(Integer filtro) {
        boolean filtroValido = true;

        // Verificar si el filtro es nulo o tiene un valor negativo o cero
        if (filtro == null || filtro <= 0) {
            return true; // Campo nulo o cero se considera válido en este contexto
        } else {
            // Convertir el filtro a cadena y verificar si contiene solo dígitos del 0 al 9
            if (!filtro.toString().matches("^[0-9]+$")) {
                JOptionPane.showMessageDialog(null, "El filtro de número de propietarios solo permite números del 0 al 9.", "Error de filtro", JOptionPane.ERROR_MESSAGE);
                filtroValido = false;
            } else {
                // Verificar si el número de propietarios está dentro de un rango razonable
                if (filtro > 1000) {  // Por ejemplo, suponiendo que el número máximo razonable de propietarios es 1000
                    JOptionPane.showMessageDialog(null, "El filtro de número de propietarios debe estar entre 1 y 1000.", "Error de filtro", JOptionPane.ERROR_MESSAGE);
                    filtroValido = false;
                }
            }
        }

        return filtroValido;
    }
}
