/*
 *con esta clase me conectare a la base de datos
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Leonidas
 */
public class SQLconexion 
{    
    private Connection con=null;
    private final String driver="com.mysql.jdbc.Driver";
    private final String user="root";
    private final String pass="sonrisita";
    private final String url="jdbc:mysql://localhost:3306/zenficar";
    
    public SQLconexion() 
    {
        try{
            Class.forName(driver);
            con= DriverManager.getConnection(url, user, pass);
        }catch(SQLException ex) {
            System.out.print("Conexcion no establecida por: "+ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLconexion.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SQLconexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
