/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Leonidas
 */
public class TableViewControlador {
    
    public static void tbViewProductos(TableView tabla, ObservableList<Productos> lista) {
        
        TableColumn<Productos, String> codigo = new TableColumn<>("Codigo");
        codigo.setCellValueFactory(new PropertyValueFactory<Productos, String>("codigo"));

        TableColumn<Productos, String> nombre = new TableColumn<>("Nombre");
        nombre.setCellValueFactory(new PropertyValueFactory<Productos, String>("nombre"));

        TableColumn<Productos, String> descripcion = new TableColumn<>("Descripcion");
        descripcion.setCellValueFactory(new PropertyValueFactory<Productos, String>("descripcion"));

        TableColumn<Productos, Double> precio_compra = new TableColumn<>("P. Compra");
        precio_compra.setCellValueFactory(new PropertyValueFactory<Productos, Double>("precio_compra"));

        TableColumn<Productos, Double> precio_venta = new TableColumn<>("P. Venta");
        precio_venta.setCellValueFactory(new PropertyValueFactory<Productos, Double>("precio_venta"));

        TableColumn<Productos, Integer> cantidad = new TableColumn<>("Cantidad");
        cantidad.setCellValueFactory(new PropertyValueFactory<Productos, Integer>("cantidad"));

        TableColumn<Productos, String> tipo = new TableColumn<>("Tipo");
        tipo.setCellValueFactory(new PropertyValueFactory<Productos, String>("tipo"));

        TableColumn<Productos, String> categoria = new TableColumn<>("Categoria");
        categoria.setCellValueFactory(new PropertyValueFactory<Productos, String>("categoria"));

        TableColumn<Productos, String> bodega = new TableColumn<>("Bodega");
        bodega.setCellValueFactory(new PropertyValueFactory<Productos, String>("bodega"));

        TableColumn<Productos, String> proveedor = new TableColumn<>("Proveedor");
        proveedor.setCellValueFactory(new PropertyValueFactory<Productos, String>("proveedor"));

        tabla.getColumns().addAll(codigo, nombre, descripcion,precio_compra, precio_venta, cantidad,tipo, categoria, bodega, proveedor);
        tabla.setItems(lista);
    }
    
    public static void tbViewCategorias(TableView tabla, ObservableList<Categoria> lista) {
        
        TableColumn<Categoria, String> codigo = new TableColumn<>("Codigo");
        codigo.setCellValueFactory(new PropertyValueFactory<Categoria, String>("codigo"));

        TableColumn<Categoria, String> nombre = new TableColumn<>("Nombre");
        nombre.setCellValueFactory(new PropertyValueFactory<Categoria, String>("nombre"));
        
        tabla.getColumns().addAll(codigo, nombre);
        tabla.setItems(lista);
    }
    
    public static void tbViewBodegas(TableView tabla, ObservableList<Bodega> lista) {
   
        TableColumn<Bodega, String> ruc = new TableColumn<>("Ruc");
        ruc.setCellValueFactory(new PropertyValueFactory<Bodega, String>("ruc"));

        TableColumn<Bodega, String> nombre = new TableColumn<>("Nombre");
        nombre.setCellValueFactory(new PropertyValueFactory<Bodega, String>("nombre"));
        
        TableColumn<Bodega, String> direccion = new TableColumn<>("Direccion");
        direccion.setCellValueFactory(new PropertyValueFactory<Bodega, String>("direccion"));

        TableColumn<Bodega, String> ciudad = new TableColumn<>("Ciudad");
        ciudad.setCellValueFactory(new PropertyValueFactory<Bodega, String>("ciudad"));
        
        tabla.getColumns().addAll(ruc, nombre, direccion, ciudad);
        tabla.setItems(lista);
    
    }
    
    public static void tbViewEmpleados(TableView tabla, ObservableList<Empleado> lista) {
        
        TableColumn<Empleado, String> cedula = new TableColumn<>("Cedula");
        cedula.setCellValueFactory(new PropertyValueFactory<Empleado, String>("cedula"));

        TableColumn<Empleado, String> nombre = new TableColumn<>("Nombre");
        nombre.setCellValueFactory(new PropertyValueFactory<Empleado, String>("nombre"));

        TableColumn<Empleado, String> direccion = new TableColumn<>("Direccion");
        direccion.setCellValueFactory(new PropertyValueFactory<Empleado, String>("direccion"));

        TableColumn<Empleado, String> cargo = new TableColumn<>("Cargo");
        cargo.setCellValueFactory(new PropertyValueFactory<Empleado, String>("cargo"));

        TableColumn<Empleado, Double> sueldo = new TableColumn<>("Sueldo");
        sueldo.setCellValueFactory(new PropertyValueFactory<Empleado, Double>("sueldo"));

        tabla.getColumns().addAll(cedula,nombre,direccion,cargo,sueldo);
        tabla.setItems(lista);
        
    }
    
    public static void tbViewVendedores(TableView tabla, ObservableList<Vendedor> lista) {
      
        TableColumn<Vendedor, String> codigo = new TableColumn<>("ID");
        codigo.setCellValueFactory(new PropertyValueFactory<Vendedor, String>("codigo"));

        TableColumn<Vendedor, String> nombre = new TableColumn<>("Nombre");
        nombre.setCellValueFactory(new PropertyValueFactory<Vendedor, String>("nombre"));

        TableColumn<Vendedor, String> direccion = new TableColumn<>("Direccion");
        direccion.setCellValueFactory(new PropertyValueFactory<Vendedor, String>("direccion"));

        TableColumn<Vendedor, String> ciudad = new TableColumn<>("Ciudad");
        ciudad.setCellValueFactory(new PropertyValueFactory<Vendedor, String>("ciudad"));

        TableColumn<Vendedor, Double> comision = new TableColumn<>("% de Comision");
        comision.setCellValueFactory(new PropertyValueFactory<Vendedor, Double>("comision"));

        tabla.getColumns().addAll(codigo,nombre,direccion,ciudad,comision);
        tabla.setItems(lista);
        
    }
    
    
}

    
    

