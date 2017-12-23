/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mostrarbase;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Israel
 */
public class Persona {
    
    private StringProperty ruc;
    private StringProperty razonSocial;
    private StringProperty direccion;
    private StringProperty contacto;
    private StringProperty ciudad;

    public Persona(String ruc, String razonSocial, String direccion, String contacto, String ciudad) {
        this.ruc = new SimpleStringProperty(ruc);
        this.razonSocial = new SimpleStringProperty(razonSocial);
        this.direccion = new SimpleStringProperty (direccion);
        this.contacto = new SimpleStringProperty (contacto);
        this.ciudad = new SimpleStringProperty(ciudad);
    }
    
      public Persona() {
        
    }

    public String getRuc() {
        return ruc.get();
    }

    public void setRuc(StringProperty ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial.get();
    }

    public void setRazonSocial(StringProperty razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion.get();
    }

    public void setDireccion(StringProperty direccion) {
        this.direccion = direccion;
    }

    public String getContacto() {
        return contacto.get();
    }

    public void setContacto(StringProperty contacto) {
        this.contacto = contacto;
    }

  
    public String getCiudad() {
        return ciudad.get();
    }

    public void setCiudad(StringProperty ciudad) {
        this.ciudad = ciudad;
    }
    
   
    
    
}
