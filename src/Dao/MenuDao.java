package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Config.DatabaseConfig;
import Model.MenuItem;

public class MenuDao {
	 // Add Menu Item
    public void addMenuItem(MenuItem menuItem) {
        String query = "INSERT INTO menu (item_name, price) VALUES (?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, menuItem.getItemName());
            stmt.setDouble(2, menuItem.getPrice());
            stmt.executeUpdate();
            System.out.println("Menu item added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Get All Menu Items
    public List<MenuItem> getAllMenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();
        String query = "SELECT * FROM menu";
        try(Connection connection = DatabaseConfig.getConnection();
        	Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                   MenuItem menuItem = new MenuItem();
                   menuItem.setItemId(rs.getInt("item_id"));
                   menuItem.setItemName(rs.getString("item_name"));
                   menuItem.setPrice(rs.getDouble("price"));
                   menuItems.add(menuItem);
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }
           return menuItems;
       }
    
 // Update Menu Item
    public void updateMenuItem(MenuItem menuItem) {
        String query = "UPDATE menu SET item_name = ?, price = ? WHERE item_id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, menuItem.getItemName());
            stmt.setDouble(2, menuItem.getPrice());
            stmt.setInt(3, menuItem.getItemId());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Menu item updated successfully!");
            } else {
                System.out.println("Menu item not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Menu Item
    public void deleteMenuItem(int itemId) {
        String query = "DELETE FROM menu WHERE item_id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, itemId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Menu item deleted successfully!");
            } else {
                System.out.println("Menu item not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
