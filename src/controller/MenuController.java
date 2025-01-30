package controller;

import java.util.List;

import Dao.MenuDao;
import Model.MenuItem;

public class MenuController {
	private MenuDao menuDao;

    public MenuController() {
        this.menuDao = new MenuDao();
    }

    public void addMenuItem(String itemName, double price) {
        MenuItem menuItem = new MenuItem();
        menuItem.setItemName(itemName);
        menuItem.setPrice(price);
        menuDao.addMenuItem(menuItem);
    }

    public void displayMenu() {
        List<MenuItem> menuItems = menuDao.getAllMenuItems();
        System.out.println("\nAvailable Menu:");
        for (MenuItem item : menuItems) {
            System.out.printf("ID: %d | Name: %s | Price: %.2f\n",
                    item.getItemId(), item.getItemName(), item.getPrice());
        }
    }

    public void updateMenuItem(int itemId, String newName, double newPrice) {
        MenuItem menuItem = new MenuItem();
        menuItem.setItemId(itemId);
        menuItem.setItemName(newName);
        menuItem.setPrice(newPrice);
        menuDao.updateMenuItem(menuItem);
    }

    public void deleteMenuItem(int itemId) {
        menuDao.deleteMenuItem(itemId);
    }
}
