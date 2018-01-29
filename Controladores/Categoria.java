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
public class Categoria {

    private String codigo,nombre;
    
    public Categoria(String codigo, String Nombre) {
        this.codigo=codigo;
        this.nombre=Nombre;
    }

    // seccion de getters
    
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
    
    // seccion de setters

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public static void ParaComboBox(ObservableList<Categoria> lista) {
        try {
            SQLconexion coneccion=new SQLconexion();
            Connection con=coneccion.getConect();
            Statement st=con.createStatement();
            ResultSet resultado=st.executeQuery("select cod_categ,nombretipo from categoria;");
            
            while(resultado.next()) {
                lista.add(new Categoria(resultado.getString("cod_categ"),resultado.getString("nombretipo")));
            }
                
            coneccion.cerrarConect();
            con.close();
            
        } catch (SQLException ex) {
            System.out.print("Ha Ocurrido un Error: "+ex.getMessage());
        }
    }
    
    public static int Ingresar_datos(Categoria nuevo) {
        try {
            SQLconexion coneccion=new SQLconexion();
            Connection con=coneccion.getConect();
            PreparedStatement state=con.prepareStatement("insert into Categoria(cod_categ,nombretipo) values ('"+nuevo.getCodigo()+"','"+nuevo.getNombre()+"');");
            
            return state.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.print("Ha Ocurrido un Error: "+ex.getMessage());
            return 0;
        }
        
    }
    
    public static int actualizar_datos(Categoria nuevo) {
        try {
            SQLconexion coneccion=new SQLconexion();
            Connection con=coneccion.getConect();
            PreparedStatement state=con.prepareStatement("update categoria set nombretipo='"+nuevo.getNombre()+"' where cod_categ='"+nuevo.getCodigo()+"';");
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
            PreparedStatement state=con.prepareStatement("delete from categoria where cod_categ='"+text+"';");
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
