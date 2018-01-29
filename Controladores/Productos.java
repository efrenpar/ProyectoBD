/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Conexion.SQLconexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author Leonidas
 */
public class Productos 
{
    private String codigo,nombre, descripcion;
    private double precio_compra, precio_venta;
    private int cantidad;
    private String tipo;
    private String categoria,bodega,proveedor;
    
    public Productos(String codigo, String nombre, String des, double compra, double venta, int cantidad, String tipo, String categ, String bodega, String pro)
    {
        this.codigo=codigo;
        this.nombre=nombre;
        this.descripcion=des;
        this.precio_compra=compra;
        this.precio_venta=venta;
        this.cantidad=cantidad;
        this.tipo=tipo;
        this.categoria=categ;
        this.bodega=bodega;
        this.proveedor=pro;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio_compra() {
        return precio_compra;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getBodega() {
        return bodega;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setBodega(String bodega) {
        this.bodega = bodega;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public static void  llenarInformacion(ObservableList<Productos> lista) {
        try {
            SQLconexion coneccion=new SQLconexion();
            Connection con=coneccion.getConect();
            Statement st=con.createStatement();
            ResultSet resultado=st.executeQuery("select cod_p,nombre,descripcion,precio_compra,precio_venta,cantidad,venta_x,categoria,bodegaNo,proveedor from producto;");
            
            while(resultado.next()) {
                
                lista.add(new Productos(resultado.getString("cod_p"),
                        resultado.getString("nombre"),
                        resultado.getString("descripcion"),
                        resultado.getDouble("precio_compra"),
                        resultado.getDouble("precio_venta"),
                        resultado.getInt("cantidad"),
                        resultado.getString("venta_x"),
                        resultado.getString("categoria"),
                        resultado.getString("bodegaNo"),
                        resultado.getString("proveedor")));
            }
                
            coneccion.cerrarConect();
            con.close();
            
        } catch (SQLException ex) {
            System.out.print("Ha Ocurrido un Error: "+ex.getMessage());
        }

    }
    
    public static int Ingresar_datos(Productos nuevo) {
        try {
            SQLconexion coneccion=new SQLconexion();
            Connection con=coneccion.getConect();
            PreparedStatement state=con.prepareStatement("insert into Producto(cod_p,nombre,descripcion,precio_compra,precio_venta,cantidad,venta_x,categoria,bodegaNo,proveedor) values ('"+nuevo.getCodigo()+"','"+nuevo.getNombre()+"','"+nuevo.getDescripcion()+"',"+nuevo.getPrecio_compra()+","+nuevo.getPrecio_venta()+","+nuevo.getCantidad()+",'"+nuevo.getTipo()+"','"+nuevo.getCategoria()+"','"+nuevo.getBodega()+"','"+nuevo.getProveedor()+"');");
            return state.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.print("Ha Ocurrido un Error: "+ex.getMessage());
            return 0;
        }
        
    }
    
    public static int actualizar_datos(Productos nuevo) {
        try {
            SQLconexion coneccion=new SQLconexion();
            Connection con=coneccion.getConect();
            PreparedStatement state=con.prepareStatement("update producto set nombre='"+nuevo.getNombre()+"', descripcion='"+nuevo.getDescripcion()+"', precio_compra="+nuevo.getPrecio_compra()+", precio_venta="+nuevo.getPrecio_venta()+", cantidad="+nuevo.getCantidad()+", venta_x='"+nuevo.getTipo()+"', categoria='"+nuevo.getCategoria()+"', bodegaNo='"+nuevo.getBodega()+"', proveedor='"+nuevo.getProveedor()+"' where cod_p='"+nuevo.getCodigo()+"';");
            return state.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.print("Ha Ocurrido un Error: "+ex.getMessage());
            return 0;
        }
    }
    
    public static int elimiar_datos(String text) {
         try {
            SQLconexion coneccion=new SQLconexion();
            Connection con=coneccion.getConect();
            PreparedStatement state=con.prepareStatement("delete from producto where cod_p='"+text+"';");
            return state.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.print("Ha Ocurrido un Error: "+ex.getMessage());
            return 0;
        }
    }
    
}
    
    

