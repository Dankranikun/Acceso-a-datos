/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author nicop
 */
public class DTOPersonaVehiculo {
    int id;
    int id_persona;
    int id_vehiculo;
    String nombre;
    String matricula;
    String anyo;
    String marca;
    String modelo;
    String fecha_inicio;
    String fecha_fin;
    String genero;

    public DTOPersonaVehiculo() {
    }

    public DTOPersonaVehiculo(int id, int id_persona, int id_vehiculo, String nombre, String matricula, String anyo, String modelo, String marca, String fecha_inicio, String fecha_fin, String genero) {
        this.id = id;
        this.id_persona = id_persona;
        this.id_vehiculo = id_vehiculo;
        this.nombre = nombre;
        this.matricula = matricula;
        this.anyo = anyo;
        this.modelo = modelo;
        this.marca = marca;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnyo() {
        return anyo;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "DTOPersonaVehiculo{" +
                "id=" + id +
                ", id_persona=" + id_persona +
                ", id_vehiculo=" + id_vehiculo +
                ", nombre='" + nombre + '\'' +
                ", matricula='" + matricula + '\'' +
                ", anyo='" + anyo + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", fecha_inicio='" + fecha_inicio + '\'' +
                ", fecha_fin='" + fecha_fin + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
