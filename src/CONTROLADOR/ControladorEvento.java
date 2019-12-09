/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import TestClass.readExcel;
import VISTA.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author ferc
 */
public class ControladorEvento {
    
    
    
    private Principal vista;
     private File  fichero;
    // readExcel excel = new readExcel();
     DefaultTableModel modeloTabla = new DefaultTableModel();
    public ControladorEvento(Principal vista){
        
        this.vista=vista;
//         cargarModeloTabla();
        vista.btnImportar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) { 
                
          
              
             
              
            
    }
            
            
            
        });
        
    }
    
  
    
     public File getFile() {

        JFileChooser fc = new JFileChooser();

        int seleccion = fc.showOpenDialog(vista);

        if (seleccion == JFileChooser.APPROVE_OPTION) {

            fichero = fc.getSelectedFile();

           
        } else {
            System.out.println("NO A ELEGIDO NADA");
        }
        return fichero;

    }
    
}
