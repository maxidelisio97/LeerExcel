/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author maxid
 */
public class ModeloProductos {
    
        private Conexion conexion;
    private Connection connection;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private Statement st = null;
    
    public ModeloProductos(){
        
        conexion = new Conexion();
    }

    public ArrayList getProductosbd() {
        
             ArrayList<Productos>productos = new ArrayList<Productos>();
            
            String sql = "SELECT * FROM productos ";
        try {
            
           
            
            connection = conexion.getConexion();
            
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                
                String codigo = rs.getString(1);
                String precio = rs.getString(2);
                String clase = rs.getString(3);
                String sector = rs.getString(4);
                String marca = rs.getString(5);
                String descripcion = rs.getString(6);
                String unidad = rs.getString(7);
               
                
                
                Productos p = new Productos(codigo, precio, clase, sector, marca, descripcion, unidad);
                
                productos.add(p);
                
            }
                
            } catch (Exception e) {
                System.out.println("error al obtener reserva");
            }
            return productos;
        
    }
    
}
