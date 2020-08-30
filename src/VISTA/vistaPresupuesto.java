package VISTA;

import MODELO.ModeloExcel;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class vistaPresupuesto extends javax.swing.JInternalFrame {

    DefaultTableModel modeloTablaProductosArriba = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;

        }
    };

    DefaultTableModel modeloTablaProductosAbajo = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;

        }
    };

//    Producto productoSeleccionado = null;
    //Categoria categoriaSeleccionada = null;
    //Proveedor proveedorSeleccionado = null;
    String categoria = "";
    String proveedor = "";

//    DefaultListModel<Producto> modeloListaProductos = new DefaultListModel<Producto>();
   // BaseDatos base = new BaseDatos();
    int filaSeleccionada;
    boolean Seleccion = false;

    public vistaPresupuesto() {

        initComponents();

        cargarColumnasTablaAbajo();
        cargarColumnasTablaArriba();
        cargarListenerModeloTabla();
//        cargarModeloTablaArriba();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);

        new lamina();

    }

    private void cargarListenerModeloTabla() {
        modeloTablaProductosAbajo.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int numFilas = modeloTablaProductosAbajo.getRowCount();
                double sumatoria = 0;
                for (int i = 0; i < numFilas; i++) {
                    String importe = (String) modeloTablaProductosAbajo.getValueAt(i, 5);
                    sumatoria += Double.parseDouble(importe);

                }
                lblSumatoria.setText(String.valueOf(sumatoria));
            }
        });
    }

   /* private void cargarModeloTablaArriba() {

        ArrayList<Producto> listaProductoAbajo = base.obtenerProductos();
        int numeroProducto = listaProductoAbajo.size();
        modeloTablaProductosArriba.setNumRows(numeroProducto);

        for (int i = 0; i < numeroProducto; i++) {

            Producto producto = listaProductoAbajo.get(i);
            String nomBre = producto.getNomProducto();
            String idClave = producto.getIdProducto();
            String idFabricaProd = producto.getIdProveedorProducto();
            Double pventa = producto.getPrecioVentaProducto();
            Double exis = producto.getStockProducto();

            modeloTablaProductosArriba.setValueAt(idClave, i, 0);
            modeloTablaProductosArriba.setValueAt(producto, i, 1);
            modeloTablaProductosArriba.setValueAt(idFabricaProd, i, 2);
            modeloTablaProductosArriba.setValueAt(pventa, i, 3);
            modeloTablaProductosArriba.setValueAt(exis, i, 4);

        }

    }*/

    private void cargarColumnasTablaAbajo() {
        modeloTablaProductosAbajo.addColumn("Codigo");
        modeloTablaProductosAbajo.addColumn("Nombre");
        modeloTablaProductosAbajo.addColumn("ID Proveedor");
        modeloTablaProductosAbajo.addColumn("Cantidad");
        modeloTablaProductosAbajo.addColumn("P.Venta");
        modeloTablaProductosAbajo.addColumn("Importe");

        TableColumn ColCodigo = tablaAbajo.getColumn("Codigo");
        TableColumn ColNombre = tablaAbajo.getColumn("Nombre");
        TableColumn ColProve = tablaAbajo.getColumn("ID Proveedor");
        TableColumn Colcant = tablaAbajo.getColumn("Cantidad");
        TableColumn ColVen = tablaAbajo.getColumn("P.Venta");
        TableColumn Colimport = tablaAbajo.getColumn("Importe");

        //ColCodigo.setPreferredWidth(1);
        ColCodigo.setMaxWidth(80);
        ColCodigo.setMinWidth(10);
        
        ColNombre.setMaxWidth(500);
        ColNombre.setMinWidth(500);
      
        
        ColProve.setMaxWidth(90);
        ColProve.setMinWidth(90);
      
        ColVen.setMaxWidth(90);
        ColVen.setMinWidth(10);
        
        Colimport.setMaxWidth(80);
        Colimport.setMinWidth(10);
        
        
    }
    private void cargarColumnasTablaArriba() {
        modeloTablaProductosArriba.addColumn("Codigo");
        modeloTablaProductosArriba.addColumn("Nombre");
        modeloTablaProductosArriba.addColumn("ID Proveedor");
        modeloTablaProductosArriba.addColumn("P.Venta");
        modeloTablaProductosArriba.addColumn("Stock");
        
         TableColumn ColCodigo = tablaArriba.getColumn("Codigo");
        TableColumn ColNombre = tablaArriba.getColumn("Nombre");
        TableColumn ColProve = tablaArriba.getColumn("ID Proveedor");
       
        TableColumn ColVen = tablaArriba.getColumn("P.Venta");
        TableColumn ColStock = tablaArriba.getColumn("Stock");

        ColCodigo.setMaxWidth(80);
        ColCodigo.setMinWidth(10);
        
  
        ColNombre.setMinWidth(100);
        ColNombre.setMaxWidth(510);
        
        ColProve.setMaxWidth(100);
        ColProve.setMinWidth(50);
      
        ColVen.setMaxWidth(80);
        ColVen.setMinWidth(10);
        
        ColStock.setMaxWidth(80);
        ColStock.setMinWidth(10);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBusquedaCriterio = new javax.swing.ButtonGroup();
        grupo_boletas = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaArriba = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAbajo = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnQuitarProd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        radioCodigo = new javax.swing.JRadioButton();
        radioDescripcion = new javax.swing.JRadioButton();
        radioCodigoProveedor = new javax.swing.JRadioButton();
        campoBuscarProd = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField2 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblIMAGEN = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblSumatoria = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoPagaCon = new javax.swing.JTextField();

        setBorder(null);
        setClosable(true);
        setTitle("Ventas");
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);
        getContentPane().setLayout(null);

        /*tablaArriba.setModel(modeloTablaProductosArriba);
        tablaArriba.getSelectionModel().addListSelectionListener(

            new ListSelectionListener() {

                public void valueChanged(ListSelectionEvent event){

                    if(!event.getValueIsAdjusting() &&  (tablaArriba.getSelectedRow()>=0)){
                        Producto  producto =(Producto)modeloTablaProductosArriba.getValueAt(tablaArriba.getSelectedRow() , 1);
                        desplegarFoto(producto);
                        productoSeleccionado = producto;

                    }

                }
            }
        );*/
        tablaArriba.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        tablaArriba.setModel(modeloTablaProductosArriba);
        tablaArriba.setGridColor(new java.awt.Color(204, 204, 204));
        tablaArriba.setRowHeight(25);
        tablaArriba.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaArribaKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tablaArriba);

        tablaAbajo.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        tablaAbajo.setModel(modeloTablaProductosAbajo);
        tablaAbajo.setRowHeight(25);
        jScrollPane1.setViewportView(tablaAbajo);

        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        jButton3.setText("Realizar Venta");
        jButton3.setBorder(null);

        btnCancelar.setForeground(new java.awt.Color(102, 255, 102));

        jLabel2.setFont(new java.awt.Font("Fira Code Light", 0, 14)); // NOI18N
        jLabel2.setText("Eliminar");

        jLabel4.setFont(new java.awt.Font("Fira Code Light", 0, 14)); // NOI18N
        jLabel4.setText("Eliminar Venta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnQuitarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                            .addComponent(btnQuitarProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        grupoBusquedaCriterio.add(radioCodigo);
        radioCodigo.setText("Codigo");

        grupoBusquedaCriterio.add(radioDescripcion);
        radioDescripcion.setSelected(true);
        radioDescripcion.setText("Descripcion");

        grupoBusquedaCriterio.add(radioCodigoProveedor);
        radioCodigoProveedor.setText("Codigo Proveedor");
        radioCodigoProveedor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 255, 255), 1, true));

        campoBuscarProd.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        jTextField1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jTextField1.setText("fac-numero");

        grupo_boletas.add(jRadioButton3);
        jRadioButton3.setText("C.Corriente");

        grupo_boletas.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Presupuesto");

        grupo_boletas.add(jRadioButton2);
        jRadioButton2.setText("Factura");

        jTextField2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jTextField2.setText("Cliente");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(radioDescripcion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioCodigoProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(campoBuscarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoBuscarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton1)
                        .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radioCodigo)
                        .addComponent(radioCodigoProveedor)
                        .addComponent(radioDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jLabel1.setText("PRODUCTOS AÑADIDOS");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(342, 342, 342)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        lblIMAGEN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIMAGEN.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 1, true));

        jPanel5.setBackground(new java.awt.Color(57, 72, 85));

        lblSumatoria.setFont(new java.awt.Font("DejaVu Sans", 0, 36)); // NOI18N
        lblSumatoria.setForeground(new java.awt.Color(51, 255, 204));
        lblSumatoria.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblSumatoria.setText("$ 0.00");
        lblSumatoria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblSumatoria.setPreferredSize(new java.awt.Dimension(200, 51));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSumatoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSumatoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel3.setText("Paga con: ");

        campoPagaCon.setFont(new java.awt.Font("DejaVu Sans", 0, 36)); // NOI18N
        campoPagaCon.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(campoPagaCon)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblIMAGEN, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIMAGEN, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoPagaCon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(307, 307, 307))))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 1360, 740);

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**/
    public void LimpiarListaProductos() {
    //    modeloListaProductos.clear();
    }



    private void tablaArribaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaArribaKeyReleased

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            try {
                filaSeleccionada = tablaArriba.getSelectedRow();
                modeloTablaProductosArriba = (DefaultTableModel) tablaArriba.getModel();

                String codigo = tablaArriba.getValueAt(filaSeleccionada, 0).toString();
                String nomb = tablaArriba.getValueAt(filaSeleccionada, 1).toString();
                String codigoProve = tablaArriba.getValueAt(filaSeleccionada, 2).toString();
                String cantidad = JOptionPane.showInputDialog("Cantidad ?");
                String Pventa = tablaArriba.getValueAt(filaSeleccionada, 3).toString();
                String Stock = tablaArriba.getValueAt(filaSeleccionada, 4).toString();

                double importe = Double.parseDouble(Pventa) * Double.parseDouble(cantidad);
                String importeTotal = String.valueOf(importe);

                modeloTablaProductosAbajo = (DefaultTableModel) tablaAbajo.getModel();

                String ListaProductos[] = {codigo, nomb, codigoProve, cantidad, Pventa, importeTotal};

                modeloTablaProductosAbajo.addRow(ListaProductos);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }


    }//GEN-LAST:event_tablaArribaKeyReleased

  /*  public void desplegarFoto(Producto prod) {

        ImageIcon ImagenProducto = null;

        try {
            InputStream is = base.buscarFoto(prod);
            BufferedImage bi = ImageIO.read(is);
            ImagenProducto = new ImageIcon(bi);

            ImageIcon icono2 = new ImageIcon(ImagenProducto.getImage().getScaledInstance(lblIMAGEN.getWidth(), lblIMAGEN.getHeight(), Image.SCALE_DEFAULT));

            lblIMAGEN.setIcon(icono2);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e);
        }

    }*/

    private void LimpiarLista() {
        int numFilas = modeloTablaProductosArriba.getRowCount();
        if (numFilas > 0) {
            for (int i = numFilas - 1; i < 0; i--) {
                modeloTablaProductosArriba.removeRow(i);
            }

        }
    }

    class lamina extends JFrame {

        public lamina() {
            grupoBusquedaCriterio.add(radioCodigo);
            grupoBusquedaCriterio.add(radioCodigoProveedor);
            grupoBusquedaCriterio.add(radioDescripcion);

        }

        public String dameSeleccion2() {

            return grupoBusquedaCriterio.getSelection().getActionCommand();
        }

    }

    private javax.swing.JTextField campoAgregarExistencia;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JTextField campoCodigoProveedor;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoStock;
    private boolean seleccion;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnQuitarProd;
    private javax.swing.JTextField campoBuscarProd;
    private javax.swing.JTextField campoPagaCon;
    private javax.swing.ButtonGroup grupoBusquedaCriterio;
    private javax.swing.ButtonGroup grupo_boletas;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    public javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblIMAGEN;
    private javax.swing.JTextField lblSumatoria;
    private javax.swing.JRadioButton radioCodigo;
    private javax.swing.JRadioButton radioCodigoProveedor;
    private javax.swing.JRadioButton radioDescripcion;
    private javax.swing.JTable tablaAbajo;
    private javax.swing.JTable tablaArriba;
    // End of variables declaration//GEN-END:variables
}
