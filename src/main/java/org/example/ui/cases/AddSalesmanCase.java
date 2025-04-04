package org.example.ui.cases;

import org.example.model.Salesman;
import org.example.service.StoreService;

import java.util.Scanner;

public class AddSalesmanCase {

    private final StoreService storeService;

    public AddSalesmanCase(StoreService storeService) {
        this.storeService = storeService;
    }

    public void execute(Scanner scanner) {
        try {
            System.out.print("Enter salesman ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter salesman name: ");
            String name = scanner.nextLine();

            System.out.print("Enter salesman salary: ");
            int salary = Integer.parseInt(scanner.nextLine());

            storeService.addSalesman(id, name, salary);
            System.out.println("✅ Salesman added successfully!");
        } catch (Exception e) {
            System.out.println("❌ Error adding salesman: " + e.getMessage());
        }
    }
}
