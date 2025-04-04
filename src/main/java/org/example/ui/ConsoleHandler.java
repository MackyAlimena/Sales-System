package org.example.ui;

import org.example.service.StoreService;
import org.example.ui.cases.AddProductCase;
import org.example.ui.cases.AddSalesmanCase;
import org.example.ui.cases.RegisterSaleCase;

import java.util.Scanner;

public class ConsoleHandler {

    private final StoreService storeService;

    public ConsoleHandler(StoreService storeService) {
        this.storeService = storeService;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n📦 Sales System Menu");
            System.out.println("1. Add Product");
            System.out.println("2. Add Salesman");
            System.out.println("3. Register Sale");
            System.out.println("4. Calculate Commission");
            System.out.println("5. Search Products");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> new AddProductCase(storeService).execute(scanner);
                case 2 -> new AddSalesmanCase(storeService).execute(scanner);
                case 3 -> new RegisterSaleCase(storeService).execute(scanner);
                case 4 -> {
                    running = false;
                    System.out.println("👋 GoodBye...");
                }
                default -> System.out.println("❌ Invalid option. Try again.");
            }
        }

        scanner.close();
    }

}
