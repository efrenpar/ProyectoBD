/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contabilidad;

import Conexion.SQLconexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Leonidas
 */
public class Abono {
    private int codigo, cuenta;
    private double valor;
    private Date fecha;

    public Abono(int codigo, int cuenta, double valor, Date fecha) {
        this.codigo = codigo;
        this.cuenta = cuenta;
        this.valor = valor;
        this.fecha = fecha;
    }

    public Abono(int cuenta, double valor, Date fecha) {
        this.codigo = 0;
        this.cuenta = cuenta;
        this.valor = valor;
        this.fecha = fecha;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCuenta() {
        return cuenta;
    }

    public double getValor() {
        return valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public static int Ingresar_datos(Abono nuevo){
        try {
            SQLconexion coneccion=new SQLconexion();
            Connection con=coneccion.getConect();
            PreparedStatement state=con.prepareStatement("insert into abono values(0,"+nuevo.getValor()+","+nuevo.getCuenta()+","+nuevo.getFecha()+");");
            
            return state.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.print("Ha Ocurrido un Error: "+ex.getMessage());
            return 0;
        }
    } 
    
    
    
}
