/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Principal extends javax.swing.JFrame {

    File fichero = null;

    public Principal() {
        initComponents();
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnImportar = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(btnImportar)
                .addGap(31, 31, 31)
                .addComponent(btnExportar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImportar)
                    .addComponent(btnExportar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

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

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
        File archivo = getFile();

        leeExcel(archivo,tabla);
        
        cargarModeloTabla();
        
         tabla.setModel(modeloTabla);
    }//GEN-LAST:event_btnImportarActionPerformed

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
    public javax.swing.JButton btnExportar;
    public javax.swing.JButton btnImportar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
private DefaultTableModel modeloTabla = new DefaultTableModel();
   
    public void leeExcel(File archivo,JTable tabla) {
        
        Workbook wb;

         
        
        
        try{
            
            wb = WorkbookFactory.create(new FileInputStream(archivo));
            Sheet hoja =wb.getSheetAt(0);
            Iterator filaIterator = hoja.rowIterator();
            int indiceFila=-1;
            
            while(filaIterator.hasNext()){
                indiceFila++;
                Row fila = (Row) filaIterator.next();
                Iterator columnIterator = fila.cellIterator();
                System.out.println(fila.getRowNum());
                Object[] listaColumna = new Object[4];
                int indiceColumna=-1;
                
                while(columnIterator.hasNext()){
                    indiceColumna++;
                    
                    Cell cell =(Cell) columnIterator.next();
                    if(indiceFila==0){
                        
                        modeloTabla.addColumn(cell.getStringCellValue());
                    }else{
                        
                        if(cell!=null){
                            
                            switch(cell.getCellTypeEnum()){
                                
                                case NUMERIC:
                                listaColumna[indiceColumna] =(double)   cell.getNumericCellValue();
                                   break; 
                                   
                                case STRING:
                                 listaColumna[indiceColumna] = cell.getStringCellValue();
                                 break;
                                 
                                
                            }
                        }
                        
                    }
                    
                }
                if(indiceFila!=0)modeloTabla.addRow(listaColumna);
            }
            
            
        }catch(Exception e){
            
            e.printStackTrace();
        }

       
        
    }
    
       public void cargarModeloTabla(){
        
     
       
        
        TableColumn colCodigo = tabla.getColumn("Código");
        TableColumn colProducto = tabla.getColumn("Producto");
        TableColumn colPrecio =tabla.getColumn("Precio");
        TableColumn colUnidades = tabla.getColumn("Unidades");
        
        colCodigo.setMaxWidth(65);
        colCodigo.setMinWidth(10);
        
        colProducto.setMaxWidth(350);
        colProducto.setMinWidth(80);
        
        colPrecio.setMaxWidth(65);
        colPrecio.setMinWidth(10);
        
        colUnidades.setMaxWidth(65);
        colUnidades.setMinWidth(10);

    }
}
