/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Entidades.Persona;
import Servicio.PersonaService;
import Vista.VistaAsociarVehiculo;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nicop
 */
public class PersonaController {

    private PersonaService personaService;
    private VistaAsociarVehiculo verAsociarVehiculo;

    public PersonaController() {
        this.personaService = new PersonaService();
    }

    public PersonaController(VistaAsociarVehiculo viewAsociarVehiculo) {
        this.verAsociarVehiculo = viewAsociarVehiculo;
        this.personaService = new PersonaService();
    }
    
        public void cargarPersonasEnLaTabla() {
        List<Persona> personas = personaService.obtenerPersonas();
        DefaultTableModel modeloTablaVehiculo = (DefaultTableModel) verAsociarVehiculo.getTablaPersona().getModel();
        modeloTablaVehiculo.setRowCount(0);

        // Verificar si la lista de vehículos no está vacía
        if (personas != null && !personas.isEmpty()) {
            // Recorrer la lista de personas y agregar cada uno a la tabla
            for (Persona persona : personas) {
                // Agregar una fila a la tabla con los datos del persona
                modeloTablaVehiculo.addRow(new Object[]{
                    persona.getNombre(),
                    persona.getDni(),
                    persona.getGenero()

                });
            }
        } else {
            System.out.println("No hay vehículos disponibles.");
        }
    }
        
}
