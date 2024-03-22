/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cedros.evidenciau3.models;

/**
 *
 * @author Gerardo Lerma
 */
//Modelo para la funcionalidad de las visas de Socios
//Las columnas de mi tabla socios, son los atributos de la clase Socios 
public class Socios {
    private int folioSocio;
    private String Nombre;
    private String apellidos;
    private String telefono;
    private String domicilio;
    private String actividades;
    private String vigencia;

    public void setFolioSocio(int folioSocio) {
        this.folioSocio = folioSocio;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public int getFolioSocio() {
        return folioSocio;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getActividades() {
        return actividades;
    }

    public String getVigencia() {
        return vigencia;
    }
    
    
    
}

