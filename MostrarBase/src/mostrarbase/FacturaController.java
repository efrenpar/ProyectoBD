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
public class FacturaController implements Initializable {
    
    @FXML
    private TableView<Factura> tableview;
    
    @FXML
    private TableColumn<Factura,SimpleStringProperty>facturaNoColumn ;
    
    @FXML
    private TableColumn<Factura,SimpleStringProperty>NClienteColumn ;
    
    @FXML
    private TableColumn<Factura,SimpleStringProperty>FechaDeEmisionColumn;
    
    @FXML
    private TableColumn<Factura,SimpleStringProperty>TotalColumn ;
    
    
    @FXML
    private void  salir(){
    
        System.exit(0);
    }
    
    @FXML
    private void mostrarFacturas(){
    
        this.tableview.setItems(getfacturas());
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        facturaNoColumn.setCellValueFactory(new PropertyValueFactory<Factura,SimpleStringProperty>("fact_no"));
        NClienteColumn.setCellValueFactory(new PropertyValueFactory<Factura,SimpleStringProperty>("nombre_cliente"));
        FechaDeEmisionColumn.setCellValueFactory(new PropertyValueFactory<Factura,SimpleStringProperty>("fecha_emision"));
        TotalColumn.setCellValueFactory(new PropertyValueFactory<Factura,SimpleStringProperty>("total"));
        
    }    
    
    
    public ObservableList<Factura>getfacturas(){
            ObservableList<Factura> facturas = FXCollections.observableArrayList();
            
            try {
            
            Conexion cnx = new Conexion();
            ResultSet rs ;
            Connection registro = (Connection) cnx.conexion();
            String sql = "SELECT * FROM factura";
            PreparedStatement pst = (PreparedStatement)registro.clientPrepareStatement(sql);
             rs = pst.executeQuery();
             while (rs.next()) {
                 Factura f = new Factura();
                 f.setFact_no(new SimpleStringProperty(rs.getString(1)));
                 f.setNombre_cliente(new SimpleStringProperty(rs.getString(2)));
                 f.setFecha_emision(new SimpleStringProperty(rs.getDate(5).toString()));
                 f.setTotal(new SimpleStringProperty(String.valueOf(rs.getDouble(10))));
                 //System.out.println(rs.getString(4));
                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return facturas;
    
        
    
    }
    
}
