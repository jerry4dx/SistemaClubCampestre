/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cedros.evidenciau3.cedrosdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gerardo Lerma Bahena
 */
public class conexiondb {
    protected Connection conexion; 
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String BD_URL ="jdbc:mysql://localhost:3306/cedros";
    
    private final String USUARIO ="root";
    private final String PASS ="";
    
    public void Conectar() throws ClassNotFoundException{
        try {
            System.out.println("OK1");
            conexion = DriverManager.getConnection(BD_URL, USUARIO, PASS);
            System.out.println("OK2");
            Class.forName(DRIVER);
            System.out.println("Conectado");
        } catch (SQLException ex) {
            System.out.print("No jala");
            Logger.getLogger(conexiondb.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    public void Cerrar() throws SQLException{
        if(conexion != null){
            if(!conexion.isClosed()){
                conexion.close();
            }
        }
    }
    
}


