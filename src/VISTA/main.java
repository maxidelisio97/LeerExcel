/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import CONTROLADOR.ControladorExcel;
import CONTROLADOR.ControladorProductos;
import CONTROLADOR.ControladorVistaPrincipal;
import MODELO.ModeloExcel;
import MODELO.ModeloProductos;

/**
 *
 * @author ferc
 */
public class main {
    public static void main(String[] args) {
        
        vistaPrincipal vista = new vistaPrincipal();
        VistaExcel vistaExcel = new VistaExcel();
        ModeloExcel modeloExcel = new ModeloExcel();
        ModeloProductos modeloProductos = new ModeloProductos();
        ControladorExcel controlExcel = new ControladorExcel(vistaExcel,modeloExcel);
        ControladorVistaPrincipal controlVistaPrincipal = new  ControladorVistaPrincipal(vista,modeloProductos);
       
        vista.setVisible(true);
        

       
    }
    
}
