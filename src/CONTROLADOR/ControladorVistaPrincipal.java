/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import MODELO.ModeloProductos;
import VISTA.VistaExcel;
import VISTA.vistaPresupuesto;
import VISTA.vistaPrincipal;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author ferc
 */
public class ControladorVistaPrincipal {

    private VistaExcel frameVistaExcel;
    private vistaPresupuesto framePresupuesto;
    private vistaPrincipal vista;
    private ModeloProductos modelo;

    public ControladorVistaPrincipal(vistaPrincipal vista, ModeloProductos modelo) {

        this.vista = vista;
        this.modelo = modelo;
        frameVistaExcel = new VistaExcel();
        framePresupuesto = new vistaPresupuesto();

        this.vista.menuPresupuestos.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                abrirFramePresupuesto(e);
               
            }
        });
        
            this.vista.menuActualizacion.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                abrirFrameActualizacion(e);
               
            }
        });

    }
    
    
    public void abrirFramePresupuesto(MouseEvent e){
        
                vista.escritorio.removeAll();
                vista.escritorio.repaint();
                vista.escritorio.add(BorderLayout.CENTER, this.framePresupuesto);
                vista.escritorio.getDesktopManager().maximizeFrame(framePresupuesto);
                this.framePresupuesto.show();
    }
    
      public void abrirFrameActualizacion(MouseEvent e){
        
                vista.escritorio.removeAll();
                vista.escritorio.repaint();
                vista.escritorio.add(BorderLayout.CENTER, this.frameVistaExcel);
                vista.escritorio.getDesktopManager().maximizeFrame(frameVistaExcel);
                this.frameVistaExcel.show();
    }

}
