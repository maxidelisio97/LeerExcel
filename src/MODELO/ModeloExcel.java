package MODELO;

import java.lang.Object;
import java.io.*;
import java.util.Iterator;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Sheet;

public class ModeloExcel {

    Workbook book;

    public String importar(File fichero, JTable tabla) {

        String msj = "Error en la importacion";
        DefaultTableModel model = new DefaultTableModel();
        tabla.setModel(model);

        try {
            //crea el fichero
            book = WorkbookFactory.create(fichero);
            //crea la hoja de excel
            Sheet hoja = book.getSheetAt(0);
            //crea iterator
            Iterator filaIterator = hoja.rowIterator();
            //Indice de fila
            int indiceFila = -1;
            while (filaIterator.hasNext()) {
                indiceFila++;
                Row fila = (Row) filaIterator.next();
                //recorre las filas o columnas de una fila ya creada
                Iterator Columna = fila.cellIterator();
                Object[] listaColumna = new Object[9999];
                int indiceCol = -1;
                //Va a ser true si encuentra columnas por recorrer
                while (Columna.hasNext()) {
                    indiceCol++;
                    Cell celda = (Cell) Columna.next();
                    //si indice fila es igual a 0 entronce agrega un columna
                    if (indiceFila == 0) {

                        model.addColumn(celda.getStringCellValue());
                    } else{
                        if(celda != null) {
                        switch (celda.getCellType()) {
                            case NUMERIC :
                                listaColumna[indiceCol]=(int)Math.round(celda.getNumericCellValue());
                                break;
                                case STRING :
                                    listaColumna[indiceCol]=celda.getStringCellValue();
                                    break;
                                case BOOLEAN :
                                    listaColumna[indiceCol]= celda.getBooleanCellValue();
                                    break;
                                default :
                                    listaColumna[indiceCol]=celda.getDateCellValue();
                                
                                
                        }
                    } 
                    
                    }
                }
            }
        } catch (Exception e) {
        }
        return null;

    }

}
