/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Conexion.SQLconexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class Empleado {

    private String cedula, nombre, direccion, cargo;
    private double sueldo;

    public Empleado(String cedula, String nombre, String direccion, String cargo, double sueldo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cargo = cargo;
        this.sueldo = sueldo;
    }
    
    // seccion de los setters

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    //seccion de los getters

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSueldo() {
        return sueldo;
    }
    

    @Override
    public String toString() {
        return this.nombre;
    }
    
 
    public static void ParaComboBox(ObservableList<Empleado> lista) {
        
        try {
            SQLconexion coneccion=new SQLconexion();
            Connection con=coneccion.getConect();
            Statement st=con.createStatement();
            ResultSet resultado=st.executeQuery("select cedula, nombre, direccion, sueldo, cargo from empleado;");
            
            while(resultado.next()) {
                lista.add(new Empleado(resultado.getString("cedula"),resultado.getString("nombre"),resultado.getString("direccion"),resultado.getString("cargo"),resultado.getDouble("sueldo")));
            }
                
            coneccion.cerrarConect();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static int Ingresar_datos(Empleado nuevo) {
        try {
            SQLconexion coneccion=new SQLconexion();
            Connection con=coneccion.getConect();
            PreparedStatement state=con.prepareStatement("insert into Empleado(cedula,nombre,direccion,sueldo,cargo) values ('"+nuevo.getCedula()+"','"+nuevo.getNombre()+"','"+nuevo.getDireccion()+"',"+nuevo.getSueldo()+",'"+nuevo.getCargo()+"');");

            return state.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.print("Ha Ocurrido un Error: "+ex.getMessage());
            return 0;
        }
        
    }
    
    public static int actualizar_datos(Empleado nuevo) {
        try {
            SQLconexion coneccion=new SQLconexion();
            Connection con=coneccion.getConect();
            PreparedStatement state=con.prepareStatement("update empleado set nombre='"+nuevo.getNombre()+"', direccion='"+nuevo.getDireccion()+"',sueldo="+nuevo.getSueldo()+",cargo='"+nuevo.getCargo()+"' where cedula='"+nuevo.getCedula()+"';");

            return state.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.print("Ha Ocurrido un Error: "+ex.getMessage());
            return 0;
        }
        
    }
    
    public static int elimiar_datos(String text) {
         try {
            SQLconexion coneccion=new SQLconexion();
            Connection con=coneccion.getConect();
            PreparedStatement state=con.prepareStatement("delete from empleado where cedula='"+text+"';");
            return state.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.print("Ha Ocurrido un Error: "+ex.getMessage());
            return 0;
        }
    }
    
}
