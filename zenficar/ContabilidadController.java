/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zenficar;

import Contabilidad.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Leon
 */
public class ContabilidadController implements Initializable
{
    @FXML private Button btnback;
    
    @FXML private Button btn_lupa1, btn_aceptar1, btn_cancelar1;
    @FXML private Button btn_busqueda_cxc;
    
    @FXML private TextField tf_fac, tf_valor_pagar;
    @FXML private TextField tf_busqueda_cxc;
    
    @FXML private DatePicker dateruner;
    
    @FXML private TableView tbViewAbono;
    @FXML private TableView tbViewCuentasXcobrar;
    
    @FXML private ComboBox cmbcxc,cmbcxp,cmbcomisiones;
    private ObservableList listacobro, listapagos, listaComision;
   
    private ObservableList<Cuenta_x_cobrar> listaCuentaCobrar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listaCuentaCobrar=FXCollections.observableArrayList();
        TableViewControladorContabilidad.tbViewAbono(tbViewAbono, listaCuentaCobrar);
        
        listacobro=FXCollections.observableArrayList();
        TableViewControladorContabilidad.tbViewAbono(tbViewCuentasXcobrar,listacobro);
        
        listacobro = FXCollections.observableArrayList();
        listacobro.add("Todos");
        listacobro.add("Cliente");
        listacobro.add("Factura");
        cmbcxc.setItems(listacobro);
        cmbcxc.getSelectionModel().select(0);
        
        listapagos= FXCollections.observableArrayList();
        listapagos.add("Todos");
        listapagos.add("pedido");
        listapagos.add("banco");
        listapagos.add("codigo");
        cmbcxp.setItems(listapagos);
        cmbcxp.getSelectionModel().select(0);
        
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
    
    // toda la seccion de abonos
    public void Cargar_Abono(){
        
        String factura="select codigo_cc,valor,saldo,cliente_no,fact_no from cuentas_x_cobrar where fact_no='"+this.tf_fac.getText()+"';";
        Cuenta_x_cobrar.LlenarInformacion(listaCuentaCobrar, factura);
    }
    
    public void btn_aceptar1() {
        Cuenta_x_cobrar cuenta=listaCuentaCobrar.get(0);
        LocalDate date=dateruner.getValue();
        Date fecha=(Date) Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        double valor=Double.parseDouble(this.tf_valor_pagar.getText());
        if(valor>0 && valor<cuenta.getSaldo()) {
            Abono nuevo=new Abono(cuenta.getCodigo(),valor,fecha);
            if(Abono.Ingresar_datos(nuevo)==1) {
                mensaje_agregado();
            }    
        }else {
            mensaje_error();
        }
    }
    
    public void btn_cancelar1() {
        this.tf_fac.clear();
        this.tf_valor_pagar.clear();
        this.listaCuentaCobrar.clear();
        this.dateruner.setValue(LocalDate.now());
    }
    
    //toda la seccion de cuentas x cobrar
    public void btn_busqueda_cxc() {
        String index=cmbcxc.getValue().toString();
        String busqeuda=this.tf_busqueda_cxc.getText();
        String querty="";
        
        if(index.equals("Todos")){
            querty="select codigo_cc,valor,saldo,cliente_no,fact_no from cuentas_x_cobrar;";
        }
        
        if(index.equals("Cliente")) {
            querty="select codigo_cc,valor,saldo,cliente_no,fact_no from cuentas_x_cobrar where cliente_no='"+busqeuda+"';";
        }
        
        if(index.equals("Factura")) {
            querty="select codigo_cc,valor,saldo,cliente_no,fact_no from cuentas_x_cobrar where fact_no='"+busqeuda+"';";
        }
            
        Cuenta_x_cobrar.LlenarInformacion(this.listacobro, querty);
    }
    
    
    public void mensaje_agregado() {
        Alert mensaje=new Alert(Alert.AlertType.INFORMATION);
        mensaje.setTitle("Registro Agregado");
        mensaje.setContentText("El registro ha sido agregado Exitosamente");
        mensaje.setHeaderText("Resultado:");
        mensaje.show();
    }
     
    public void mensaje_error() {
        Alert mensaje=new Alert(Alert.AlertType.ERROR);
        mensaje.setTitle("Error al Ingresar el Abono");
        mensaje.setContentText("El valor ingresado es mucho mayor al saldo de la deuda");
        mensaje.setHeaderText("Resultado:");
        mensaje.show();
    }
}
