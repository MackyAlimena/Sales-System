package org.example.ui.cases;

import org.example.exceptions.InvalidCategoryException;
import org.example.service.StoreService;

import java.util.Scanner;

public class AddProductCase {

    private final StoreService storeService;

    public AddProductCase(StoreService storeService) {
        this.storeService = storeService;
    }

    public void execute(Scanner scanner) {
        try {
            System.out.print("Enter product ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter product name: ");
            String name = scanner.nextLine();

            System.out.print("Enter product price: ");
            int price = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter product category: ");
            String category = scanner.nextLine();

            storeService.addProduct(id, name, price, category);
            System.out.println("✅ Product added successfully!");
        } catch (InvalidCategoryException e) {
            System.out.println("❌ " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error adding product: " + e.getMessage());
        }
    }
}
