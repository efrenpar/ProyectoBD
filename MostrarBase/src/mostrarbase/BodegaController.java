/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mostrarbase;

import com.mysql.jdbc.Connection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Israel
 */
public class BodegaController implements Initializable {
    
        
    @FXML
    private TableView<Bodega> tableview;
    
    @FXML
    private TableColumn<Bodega,SimpleStringProperty>cod_BodegaColumn ;
    
    @FXML
    private TableColumn<Bodega,SimpleStringProperty>nombreBodColumn ;
    
    @FXML
    private TableColumn<Bodega,SimpleStringProperty>direccionColumn;
    
    @FXML
    private TableColumn<Bodega,SimpleStringProperty>ciudadColumn ;
    
    
    @FXML
    private void mostrarBodegas(){
    
        this.tableview.setItems(getbodegas());
    }
    
    @FXML
    private void salir(){
    
        System.exit(0);
    }

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        cod_BodegaColumn.setCellValueFactory(new PropertyValueFactory<Bodega,SimpleStringProperty>("cod_bod"));
        nombreBodColumn.setCellValueFactory(new PropertyValueFactory<Bodega,SimpleStringProperty>("nombre_bod"));
        direccionColumn.setCellValueFactory(new PropertyValueFactory<Bodega,SimpleStringProperty>("direccion"));
        ciudadColumn.setCellValueFactory(new PropertyValueFactory<Bodega,SimpleStringProperty>("ciudad"));
        // TODO
    } 
    
     
    public ObservableList<Bodega>getbodegas(){
            ObservableList<Bodega> bodegas = FXCollections.observableArrayList();
            
            try {
            
            Conexion cnx = new Conexion();
            ResultSet rs ;
            Connection registro = (Connection) cnx.conexion();
            String sql = "SELECT * FROM bodega";
            PreparedStatement pst = (PreparedStatement)registro.clientPrepareStatement(sql);
             rs = pst.executeQuery();
             while (rs.next()) {
                 Bodega b = new Bodega();
                 b.setCod_bod(new SimpleStringProperty(rs.getString(1)));
                 b.setNombre_bod(new SimpleStringProperty(rs.getString(2)));
                 b.setDireccion(new SimpleStringProperty(rs.getString(3)));
                 b.setCiudad(new SimpleStringProperty(rs.getString(4)));
                 //System.out.println(rs.getString(4));
                 bodegas.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return bodegas;
    
        
    
    }
    
}
