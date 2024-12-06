/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DTO.DTOPersonaVehiculo;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import Servicio.PersonaVehiculoService;
import Vista.Vista;

/**
 *
 * @author nicop
 */
public class PersonaVehiculoController {

    private int paginaActual = 1;  // Página inicial
    private final int tamanopagina = 10; // Número de resultados por página
    private boolean filtrosActivos = false; // Controla si los filtros están activos

    public void mostrarPersonafsConVehiculos() {
        List<DTOPersonaVehiculo> personasConVehiculos = PersonaVehiculoService.obtenerPersonasConVehiculos(paginaActual, tamanopagina);

        DefaultTableModel modeloTabla = Vista.DefaultTableModel modeloTabla = (DefaultTableModel) Vista.jTable1().getModel();
        modeloTabla.setRowCount(0);

        for (DTOPersonaVehiculo personaVehiculo : personasConVehiculos) {
            // Obtener el número de propietarios por cada vehículo usando la matrícula
            int numeroPropietarios = PersonaVehiculoService.obtenerNumeroPropietariosPorVehiculo(personaVehiculo.getMatricula());

            Object[] fila = {
                personaVehiculo.getNombre(),
                personaVehiculo.getMatricula(),
                personaVehiculo.getAnyo(),
                personaVehiculo.getMarca(),
                personaVehiculo.getModelo(),
                numeroPropietarios
            };
            modeloTabla.addRow(fila);
        }

        actualizarEstadoBotones();
    }

    public void mostrarcbMarcaEnVistaCrearVehiculo() {
        try {

            List<String> marcas = personaVehiculoService.obtenerMarcas();

            vistaCrearVehiculo.getcbMarca().removeAllItems();

            //recorro las marcas y lo meto en el combox que lo recojo con el get propio
            for (String marca : marcas) {
                vistaCrearVehiculo.getcbMarca().addItem(marca);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void mostrarDetallesVehiculo(String matricula) {
        //inicializo la ventana si no lo estaba
        if (vistaRegistroVehiculo == null) {
            vistaRegistroVehiculo = new RegistroVehiculo();
        }
        // Actualizo la matrícula en el JLabel
        vistaRegistroVehiculo.setMatriculaLabel(matricula);

        // Obtengo los detalles
        List<PersonaVehiculoDTO> detalles = personaVehiculoService.obtenerDetallesVehiculo(matricula);

        //limpio y actualizo la tabla
        DefaultTableModel modeloTabla = (DefaultTableModel) vistaRegistroVehiculo.getDetallesTable().getModel();
        modeloTabla.setRowCount(0); // Limpio tabla

        for (PersonaVehiculoDTO detalle : detalles) {
            modeloTabla.addRow(new Object[]{
                detalle.getNombre(),
                detalle.getGenero(),
                detalle.getFecha_inicio(),
                detalle.getFecha_fin()
            });
        }

        // Hago visible la ventana de detalles
        vistaRegistroVehiculo.setVisible(true);
    }

    public void mostrarModelosPorMarcaVistaCrearVehiculo(String marcaSelecionada) {
        try {
            Lista<String> modelos = PersonaVehiculoService.
        } catch (Exception e) {
        }
    }
}
