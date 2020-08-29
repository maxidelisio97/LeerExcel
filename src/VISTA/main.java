/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import CONTROLADOR.ControladorExcel;
import MODELO.ModeloExcel;

/**
 *
 * @author ferc
 */
public class main {
    public static void main(String[] args) {
        
        VistaExcel vista = new VistaExcel();
        ModeloExcel modelo = new ModeloExcel();
        vista.setVisible(true);
        ControladorExcel controlador = new ControladorExcel(vista,modelo);
    }
    
}
