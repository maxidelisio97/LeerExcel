/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

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

/**
 *
 * @author ferc
 */
public class ControladorExcel {
    
    ModeloExcel modeloE = new ModeloExcel();
    VistaExcel vistaE = new VistaExcel();
    JFileChooser selecArchivo = new JFileChooser();
    File archivo;
 
     
    public ControladorExcel(VistaExcel vistaE, ModeloExcel modeloE){
        
        this.vistaE=vistaE;
        this.modeloE=modeloE;
        
        this.vistaE.btnImportar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               
               getFile(); 
                
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
}