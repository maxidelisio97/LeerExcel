/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import CONTROLADOR.ControladorEvento;

/**
 *
 * @author ferc
 */
public class main {
    public static void main(String[] args) {
        
        Principal vista = new Principal();
        vista.setVisible(true);
        ControladorEvento controlador = new ControladorEvento(vista);
    }
    
}
