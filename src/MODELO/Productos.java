/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

/**
 *
 * @author maxid
 */
public class Productos {
    
    private String  codigo;
    private String precio;
    private String clase;
    private String sector;
    private String marca;
    private String descripcion;
    private String unidad;

    public Productos(String codigo, String precio, String clase, String sector, String marca, String decripcion, String unidad) {
        this.codigo = codigo;
        this.precio = precio;
        this.clase = clase;
        this.sector = sector;
        this.marca = marca;
        this.descripcion = decripcion;
        this.unidad = unidad;
    }

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

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDecripcion() {
        return descripcion;
    }

    public void setDecripcion(String decripcion) {
        this.descripcion = decripcion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    @Override
    public String toString() {
        return  descripcion;
    }
    

 
    
}
