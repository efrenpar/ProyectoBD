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
public class Vendedor {
    // 
    private String codigo, nombre, direccion, ciudad;
    private double comision;

    public Vendedor(String codigo, String nombre, String direccion, String ciudad, double comision) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.comision = comision;
    }

    public String getCodigo() {
        return codigo;
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

    public double getComision() {
        return comision;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public void setComision(double comision) {
        this.comision = comision;
    }
    
    
    
    public static void LlenarInformacion(ObservableList<Vendedor> lista) {
        try {
            SQLconexion coneccion=new SQLconexion();
            Connection con=coneccion.getConect();
            Statement st=con.createStatement();
            ResultSet resultado=st.executeQuery("select idVendedor, nombre_v, direccion, ciudad, comision  from vendedor;");
            
            while(resultado.next()) {
                lista.add(new Vendedor(resultado.getString("idVendedor"),
                        resultado.getString("nombre_v"),
                        resultado.getString("direccion"),
                        resultado.getString("ciudad"),
                        resultado.getFloat("comision")));
            }
                
            coneccion.cerrarConect();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int Ingresar_datos(Vendedor nuevo) {
        try {
            SQLconexion coneccion=new SQLconexion();
            Connection con=coneccion.getConect();
            PreparedStatement state=con.prepareStatement("insert into Vendedor(idVendedor,nombre_v,direccion,ciudad,comision) values ('"+nuevo.getCodigo()+"','"+nuevo.getNombre()+"','"+nuevo.getDireccion()+"','"+nuevo.getCiudad()+"',"+nuevo.getComision()+");");
            
            return state.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.print("Ha Ocurrido un Error: "+ex.getMessage());
            return 0;
        }
        
    }
    
    public static int actualizar_datos(Vendedor nuevo) {
        try {
            SQLconexion coneccion=new SQLconexion();
            Connection con=coneccion.getConect();
            PreparedStatement state=con.prepareStatement("update vendedor set nombre_v='"+nuevo.getNombre()+"', direccion='"+nuevo.getDireccion()+"', ciudad='"+nuevo.getCiudad()+"', comision="+nuevo.getComision()+" where idVendedor='"+nuevo.getCodigo()+"';");
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
            PreparedStatement state=con.prepareStatement("delete from vendedor where idVendedor='"+text+"';");
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
