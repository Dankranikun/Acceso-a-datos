/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DTO.PersonaVehiculoDTO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import Servicio.PersonaVehiculoService;

/**
 *
 * @author nicop
 */

public class PersonaVehiculoController {
public void mostrarPersonasConVehiculos() {
        List<PersonaVehiculoDTO> personasConVehiculos = personaVehiculoService.obtenerPersonasConVehiculos(paginaActual, tamanopagina);

        DefaultTableModel modeloTabla = (DefaultTableModel) vistaPrincipal.getJTable1().getModel();
        modeloTabla.setRowCount(0);

        for (PersonaVehiculoDTO personaVehiculo : personasConVehiculos) {
            // Obtener el número de propietarios por cada vehículo usando la matrícula
            int numeroPropietarios = personaVehiculoService.obtenerNumeroPropietariosPorVehiculo(personaVehiculo.getMatricula());

            Object[] fila = {
                personaVehiculo.getNombre(),
                personaVehiculo.getMatricula(),
                personaVehiculo.getAño(),
                personaVehiculo.getMarca(),
                personaVehiculo.getModelo(),
                numeroPropietarios
            };
            modeloTabla.addRow(fila);
        }

        actualizarEstadoBotones();
    }
}
