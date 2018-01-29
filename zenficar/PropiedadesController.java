/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zenficar;

import Controladores.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Leon
 */
public class PropiedadesController implements Initializable
{
    // seccion encargada de los combobox
    @FXML private Button btnback;
    @FXML private ComboBox<Categoria> cmbCategoria1;
    @FXML private ComboBox<Proveedor> cmbProveedor1;
    @FXML private ComboBox<Bodega> cmbBodega1;
    @FXML private ComboBox<Empleado> cmbPertenencia;
    @FXML private ComboBox cmbTipo1,cmbCargo,cmbComision;
    
    // seccion encargada de los TableView
    @FXML private TableView tbViewProductos,tbViewCategorias,tbViewBodegas,tbViewEmpleados,tbViewVendedores;
    
    // seccion de las TextField
    @FXML private TextField pro_tf_codigo,pro_tf_nombre,pro_tf_desc,pro_tf_venta,pro_tf_compra,pro_tf_cantidad;
    @FXML private TextField cat_tf_nombre, cat_tf_codigo;
    @FXML private TextField bod_tf_codigo,bod_tf_nombre,bod_tf_desc,bod_tf_ciudad;
    @FXML private TextField emp_tf_dir,emp_tf_nombre,emp_tf_cedula,emp_tf_sueldo;
    @FXML private TextField user_tf_user;
    @FXML private PasswordField user_tf_pas,user_tf_pasconf;
    @FXML private TextField ven_tf_ciudad,ven_tf_dir,ven_tf_nombre,ven_tf_codigo;
            
    //seccion de botones
    @FXML private Button btnsave1,btnsave2,btnsave3,btnsave4,btnsave5,btnsave6;
    @FXML private Button btnactualizar1,btnactualizar2,btnactualizar3,btnactualizar4,btnactualizar6;
    @FXML private Button btneliminar1,btneliminar2,btneliminar3,btneliminar4,btneliminar6;
    @FXML private Button btnlimpiar5;
    
    
    private ObservableList<Categoria> listaCategoria;
    private ObservableList<Proveedor> listaProveedor;
    private ObservableList<Bodega> listaBodega;
    private ObservableList<Empleado> listaEmpleado;
    private ObservableList listaTipo, listaCargo, listaComision;
    private ObservableList<Productos> listaProductos;
    private ObservableList<Vendedor> listaVendedor;
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        // datos para el ComboBox de tipo dentro de productos
        listaTipo = FXCollections.observableArrayList();
        listaTipo.add("Unidad");
        listaTipo.add("Par");
        listaTipo.add("Docena");
        listaTipo.add("Caja");
        listaTipo.add("Empaque");
        cmbTipo1.setItems(listaTipo);
        cmbTipo1.getSelectionModel().select(0);
        
        listaCategoria=FXCollections.observableArrayList();
        Categoria.ParaComboBox(listaCategoria);
        cmbCategoria1.setItems(listaCategoria);
        cmbCategoria1.getSelectionModel().select(0);
        
        listaProveedor=FXCollections.observableArrayList();
        Proveedor.ParaComboBox(listaProveedor);
        this.cmbProveedor1.setItems(listaProveedor);
        this.cmbProveedor1.getSelectionModel().select(0);
        
        this.listaBodega=FXCollections.observableArrayList();
        Bodega.ParaComboBox(listaBodega);
        this.cmbBodega1.setItems(listaBodega);
        this.cmbBodega1.getSelectionModel().select(0);
        
        listaCargo= FXCollections.observableArrayList();
        listaCargo.add("Secretaria");
        listaCargo.add("Repartidor");
        listaCargo.add("Bodega");
        listaCargo.add("Contador");
        listaCargo.add("Gerente");
        listaCargo.add("Presidente");
        cmbCargo.setItems(listaCargo);
        cmbCargo.getSelectionModel().select(0);
        
        listaComision = FXCollections.observableArrayList();
        listaComision.add(" 05 % ");
        listaComision.add(" 07 % ");
        listaComision.add(" 09 % ");
        listaComision.add(" 10 % ");
        listaComision.add(" 11 % ");
        listaComision.add(" 12 % ");
        listaComision.add(" 13 % ");
        listaComision.add(" 14 % ");
        listaComision.add(" 15 % ");
        this.cmbComision.setItems(listaComision);
        this.cmbComision.getSelectionModel().select(0);
        
        this.listaEmpleado=FXCollections.observableArrayList();
        Empleado.ParaComboBox(listaEmpleado);
        this.cmbPertenencia.setItems(listaEmpleado);
        this.cmbPertenencia.getSelectionModel().select(0);
        
        listaProductos=FXCollections.observableArrayList();
        Productos.llenarInformacion(listaProductos);
        TableViewControlador.tbViewProductos(tbViewProductos, listaProductos);
        
