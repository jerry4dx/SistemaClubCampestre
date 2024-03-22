/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cedros.evidenciau3;

import com.cedros.evidenciau3.cedrosdb.conexiondb;
import com.cedros.evidenciau3.interfaces.SociosInt;
import com.cedros.evidenciau3.models.Socios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gerardo Lerma Bahena
 */
public class SociosImpl extends conexiondb implements SociosInt{

    @Override
    public void Registrar(Socios socio) throws Exception {
        //
        try{
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO socio(Nombre, apellidos, telefono, domicilio, actividades, vigencia) VALUES(?,?,?,?,?,?);");
            st.setString(1, socio.getNombre());
            st.setString(2, socio.getApellidos());
            st.setString(3, socio.getTelefono());
            st.setString(4, socio.getDomicilio());
            st.setString(5, socio.getActividades());
            st.setString(6  , socio.getVigencia());
            st.executeUpdate();
            
        }catch(Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void Eliminar(String Nombre, String apellidos) throws Exception {
        
        try{
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM socio WHERE Nombre=? AND apellidos=?");
            st.setString(1, Nombre);
            st.setString(2, apellidos);
            st.executeUpdate();
            int sociosborrados = st.executeUpdate();
            if(sociosborrados==0){JOptionPane.showMessageDialog(null, "Socio no regitrado.",
                "Advertencia:", JOptionPane.WARNING_MESSAGE);}else{
                JOptionPane.showMessageDialog(null, "Registro eliminado con éxito.",
                "Correcto:", JOptionPane.INFORMATION_MESSAGE);
            }
            st.close();
        }catch(Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        
    }

    @Override
    public void Consultar(String Nombre, String apellidos) throws Exception {
        List<Socios> lista = null;
        try{
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM socio WHERE Nombre=? AND apellidos=? SORT BY");
            st.setString(1, Nombre);
            st.setString(2, apellidos);
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            
            while(rs.first()) {
                Socios socios = new Socios();
                socios.setFolioSocio(rs.getInt("folioSocio"));
                socios.setNombre(rs.getString("Nombre"));
                socios.setApellidos(rs.getString("apellidos"));
                socios.setTelefono(rs.getString("telefono"));
                socios.setDomicilio(rs.getString("domicilio"));
                socios.setActividades(rs.getString("Actividades"));
                socios.setVigencia("vigencia");
                
                lista.add(socios);
            }
            rs.close();
            st.close();
        }catch(Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        
    }

    @Override
    public List<Socios> listar(String Nombre, String apellidos) throws Exception {
        List<Socios> lista = null;
        try {
            this.Conectar();//1 Conectar
            String Query = Nombre.isEmpty() ? "SELECT * FROM socio;" : "SELECT * FROM socio WHERE Nombre LIKE '%" + Nombre + "%';";
            //String Query = "SELECT * FROM socio WHERE Nombre LIKE '%" + Nombre + "%';";
            PreparedStatement st = this.conexion.prepareStatement(Query);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            if(!rs.next()){ 
            JOptionPane.showMessageDialog(null, "Socio no registrado",
                "Advertencia:", JOptionPane.WARNING_MESSAGE);
            }
            else{
            while(rs.next()) {
                Socios socio = new Socios();
                socio.setFolioSocio(rs.getInt("folioSocio"));
                socio.setNombre(rs.getString("Nombre"));
                socio.setApellidos(rs.getString("apellidos"));
                socio.setTelefono(rs.getString("telefono"));
                socio.setDomicilio(rs.getString("domicilio"));
                socio.setActividades(rs.getString("actividades"));
                socio.setVigencia(rs.getString("vigencia"));
              
                lista.add(socio);
            }
            }
            rs.close();
            st.close();
        } catch(Exception e) {
            
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    @Override
    public Socios getUserById(int folioSocio) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Socios> listarSocios(String Nombre, String apellidos) throws Exception {
        List<Socios> lista = null;
        try {
            this.Conectar();//1 Conectar
            //String Query = Nombre.isEmpty() ? "SELECT * FROM socio;" : "SELECT * FROM socio WHERE Nombre LIKE '%" + Nombre + "%';";
            String Query = "SELECT * FROM socio ORDER BY apellidos;";
            PreparedStatement st = this.conexion.prepareStatement(Query);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            if(!rs.next()){ 
            JOptionPane.showMessageDialog(null, "Socio no registrado",
                "Advertencia:", JOptionPane.WARNING_MESSAGE);
            }
            else{
            while(rs.next()) {
                Socios socio = new Socios();
                socio.setFolioSocio(rs.getInt("folioSocio"));
                socio.setNombre(rs.getString("Nombre"));
                socio.setApellidos(rs.getString("apellidos"));
                socio.setTelefono(rs.getString("telefono"));
                socio.setDomicilio(rs.getString("domicilio"));
                socio.setActividades(rs.getString("actividades"));
                socio.setVigencia(rs.getString("vigencia"));
              
                lista.add(socio);
            }
            }
            rs.close();
            st.close();
        } catch(Exception e) {
            
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
        
    }
    
}
