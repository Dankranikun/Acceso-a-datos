package Servicio;

import DAO.VehiculoDAO;
import DTO.DTOVehiculo;
import java.util.List;

public class VehiculoService {

    private VehiculoDAO vehiculoDAO;

    public VehiculoService() {
        vehiculoDAO = new VehiculoDAO();
    }

    // Crear un nuevo vehículo
    public boolean crearVehiculo(DTOVehiculo vehiculo) {
        return vehiculoDAO.create(vehiculo);
    }

    // Leer un vehículo por matrícula (clave primaria)
    public DTOVehiculo obtenerVehiculo(String matricula) {
        return vehiculoDAO.read(matricula);
    }

    // Leer todos los vehículos
    public List<DTOVehiculo> obtenerTodosVehiculos() {
        return vehiculoDAO.readAll();
    }

    // Actualizar un vehículo existente
    public boolean actualizarVehiculo(DTOVehiculo vehiculo) {
        return vehiculoDAO.update(vehiculo);
    }

    // Eliminar un vehículo por matrícula (clave primaria)
    public boolean eliminarVehiculo(String matricula) {
        return vehiculoDAO.delete(matricula);
    }
}
