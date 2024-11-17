/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package train;

/**
 *
 * @author user
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/ecommerce_data";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Retrieve all products from the database
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Product product = new Product(
                    rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getString("description"),
                    rs.getDouble("price"),
                    rs.getString("image_url"),
                    rs.getInt("stock")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return products;
    }
    
    // Insert a new product into the database (example method)
    public void addProduct(Product product) {
        String query = "INSERT INTO products (product_name, description, price, image_url, stock) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, product.getProductName());
            pstmt.setString(2, product.getDescription());
            pstmt.setDouble(3, product.getPrice());
            pstmt.setString(4, product.getImageUrl());
            pstmt.setInt(5, product.getStock());

            pstmt.executeUpdate();
        } catch (SQLException e){
            System.out.println(e);
        }
    }
    
    // Add methods for updating and deleting products as needed
}
