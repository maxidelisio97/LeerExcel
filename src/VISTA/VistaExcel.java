/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import MODELO.Conexion;
import java.io.File;
import java.sql.*;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VistaExcel extends javax.swing.JInternalFrame {

    File fichero = null;
    Conexion conn;

    public VistaExcel() {
        initComponents();
        // cargarModeloTabla();
        conn = new Conexion();
        
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnImportar = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        btnActualizarPrecio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        tabla.setModel(modeloTabla);
        jScrollPane2.setViewportView(tabla);

        jPanel1.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        btnImportar.setText("Importar");
        jPanel2.add(btnImportar);

        btnExportar.setText("Exportar");
        jPanel2.add(btnExportar);

        btnActualizarPrecio.setText("Actualizar precio");
        jPanel2.add(btnActualizarPrecio);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizarPrecio;
    public javax.swing.JButton btnExportar;
    public javax.swing.JButton btnImportar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
private DefaultTableModel modeloTabla = new DefaultTableModel();

   

}
