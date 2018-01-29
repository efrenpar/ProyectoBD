/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contabilidad;

import Controladores.Productos;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Leonidas
 */
public class TableViewControladorContabilidad {
    
    public static void tbViewAbono(TableView tabla, ObservableList<Cuenta_x_cobrar> lista) {
               
        TableColumn<Cuenta_x_cobrar, Integer> codigo = new TableColumn<>("Codigo");
        codigo.setCellValueFactory(new PropertyValueFactory<Cuenta_x_cobrar, Integer>("codigo"));
       
        TableColumn<Cuenta_x_cobrar, Double> valor = new TableColumn<>("Valor");
        valor.setCellValueFactory(new PropertyValueFactory<Cuenta_x_cobrar, Double>("valor"));

        TableColumn<Cuenta_x_cobrar, Double> saldo = new TableColumn<>("Saldo");
        saldo.setCellValueFactory(new PropertyValueFactory<Cuenta_x_cobrar, Double>("saldo"));
         
        TableColumn<Cuenta_x_cobrar, String> cliente = new TableColumn<>("Cliente");
        cliente.setCellValueFactory(new PropertyValueFactory<Cuenta_x_cobrar, String>("cliente"));
        
        TableColumn<Cuenta_x_cobrar, String> factura = new TableColumn<>("Factura");
        factura.setCellValueFactory(new PropertyValueFactory<Cuenta_x_cobrar, String>("factura"));
        
        tabla.getColumns().addAll(codigo,valor,saldo,cliente,factura);
        tabla.setItems(lista);
    }
    
}
