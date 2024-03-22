/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cedros.evidenciau3.interfaces;

import com.cedros.evidenciau3.models.Socios;
import java.util.List;

/**
 *
 * @author Gerardo Lerma Bahena
 */
public interface SociosInt {
    public void Registrar(Socios socio) throws Exception;

    /**
     *
     * @param Nombre
     * @param apellidos
     * @throws Exception
     */
    public void Eliminar(String Nombre, String apellidos) throws Exception;
    public void Consultar(String Nombre, String apellidos) throws Exception;
    public List<Socios> listar(String Nombre, String apellidos) throws Exception;
    public List<Socios> listarSocios(String Nombre, String apellidos) throws Exception;
    public Socios getUserById(int folioSocio) throws Exception;
}
