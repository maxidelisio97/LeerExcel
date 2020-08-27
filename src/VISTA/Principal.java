/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

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

public class Principal extends javax.swing.JFrame {

    File fichero = null;
    Conexion conn;

    public Principal() {
        initComponents();
        // cargarModeloTabla();
        conn = new Conexion();
        modeloTabla.addColumn("Codigo");
        modeloTabla.addColumn("Precio");
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnImportar = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnActualizarPrecio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnImportar.setText("Importar");
        btnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarActionPerformed(evt);
            }
        });

        btnExportar.setText("Exportar");

        tabla.setModel(modeloTabla);
        jScrollPane2.setViewportView(tabla);

        btnActualizarPrecio.setText("Actualizar precio");
        btnActualizarPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarPrecioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnImportar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btnActualizarPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(76, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImportar)
                    .addComponent(btnExportar)
                    .addComponent(btnActualizarPrecio))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
        File archivo = getFile();

        leeExcel(archivo, tabla);

        tabla.setModel(modeloTabla);
    }//GEN-LAST:event_btnImportarActionPerformed

    private void btnActualizarPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarPrecioActionPerformed

        try {
            int numFila = tabla.getRowCount();
            int numColumna = tabla.getColumnCount(); 
           
            
            Connection conexion = conn.getConexion();     
            
            PreparedStatement ps = conexion.prepareStatement("UPDATE productos SET PRECIO=? WHERE CODIGO_ARTICULO=?");
            
            
            for (int i = 0; i < numFila; i++) {
               
                ps.setObject(1,  modeloTabla.getValueAt(i, 1));
                ps.setString(2, (String) modeloTabla.getValueAt(i, 0));
                 
                 ps.execute();
              
            }
  
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnActualizarPrecioActionPerformed

 
    
    public File getFile() {

        JFileChooser fc = new JFileChooser();

        int seleccion = fc.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {

            fichero = fc.getSelectedFile();

        } else {
            System.out.println("NO A ELEGIDO NADA");
        }
        return fichero;

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizarPrecio;
    public javax.swing.JButton btnExportar;
    public javax.swing.JButton btnImportar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
private DefaultTableModel modeloTabla = new DefaultTableModel();

    public void leeExcel(File archivo, JTable tabla) {

        Workbook wb;

        try {

            wb = WorkbookFactory.create(new FileInputStream(archivo));
            Sheet hoja = wb.getSheetAt(0);
            Iterator filaIterator = hoja.rowIterator();
            int indiceFila = -1;

            while (filaIterator.hasNext()) {
                indiceFila++;
                Row fila = (Row) filaIterator.next();
                Iterator columnIterator = fila.cellIterator();

                Object[] listaColumna = new Object[4];
                int indiceColumna = -1;

                while (columnIterator.hasNext()) {
                    indiceColumna++;

                    Cell cell = (Cell) columnIterator.next();
                    if (indiceFila == 0) {

                        modeloTabla.addColumn(cell.getStringCellValue());
                    } else {

                        if (cell != null) {

                            switch (cell.getCellType()) {

                                case Cell.CELL_TYPE_NUMERIC:
                                    listaColumna[indiceColumna] = (double) cell.getNumericCellValue();

                                    break;

                                case Cell.CELL_TYPE_STRING:

                                    listaColumna[indiceColumna] = cell.getStringCellValue();
                                    break;

                            }
                        }

                    }

                }
                if (indiceFila != 0) {
                    modeloTabla.addRow(listaColumna);
                }
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}
