/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mostrarbase;


import java.net.URL;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Israel
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private TableView<Persona> tableview;
    @FXML
    private TableColumn<Persona,SimpleStringProperty> ruc;
    
    @FXML
    private TableColumn<Persona,SimpleStringProperty> contacto;
    
    @FXML
    private TableColumn<Persona,SimpleStringProperty> razonSocial;
    
    @FXML
    private TableColumn<Persona,SimpleStringProperty> direccion;
    
    @FXML
    private TableColumn<Persona,SimpleStringProperty> ciudad;
    
    
    
   
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("muestro clientes");
         tableview.setItems(getPersonas());
        
    }
    @FXML
    private void cambiarVentana(ActionEvent event){
    
        System.out.println("cambio de ventana");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ruc.setCellValueFactory(new PropertyValueFactory<Persona,SimpleStringProperty>("ruc"));
        razonSocial.setCellValueFactory(new PropertyValueFactory<Persona,SimpleStringProperty>("razonSocial"));
//        contacto.setCellValueFactory(new PropertyValueFactory<Persona,SimpleStringProperty>("contacto"));
        direccion.setCellValueFactory(new PropertyValueFactory<Persona,SimpleStringProperty>("direccion"));
        ciudad.setCellValueFactory(new PropertyValueFactory<Persona,SimpleStringProperty>("ciudad"));
        
       
    }    
    
    
    public ObservableList<Persona> getPersonas(){
        
        ObservableList<Persona> personas = FXCollections.observableArrayList();
    
        try {
            
            Conexion cnx = new Conexion();
            ResultSet rs ;
            Connection registro = (Connection) cnx.conexion();
            String sql = "SELECT * FROM CLIENTE";
            PreparedStatement pst = (PreparedStatement)registro.clientPrepareStatement(sql);
             rs = pst.executeQuery();
             while (rs.next()) {
                 Persona p = new Persona();
                 p.setRuc(new SimpleStringProperty(rs.getString(1)));
                 p.setRazonSocial(new SimpleStringProperty(rs.getString(2)));
                 p.setDireccion(new SimpleStringProperty(rs.getString(3)));
                // p.setContaco(new SimpleStringProperty(rs.getString(4)));
                 p.setCiudad(new SimpleStringProperty(rs.getString(5)));
                 personas.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personas;
    }
    
}
