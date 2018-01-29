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
public class Bodega {
     private String ruc,nombre,direccion,ciudad;
     
     public Bodega(String ruc, String nombre, String dir, String ciudad){
        this.ruc=ruc;
        this.nombre=nombre;
        this.direccion=dir;
        this.ciudad=ciudad;
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

    public String getCiudad() {
        return ciudad;
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

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    
    public static void ParaComboBox(ObservableList<Bodega> lista) {
        try {
            SQLconexion coneccion=new SQLconexion();
            Connection con=coneccion.getConect();
            Statement st=con.createStatement();
            ResultSet resultado=st.executeQuery("select cod_bod, nombrebod, direccion, ciudad from Bodega;");
            
            while(resultado.next()) {
                lista.add(new Bodega(resultado.getString("cod_bod"),resultado.getString("nombrebod"),resultado.getString("direccion"),resultado.getString("ciudad")));
            }
                
            coneccion.cerrarConect();
            con.close();
            
        } catch (SQLException ex) {
            System.out.print("Ha Ocurrido un Error: "+ex.getMessage());
        }
    }
    
    public static int Ingresar_datos(Bodega nuevo) {
        try {
            SQLconexion coneccion=new SQLconexion();
            Connection con=coneccion.getConect();
            PreparedStatement state=con.prepareStatement("insert into Bodega(cod_bod,nombrebod,direccion,ciudad) values ('"+nuevo.getRuc()+"','"+nuevo.getNombre()+"','"+nuevo.getDireccion()+"','"+nuevo.getCiudad()+"');");
            
            return state.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.print("Ha Ocurrido un Error: "+ex.getMessage());
            return 0;
        }
        
    }
    
    public static int actualizar_datos(Bodega nuevo) {
        try {
            SQLconexion coneccion=new SQLconexion();
            Connection con=coneccion.getConect();
            PreparedStatement state=con.prepareStatement("update bodega set nombrebod='"+nuevo.getNombre()+"', direccion='"+nuevo.getDireccion()+"', ciudad='"+nuevo.getCiudad()+"' where cod_bod='"+nuevo.getRuc()+"';");
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
            PreparedStatement state=con.prepareStatement("delete from bodega where cod_bod='"+text+"';");
            
            return state.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.print("Ha Ocurrido un Error: "+ex.getMessage());
            return 0;
        }
    }

    @Override
    public String toString() {
        return nombre;
    }
}
