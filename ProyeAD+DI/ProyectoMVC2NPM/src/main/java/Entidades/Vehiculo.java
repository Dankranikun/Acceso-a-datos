/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author nicop
 */
public class Vehiculo {
    private int idV;
    private String matricula;
    private String marca;
    private String modelo;
    private String fecha;

    public Vehiculo() {
    }

    public Vehiculo(String matricula, String marca, String modelo, String fecha) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.fecha = fecha;
    }

    public Vehiculo(int idV, String matricula, String marca, String modelo, String fecha) {
        this.idV = idV;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdV() {
        return idV;
    }

    public void setIdV(int idV) {
        this.idV = idV;
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

    @Override
    public String toString() {
        return "DTOVehiculo{" + "idV=" + idV + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", fecha=" + fecha + '}';
    }
}

