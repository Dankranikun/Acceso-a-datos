/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author nicop
 */
public class DTOPersona {

    private String dni;
    private String nombre;
    private String genero;

    public DTOPersona() {
    }

    public DTOPersona(String nombre) {
        this.nombre = nombre;
    }

    public DTOPersona(String dni, String nombre, String genero) {
        this.dni = dni;
        this.nombre = nombre;
        this.genero = genero;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "DTOPersona{" + "dni=" + dni + ", nombre=" + nombre + ", genero=" + genero + '}';
    }
}
