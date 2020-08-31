/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import MODELO.ModeloProductos;
import MODELO.Productos;
import VISTA.vistaPresupuesto;
import VISTA.vistaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author maxid
 */
public class ControladorProductos {
    
    private ModeloProductos modelo;
    private vistaPrincipal vista;
    private vistaPresupuesto framePresupuesto;
    public ControladorProductos(vistaPrincipal vista, ModeloProductos modelo){
        
        framePresupuesto = new vistaPresupuesto();
        this.modelo=modelo;
        this.vista=vista;
       
        
    }
    
     private void cargarComboBoxProductos() {
        ArrayList<Productos> listaProductos = new ArrayList<Productos>();
        listaProductos = modelo.getProductosbd();

        for (Productos c : listaProductos) {
            framePresupuesto.modeloComboProductos.addElement(c);
        }

    }
    
}
