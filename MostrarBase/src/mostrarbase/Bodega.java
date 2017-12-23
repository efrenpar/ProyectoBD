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
public class Bodega {
    private StringProperty cod_bod;
    private StringProperty nombre_bod;
    private StringProperty direccion;
    private StringProperty ciudad;

    public Bodega(StringProperty cod_bod, StringProperty nombre_bod, StringProperty direccion, StringProperty ciudad) {
        this.cod_bod = cod_bod;
        this.nombre_bod = nombre_bod;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }
    
    public Bodega(){};

    public String getCod_bod() {
        return cod_bod.get();
    }

    public void setCod_bod(StringProperty cod_bod) {
        this.cod_bod = cod_bod;
    }

    public String getNombre_bod() {
        return nombre_bod.get();
    }

    public void setNombre_bod(StringProperty nombre_bod) {
        this.nombre_bod = nombre_bod;
    }

    public String getDireccion() {
        return direccion.get();
    }

    public void setDireccion(StringProperty direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad.get();
    }

    public void setCiudad(StringProperty ciudad) {
        this.ciudad = ciudad;
    }
    
    
    
}
