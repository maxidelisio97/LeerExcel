/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import MODELO.ModeloProductos;
import MODELO.Productos;
import VISTA.VistaExcel;
import VISTA.vistaPresupuesto;
import VISTA.vistaPrincipal;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ferc
 */
public class ControladorVistaPrincipal {

    private VistaExcel frameVistaExcel;
    private vistaPresupuesto framePresupuesto;
    private vistaPrincipal vista;
    private ModeloProductos modelo;
 
     double sumatoria=0;

    public ControladorVistaPrincipal(vistaPrincipal vista, ModeloProductos modelo) {

        this.vista = vista;
        this.modelo = modelo;
        frameVistaExcel = new VistaExcel();
        framePresupuesto = new vistaPresupuesto();
        cargarComboBoxProductos();
        this.vista.menuPresupuestos.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                abrirFramePresupuesto(e);

            }
        });

        framePresupuesto.comboBuscarProductos.setEditable(true);
        framePresupuesto.comboBuscarProductos.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent event) {
                if (event.getKeyChar() == KeyEvent.VK_ESCAPE) {                   
                    Productos p = (Productos) framePresupuesto.comboBuscarProductos.getSelectedItem();
                   
                    if (p != null) {

                        String cantidad = JOptionPane.showInputDialog("Cantidad ?");
                        double importe = Double.parseDouble(p.getPrecio()) * Integer.parseInt(cantidad);
                        sumatoria+=importe;
                        String importeTotal = String.valueOf(importe);                        
                        Object ListaProductos[] = {cantidad, p.getCodigo(), importeTotal, p.getDecripcion(), p.getSector(), p.getMarca(), p.getClase()};                        
                        framePresupuesto.modeloTablaProductosArriba.addRow(ListaProductos);                      
                        framePresupuesto.lblSumatoria.setText(String.valueOf(sumatoria));
                        
                        
                        
                    }

                }
            }
        });
        
            this.vista.menuActualizacion.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                abrirFrameActualizacion(e);
               
            }
        });

    }


    public void abrirFramePresupuesto(MouseEvent e) {

        vista.escritorio.removeAll();
        vista.escritorio.repaint();
        vista.escritorio.add(BorderLayout.CENTER, this.framePresupuesto);
        vista.escritorio.getDesktopManager().maximizeFrame(framePresupuesto);
        this.framePresupuesto.show();
    }

    private void cargarComboBoxProductos() {
        ArrayList<Productos> listaProductos = new ArrayList<Productos>();
        listaProductos = modelo.getProductosbd();

        for (Productos c : listaProductos) {
            framePresupuesto.modeloComboProductos.addElement(c);

        }

    }
    
      public void abrirFrameActualizacion(MouseEvent e){
        
                vista.escritorio.removeAll();
                vista.escritorio.repaint();
                vista.escritorio.add(BorderLayout.CENTER, this.frameVistaExcel);
                vista.escritorio.getDesktopManager().maximizeFrame(frameVistaExcel);
                this.frameVistaExcel.show();
    }

}
