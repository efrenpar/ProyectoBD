/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Conexion.SQLconexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Leon
 */
public class Usuario {
    private String user, pass, perteneciente;

    public Usuario(String user, String pass, String perteneciente) {
        this.user = user;
        this.pass = pass;
        this.perteneciente = perteneciente;
  
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getPerteneciente() {
        return perteneciente;
    }
    

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setPerteneciente(String perteneciente) {
        this.perteneciente = perteneciente;
    }
    
    public static int Ingresar_datos(Usuario nuevo) {
        try {
            SQLconexion coneccion=new SQLconexion();
            Connection con=coneccion.getConect();
            PreparedStatement state=con.prepareStatement("insert into Cuenta values (0,'"+nuevo.getUser()+"','"+nuevo.getPass()+"','"+nuevo.getPerteneciente()+"');");
            
            return state.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.print("Ha Ocurrido un Error: "+ex.getMessage());
            return 0;
        }
        
    }
}
