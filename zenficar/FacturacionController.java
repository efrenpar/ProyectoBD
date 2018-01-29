/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zenficar;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Leon
 */
public class FacturacionController implements Initializable
{
    @FXML private Button btnback;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    

   
    
    @FXML
    public void Main_Menu()
    {
        try {
            Stage stage = (Stage) btnback.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("PrincipalView.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(PrincipalViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
