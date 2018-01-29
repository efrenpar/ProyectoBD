/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zenficar;


import Conexion.SQLconexion;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;




/**
 *
 * @author Leon
 */
public class LoginController implements Initializable {
    
    @FXML private TextField tpss, tuser;
    @FXML private Button bcancel,bacep;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
    
    @FXML
    public void cerrar(ActionEvent event) {
        Stage stage = (Stage) bcancel.getScene().getWindow();
        stage.close();
    }
    
   
    @FXML
    public void Limpiar(ActionEvent event) {
            tpss.clear();
            tuser.clear();    
    }
    
    @FXML
    public void Aceptar(ActionEvent event) {
        
        String usuario=tuser.getText();
        String contrasena=tpss.getText();

        try {
            SQLconexion coneccion=new SQLconexion();
            Connection con=coneccion.getConect();
            Statement st=con.createStatement();
            ResultSet resultado=st.executeQuery("select usuario, pass from cuenta where usuario = '"+usuario+"'");
                
            while(resultado.next()){
                if(resultado.getString(1).equals(usuario)) {
                    if(resultado.getString(2).equals(contrasena)) {
                        Stage stage = (Stage) bacep.getScene().getWindow();
                        Parent root = FXMLLoader.load(getClass().getResource("PrincipalView.fxml"));
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                    }
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
}
