/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Conexion.SQLconexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author Leonidas
 */
public class Proveedor {
    private String ruc,nombre,direccion,cuenta;
    
    public Proveedor(String ruc, String nombre, String dir, String banco){
        this.ruc=ruc;
        this.nombre=nombre;
        this.direccion=dir;
        this.cuenta=banco;
    }
    
    // seccion de getters

    public String getRuc() {
        return ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCuenta() {
        return cuenta;
    }
    
    // seccion de setters

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return ruc + " | " + nombre;
    }
    
    public static void ParaComboBox(ObservableList<Proveedor> lista) {
        try {
            SQLconexion coneccion=new SQLconexion();
            Connection con=coneccion.getConect();
            Statement st=con.createStatement();
            ResultSet resultado=st.executeQuery("select ruc, n_proveedor, direccion, cuenta_no from proveedor;");
            
            while(resultado.next()) {
                lista.add(new Proveedor(resultado.getString("ruc"),resultado.getString("n_proveedor"),resultado.getString("direccion"),resultado.getString("cuenta_no")));
            }
                
            coneccion.cerrarConect();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
