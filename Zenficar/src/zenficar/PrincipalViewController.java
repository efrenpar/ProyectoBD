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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author Leon
 */
public class PrincipalViewController implements Initializable{

    @FXML private Button btnfac,btnpyc,btnprov,btnclie,btncyf;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    
    @FXML
    public void Factura(ActionEvent event) {
        try {
            Stage stage = (Stage) btnfac.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Facturas.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(PrincipalViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void Clientela(ActionEvent event) 
    {
        try {
            Stage stage = (Stage) btnclie.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Clientes.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(PrincipalViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    public void Proveedores(ActionEvent event) 
    {
        try {
            Stage stage = (Stage) btnprov.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Proveedor.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(PrincipalViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    public void Contabilidad(ActionEvent event) 
    {
        
        try {
            Stage stage = (Stage) btncyf.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Contabilidad.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(PrincipalViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    public void Propiedades(ActionEvent event) 
    {
        
        try {
            Stage stage = (Stage) btnpyc.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Propiedades.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(PrincipalViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
