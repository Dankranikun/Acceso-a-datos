package Servicio;

import DAO.PersonaDAO;
import DTO.DTOPersona;
import java.util.List;

public class PersonaService {

    private PersonaDAO personaDAO;

    public PersonaService() {
        personaDAO = new PersonaDAO();
    }

    // Crear una nueva persona
    public boolean crearPersona(DTOPersona persona) {
        return personaDAO.create(persona);
    }

    // Leer una persona por ID (clave primaria)
    public DTOPersona obtenerPersona(String key) {
        return personaDAO.read(key);
    }

    // Leer todas las personas
    public List<DTOPersona> obtenerTodasPersonas() {
        return personaDAO.readAll();
    }

    // Actualizar una persona existente
    public boolean actualizarPersona(DTOPersona persona) {
        return personaDAO.update(persona);
    }

    // Eliminar una persona por ID (clave primaria)
    public boolean eliminarPersona(String key) {
        return personaDAO.delete(key);
    }
}
