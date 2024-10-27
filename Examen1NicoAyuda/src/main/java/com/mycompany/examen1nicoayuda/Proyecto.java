/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen1nicoayuda;

/**
 *
 * @author Dankrani
 */
public class Proyecto {
    private String nombre;
    private String equipo;
    private String liderProyecto;
    private String fechaInicio;
    private String fechaFin;
    private String tecnologias;
    private String estado;
    private String presupuesto;

    // Constructor, getters y setters
    public Proyecto(String nombre, String equipo, String liderProyecto, String fechaInicio, String fechaFin, String tecnologias, String estado, String presupuesto) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.liderProyecto = liderProyecto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tecnologias = tecnologias;
        this.estado = estado;
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nEquipo: " + equipo + "\nLíder: " + liderProyecto + "\nFecha Inicio: " + fechaInicio +
               "\nFecha Fin: " + fechaFin + "\nTecnologías: " + tecnologias + "\nEstado: " + estado + "\nPresupuesto: " + presupuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getLiderProyecto() {
        return liderProyecto;
    }

    public void setLiderProyecto(String liderProyecto) {
        this.liderProyecto = liderProyecto;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(String tecnologias) {
        this.tecnologias = tecnologias;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(String presupuesto) {
        this.presupuesto = presupuesto;
    }

  

    
}

