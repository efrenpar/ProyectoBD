/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contabilidad;

import Conexion.SQLconexion;
import Controladores.Proveedor;
import Controladores.Vendedor;
import java.sql.Connection;
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
public class Cuenta_x_cobrar {
    private int codigo;
    private double valor, saldo;
    private String cliente,factura;

    public Cuenta_x_cobrar(int codigo, double valor, double saldo, String cliente, String factura) {
        this.codigo = codigo;
        this.valor = valor;
        this.saldo = saldo;
        this.cliente = cliente;
        this.factura = factura;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getValor() {
        return valor;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getCliente() {
        return cliente;
    }

    public String getFactura() {
        return factura;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }
    
    public static void LlenarInformacion(ObservableList<Cuenta_x_cobrar> lista,String querty) {
        try {
            SQLconexion coneccion=new SQLconexion();
            Connection con=coneccion.getConect();
            Statement st=con.createStatement();
            ResultSet resultado=st.executeQuery(querty);
            
            while(resultado.next()) {
                lista.add(new Cuenta_x_cobrar(resultado.getInt("codigo_cc"),
                                                resultado.getDouble("valor"),
                                                resultado.getDouble("saldo"),
                                                resultado.getString("cliente_no"),
                                                resultado.getString("fact_no")
                                                    
                ));
            }
                
            coneccion.cerrarConect();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
