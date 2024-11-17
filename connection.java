/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package train;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.JOptionPane;

public class connection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/ecommerce_data";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    // Establishing the database connection
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    } 
    
    public static void main(String[] args){
        try (Connection conn = connect()) 
        {
            System.out.println("Connection Successful");
        }
        catch (SQLException e) 
        {
            System.out.println(e);}}
}