        TableViewControlador.tbViewCategorias(this.tbViewCategorias, this.listaCategoria);
        TableViewControlador.tbViewBodegas(this.tbViewBodegas, this.listaBodega);
        TableViewControlador.tbViewEmpleados(this.tbViewEmpleados,this.listaEmpleado);
        
        this.listaVendedor=FXCollections.observableArrayList();
        Vendedor.LlenarInformacion(listaVendedor);
        TableViewControlador.tbViewVendedores(this.tbViewVendedores,this.listaVendedor);
        
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
    
    public void Gestionador_TableProductos(){
        
        this.btnactualizar1.setDisable(false);
        this.btneliminar1.setDisable(false);
        this.tbViewProductos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Productos>(){
            @Override
            public void changed(ObservableValue<? extends Productos> observable, Productos oldValue, Productos newValue) {
                
                pro_tf_codigo.setText(newValue.getCodigo());
                pro_tf_codigo.setDisable(true);
                pro_tf_nombre.setText(newValue.getNombre());
                pro_tf_desc.setText(newValue.getDescripcion());
                pro_tf_venta.setText(Double.toString(newValue.getPrecio_venta()));
                pro_tf_compra.setText(Double.toString(newValue.getPrecio_compra()));
                pro_tf_cantidad.setText(Integer.toString(newValue.getCantidad()));
                cmbTipo1.setValue(newValue.getTipo());
                
                Categoria cataux=null;
                for(Categoria x:listaCategoria){
                    if(x.getCodigo().equals(newValue.getCategoria()))
                        cataux=x;
                }
                
                Proveedor proaux=null;
                for(Proveedor x:listaProveedor) {
                    if(x.getRuc().equals(newValue.getProveedor()))
                        proaux=x;
                }
                
                Bodega bodaux=null;
                for(Bodega x:listaBodega) {
                    if(x.getRuc().equals(newValue.getBodega()))
                        bodaux=x;
                }
                    
                cmbCategoria1.getSelectionModel().select(cataux);    
                cmbProveedor1.getSelectionModel().select(proaux);
                cmbBodega1.getSelectionModel().select(bodaux);  
            }
        });
    }
    
    public void Gestionador_TableCategoria(){
        this.btnactualizar2.setDisable(false);
        this.btneliminar2.setDisable(false);
        this.tbViewCategorias.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Categoria>(){
            @Override
            public void changed(ObservableValue<? extends Categoria> observable, Categoria oldValue, Categoria newValue) {
                cat_tf_nombre.setText(newValue.getNombre());
                cat_tf_codigo.setText(newValue.getCodigo());
                cat_tf_codigo.setDisable(true);
            }
        });
    }
    
    public void Gestionador_Bodegas(){
        this.btnactualizar3.setDisable(false);
        this.btneliminar3.setDisable(false);
        this.tbViewBodegas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Bodega>(){
            @Override
            public void changed(ObservableValue<? extends Bodega> observable, Bodega oldValue, Bodega newValue) {
                bod_tf_codigo.setText(newValue.getRuc());
                bod_tf_codigo.setDisable(true);
                bod_tf_nombre.setText(newValue.getNombre());
                bod_tf_desc.setText(newValue.getDireccion());
                bod_tf_ciudad.setText(newValue.getCiudad());
            }
        });
    }
    
    public void Gestionador_Empleados() {
        this.btnactualizar4.setDisable(false);
        this.btneliminar4.setDisable(false);
        this.tbViewEmpleados.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Empleado>() {
            @Override
            public void changed(ObservableValue<? extends Empleado> observable, Empleado oldValue, Empleado newValue) {
                emp_tf_dir.setText(newValue.getDireccion());
                emp_tf_nombre.setText(newValue.getNombre());
                emp_tf_cedula.setText(newValue.getCedula());
                emp_tf_cedula.setDisable(true);
                emp_tf_sueldo.setText(Double.toString(newValue.getSueldo()));
                cmbCargo.getSelectionModel().select(newValue.getCargo());
            }
        }); 
    }
    
    public void Gestionador_Vendedor() {
        this.btnactualizar6.setDisable(false);
        this.btneliminar6.setDisable(false);
        this.tbViewVendedores.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Vendedor>() {
            @Override
            public void changed(ObservableValue<? extends Vendedor> observable, Vendedor oldValue, Vendedor newValue) {
                ven_tf_ciudad.setText(newValue.getCiudad());
                ven_tf_dir.setText(newValue.getDireccion());
                ven_tf_nombre.setText(newValue.getNombre());
                ven_tf_codigo.setText(newValue.getCodigo());
                ven_tf_codigo.setDisable(true);
                String aux=" "+Double.toString(newValue.getComision())+" %";
                cmbComision.getSelectionModel().select(aux);
            }
        }); 
    }
    
    public void Boton_save_Products() {
        
        Productos nuevo=new Productos(pro_tf_codigo.getText(),
                                        pro_tf_nombre.getText(),
                                        pro_tf_desc.getText(),
                                        Double.parseDouble(pro_tf_compra.getText()),
                                        Double.parseDouble(pro_tf_venta.getText()),
                                        Integer.parseInt(pro_tf_cantidad.getText()),
                                        cmbTipo1.getValue().toString(),
                                        cmbCategoria1.getValue().getCodigo(),
                                        cmbBodega1.getValue().getRuc(),
                                        cmbProveedor1.getValue().getRuc());
       
        if(Productos.Ingresar_datos(nuevo)==1) {
            this.listaProductos.add(nuevo);
            mensaje_agregado();
        }
        
        
    }
    
    public void Boton_save_Categoria() {
        Categoria nuevo=new Categoria(cat_tf_codigo.getText(),cat_tf_nombre.getText());
        
        if(Categoria.Ingresar_datos(nuevo)==1) {
            this.listaCategoria.add(nuevo);
            mensaje_agregado();
        }
        
    }
    
    public void Boton_save_Bodegas() {
        
        Bodega nuevo=new Bodega(bod_tf_codigo.getText(),bod_tf_nombre.getText(),bod_tf_desc.getText(),bod_tf_ciudad.getText());
        if(Bodega.Ingresar_datos(nuevo)==1) {
            this.listaBodega.add(nuevo);
             mensaje_agregado();
        }
    }
    
     public void Boton_save_Empleados() {
         //(String cedula, String nombre, String direccion, String cargo, double sueldo) 
        Empleado nuevo=new Empleado(emp_tf_cedula.getText(),emp_tf_nombre.getText(),emp_tf_dir.getText(),cmbCargo.getValue().toString(),Double.parseDouble(emp_tf_sueldo.getText()));
        if(Empleado.Ingresar_datos(nuevo)==1) {
            this.listaEmpleado.add(nuevo);
             mensaje_agregado();
        }
         
    }
    
    public void Boton_save_Usuarios() {
        if(user_tf_pas.getText().equals(user_tf_pasconf.getText())){
            
            Usuario nuevo=new Usuario(user_tf_user.getText(),user_tf_pas.getText(),this.cmbPertenencia.getValue().getCedula());
            
            if(Usuario.Ingresar_datos(nuevo)==1) {
                Alert mensaje=new Alert(AlertType.INFORMATION);
                mensaje_agregado();
            }
        }

        
    }
    
    public void Boton_save_Vendedor() {
        //(String codigo, String nombre, String direccion, String ciudad, float comision)
        double aux=0;
        String index=cmbComision.getValue().toString();
        if(index.equals(" 05 % "))
            aux=0.05;
        if(index.equals(" 07 % "))
            aux=0.07;
        if(index.equals(" 09 % "))
            aux=0.09;
        if(index.equals(" 10 % "))
            aux=0.10;
        if(index.equals(" 11 % "))
            aux=0.11;
        if(index.equals(" 12 % "))
            aux=0.12;
        if(index.equals(" 13 % "))
            aux=0.13;
        if(index.equals(" 14 % "))
            aux=0.14;
        if(index.equals(" 15 % "))
            aux=0.15;
        
        Vendedor nuevo=new Vendedor(ven_tf_codigo.getText(),ven_tf_nombre.getText(),ven_tf_dir.getText(), ven_tf_ciudad.getText(),aux);
        
        if(Vendedor.Ingresar_datos(nuevo)==1) {
            this.listaVendedor.add(nuevo);
            mensaje_agregado();
           
        }
    }
    
    public void Boton_limpiar_Usuarios() {
        user_tf_user.clear();
        user_tf_pas.clear();
        user_tf_pasconf.clear();
        cmbPertenencia.getSelectionModel().selectFirst();
    }
        
    public void Boton_actualizar_Productos() {
        Productos nuevo=new Productos(pro_tf_codigo.getText(),
                                        pro_tf_nombre.getText(),
                                        pro_tf_desc.getText(),
                                        Double.parseDouble(pro_tf_compra.getText()),
                                        Double.parseDouble(pro_tf_venta.getText()),
                                        Integer.parseInt(pro_tf_cantidad.getText()),
                                        cmbTipo1.getValue().toString(),
                                        cmbCategoria1.getValue().getCodigo(),
                                        cmbBodega1.getValue().getRuc(),
                                        cmbProveedor1.getValue().getRuc());
       
        if(Productos.actualizar_datos(nuevo)==1) {
            this.listaProductos.set(this.tbViewProductos.getSelectionModel().getSelectedIndex(),nuevo);
            mensaje_actualizado();
        }
        
    }
    
    public void Boton_actualizar_Categoria() {
        Categoria nuevo=new Categoria(cat_tf_codigo.getText(),cat_tf_nombre.getText());
        
        if(Categoria.actualizar_datos(nuevo)==1) {
            this.listaCategoria.set(this.tbViewCategorias.getSelectionModel().getSelectedIndex(), nuevo);
            mensaje_actualizado();
        }
        
        
        
    }
    public void Boton_actualizar_Bodega() {
        Bodega nuevo=new Bodega(bod_tf_codigo.getText(),bod_tf_nombre.getText(),bod_tf_desc.getText(),bod_tf_ciudad.getText());
        if(Bodega.actualizar_datos(nuevo)==1) {
            this.listaBodega.set(this.tbViewBodegas.getSelectionModel().getSelectedIndex(), nuevo);
            mensaje_actualizado();  
        }
        
    }
    public void Boton_actualizar_Empleado() {
        Empleado nuevo=new Empleado(emp_tf_cedula.getText(),emp_tf_nombre.getText(),emp_tf_dir.getText(),cmbCargo.getValue().toString(),Double.parseDouble(emp_tf_sueldo.getText()));
        if(Empleado.actualizar_datos(nuevo)==1) {
            this.listaEmpleado.set(this.tbViewEmpleados.getSelectionModel().getSelectedIndex(), nuevo);
            mensaje_actualizado();
        }
        
    }
    public void Boton_actualizar_Vendedor() {
        double aux=0;
        String index=cmbComision.getValue().toString();
        if(index.equals(" 05 % "))
            aux=0.05;
        if(index.equals(" 07 % "))
            aux=0.07;
        if(index.equals(" 09 % "))
            aux=0.09;
        if(index.equals(" 10 % "))
            aux=0.10;
        if(index.equals(" 11 % "))
            aux=0.11;
        if(index.equals(" 12 % "))
            aux=0.12;
        if(index.equals(" 13 % "))
            aux=0.13;
        if(index.equals(" 14 % "))
            aux=0.14;
        if(index.equals(" 15 % "))
            aux=0.15;
        
        Vendedor nuevo=new Vendedor(ven_tf_codigo.getText(),ven_tf_nombre.getText(),ven_tf_dir.getText(), ven_tf_ciudad.getText(),aux);
        
        if(Vendedor.actualizar_datos(nuevo)==1) {
            this.listaVendedor.set(this.tbViewVendedores.getSelectionModel().getSelectedIndex(), nuevo);
            mensaje_actualizado();
           
        }
        
    }
        

    public void Boton_eliminar_Productos() {
        if(Productos.elimiar_datos(pro_tf_codigo.getText())==1) {
            this.listaProductos.remove(this.tbViewProductos.getSelectionModel().getSelectedIndex());
            mensaje_eliminado();
        }

    }
    
    public void Boton_eliminar_Categoria() {
        if(Categoria.elimiar_datos(cat_tf_codigo.getText())==1) {
            this.listaCategoria.remove(this.tbViewCategorias.getSelectionModel().getSelectedIndex());
             mensaje_eliminado();
        }
        
    }
    public void Boton_eliminar_Bodega() {
        if(Bodega.elimiar_datos(bod_tf_codigo.getText())==1) {
            this.listaBodega.remove(this.tbViewBodegas.getSelectionModel().getSelectedIndex());
             mensaje_eliminado();
        }
        
    }
    public void Boton_eliminar_Empleado() {
        if(Empleado.elimiar_datos(emp_tf_cedula.getText())==1) {
            this.listaEmpleado.remove(this.tbViewEmpleados.getSelectionModel().getSelectedIndex());
             mensaje_eliminado();
        }
        
    }
    public void Boton_eliminar_Vendedor() {
        if(Vendedor.elimiar_datos(ven_tf_codigo.getText())==1) {
            this.listaVendedor.remove(this.tbViewVendedores.getSelectionModel().getSelectedIndex());
            mensaje_eliminado();
        }
        
    }
    
    public void mensaje_actualizado() {
        Alert mensaje=new Alert(AlertType.INFORMATION);
        mensaje.setTitle("Registro Actualizado");
        mensaje.setContentText("El registro ha sido Actualizado Exitosamente");
        mensaje.setHeaderText("Resultado:");
        mensaje.show();  
    }
    
    public void mensaje_agregado() {
        Alert mensaje=new Alert(AlertType.INFORMATION);
        mensaje.setTitle("Registro Agregado");
        mensaje.setContentText("El registro ha sido agregado Exitosamente");
        mensaje.setHeaderText("Resultado:");
        mensaje.show();
    }
    
    public void mensaje_eliminado() {
        Alert mensaje=new Alert(AlertType.INFORMATION);
        mensaje.setTitle("Registro Eliminado");
        mensaje.setContentText("El registro ha sido Elimando Correctametne");
        mensaje.setHeaderText("Resultado:");
        mensaje.show();
        
    }
    
    
}