/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Leon
 */
public class SQLConeccion 
{
    private Connection con=null;
    private final String driver="com.mysql.jdbc.Driver";
    private final String user="root";
    private final String pass="sonrisita";
    private final String url="jdbc:mysql://localhost:3306/zenficar";
    
    public SQLConeccion() 
    {
        try{
            Class.forName(driver);
            con= DriverManager.getConnection(url, user, pass);
        }catch(SQLException ex) {
            System.out.print("Conexcion no establecida por: "+ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLConeccion.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public Connection getConect()
    {
        return this.con;
    }
    
    public void cerrarConect()
    {
        try {
            this.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SQLConeccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
