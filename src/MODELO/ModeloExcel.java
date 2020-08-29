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
    DefaultTableModel modeloTabla = new DefaultTableModel();

    public String importar(File archivo, JTable tabla) {

        String respuesta = "Error en la importacion";

        tabla.setModel(modeloTabla);

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

                                case Cell.CELL_TYPE_BOOLEAN:

                                    listaColumna[indiceColumna] = cell.getBooleanCellValue();
                                    break;

                                default:

                                    listaColumna[indiceColumna] = cell.getDateCellValue();
                                    break;

                            }
                        }

                    }

                }
                if (indiceFila != 0) modeloTabla.addRow(listaColumna);
                    
                
            }
            respuesta = "Importación exitosa";

        } catch (Exception e) {

            e.printStackTrace();
        }

        return respuesta;
    }

}
