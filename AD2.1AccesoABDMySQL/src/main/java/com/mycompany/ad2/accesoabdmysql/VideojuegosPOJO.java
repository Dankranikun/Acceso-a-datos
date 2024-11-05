/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ad2.accesoabdmysql;

import java.sql.Date;
import javax.xml.crypto.Data;

/**
 *
 * @author Dankrani
 */
public class VideojuegosPOJO {
    private int id;
    private String nombre;
    private String genero;
    private Date fechaLanzamiento;
    private String compañia;
    private float precio;

    public VideojuegosPOJO() {
    }

    public VideojuegosPOJO(String nombre) {
        this.nombre = nombre;
    }

    public VideojuegosPOJO(int id, String nombre, String genero, Date fechaLanzamiento, String compañia, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.fechaLanzamiento = fechaLanzamiento;
        this.compañia = compañia;
        this.precio = precio;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getCompañia() {
        return compañia;
    }

    public void setCompañia(String compañia) {
        this.compañia = compañia;
    }

    @Override
    public String toString() {
        return "VideojuegosPOJO{" + "id=" + id + ", nombre=" + nombre + ", genero=" + genero + ", fechaLanzamiento=" + fechaLanzamiento + ", compa\u00f1ia=" + compañia + ", precio=" + precio + '}';
    }
}
