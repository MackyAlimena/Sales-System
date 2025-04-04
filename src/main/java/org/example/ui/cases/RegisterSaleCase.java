package org.example.ui.cases;

import org.example.exceptions.ProductNotFoundException;
import org.example.exceptions.SalesmanNotFoundException;
import org.example.exceptions.SaleAlreadyExistsException;
import org.example.service.StoreService;

import java.util.Scanner;

public class RegisterSaleCase {

    private final StoreService storeService;

    public RegisterSaleCase(StoreService storeService) {
        this.storeService = storeService;
    }

    public void execute(Scanner scanner) {
        try {
            System.out.print("Enter sale ID: ");
            int saleId = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter product ID: ");
            int productId = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter salesman ID: ");
            int salesmanId = Integer.parseInt(scanner.nextLine());

            storeService.registerSale(saleId, productId, salesmanId);
            System.out.println("✅ Sale registered successfully!");

        } catch (ProductNotFoundException | SalesmanNotFoundException | SaleAlreadyExistsException e) {
            System.out.println("❌ " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error registering sale: " + e.getMessage());
        }
    }
}
