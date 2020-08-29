/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author maxid
 */
public class Conexion {
    
    public Conexion(){
        
        
    }
    
      public Connection getConexion() {

        Connection con = null;
        String url = "jdbc:mariadb://localhost:3306/PRODUCTOS";
        String user = "root";
        String password = "4435";

        try {

            con = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            System.out.println("CONEXION FALLIDA");
        }
        
        return con ;
    }
    
}
