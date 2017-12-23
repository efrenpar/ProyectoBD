/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mostrarbase;

import javafx.beans.property.StringProperty;

/**
 *
 * @author Israel
 */
public class Factura {
    StringProperty fact_no;
    StringProperty nombre_cliente;
    StringProperty fecha_emision;
    StringProperty total;

    public Factura(StringProperty fact_no, StringProperty nombre_cliente, StringProperty fecha_emision, StringProperty total) {
        this.fact_no = fact_no;
        this.nombre_cliente = nombre_cliente;
        this.fecha_emision = fecha_emision;
        this.total = total;
    }
    
    public Factura(){
    
        
    }

    public StringProperty getFact_no() {
        return fact_no;
    }

    public void setFact_no(StringProperty fact_no) {
        this.fact_no = fact_no;
    }

    public StringProperty getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(StringProperty nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public StringProperty getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(StringProperty fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public StringProperty getTotal() {
        return total;
    }

    public void setTotal(StringProperty total) {
        this.total = total;
    }
    
    
    
}
