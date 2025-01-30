package Main;

import java.util.Scanner;

import controller.MenuController;

public class Main {

	public static void main(String[] args) {
		 MenuController menuController = new MenuController();
	        Scanner scanner = new Scanner(System.in);
	        boolean exit = false;

	        while (!exit) {
	            System.out.println("\nMenu Management System");
	            System.out.println("1. Add Menu Item");
	            System.out.println("2. Display Menu");
	            System.out.println("3. Update Menu Item");
	            System.out.println("4. Delete Menu Item");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter item name: ");
	                    scanner.nextLine(); // Consume newline
	                    String name = scanner.nextLine();
	                    System.out.print("Enter price: ");
	                    Double price = scanner.nextDouble();
	                    menuController.addMenuItem(name, price);
	                    break;

	                case 2:
	                    menuController.displayMenu();
	                    break;

	                case 3:
	                    System.out.print("Enter item ID to update: ");
	                    int updateId = scanner.nextInt();
	                    System.out.print("Enter new name: ");
	                    scanner.nextLine(); // Consume newline
	                    String newName = scanner.nextLine();
	                    System.out.print("Enter new price: ");
	                    double newPrice = scanner.nextDouble();
	                    menuController.updateMenuItem(updateId, newName, newPrice);
	                    break;

	                case 4:
	                    System.out.print("Enter item ID to delete: ");
	                    int deleteId = scanner.nextInt();
	                    menuController.deleteMenuItem(deleteId);
	                    break;

	                case 5:
	                    exit = true;
	                    System.out.println("Exiting... Thank you!");
	                    break;

	                default:
	                    System.out.println("Invalid choice! Try again.");
	            }
	        }

	        scanner.close();
	    }

}
