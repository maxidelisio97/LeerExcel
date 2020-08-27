/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

/**
 *
 * @author maxid
 */
public class Actualizar {
    
    public String  codigo;

    public Actualizar(String codigo, String precio) {
        this.codigo = codigo;
        this.precio = precio;
    }
    public String precio;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
 
    
}
