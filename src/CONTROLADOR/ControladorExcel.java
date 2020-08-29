/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import MODELO.Conexion;
import MODELO.ModeloExcel;
import VISTA.VistaExcel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import java.sql.*;
import javax.swing.table.TableModel;

/**
 *
 * @author ferc
 */
public class ControladorExcel {
    
    ModeloExcel modeloE = new ModeloExcel();
    VistaExcel vistaE = new VistaExcel();
    JFileChooser selecArchivo = new JFileChooser();
    File archivo;
    
    Conexion conn ;
 
     
    public ControladorExcel(VistaExcel vistaE, ModeloExcel modeloE){
        
        this.vistaE=vistaE;
        this.modeloE=modeloE;
        conn = new Conexion();
        
        
        this.vistaE.btnImportar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               
               getFile(); 
                
            }            
        }); 
        
        this.vistaE.btnActualizarPrecio.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                ActualizarListaDePrecios();
                
            }
            
        });
    }
    
    
     public void getFile() {

    if(selecArchivo.showDialog(null, "Seleccionar archivo") == JFileChooser.APPROVE_OPTION){
        
        archivo = selecArchivo.getSelectedFile();
        
        if(archivo.getName().endsWith("xls") || archivo.getName().endsWith("xlsx")){
            
            JOptionPane.showMessageDialog(null, modeloE.importar(archivo, vistaE.tabla));
        }else{
            JOptionPane.showMessageDialog(null, "Elija un formato válido");
        }        
    }       
    
}
     
     public void ActualizarListaDePrecios(){
          try {
            int numFila = this.vistaE.tabla.getRowCount();
            int numColumna = this.vistaE.tabla.getColumnCount(); 
           
            
            
            Connection conexion = conn.getConexion();     
            
            PreparedStatement ps = conexion.prepareStatement("UPDATE productos SET PRECIO=? WHERE CODIGO_ARTICULO=?");
            
            TableModel modeloTabla = this.vistaE.tabla.getModel();
            for (int i = 0; i < numFila; i++) {
               
                 
                ps.setObject(2,  modeloTabla.getValueAt(i, 1));
                ps.setString(1, (String) modeloTabla.getValueAt(i, 0));
               
                 
                 ps.execute();
              
            }
  
        } catch (SQLException ex) {
              ex.printStackTrace();
        }
     }
     
}