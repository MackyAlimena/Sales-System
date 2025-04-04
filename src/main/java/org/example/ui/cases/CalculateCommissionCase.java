package org.example.ui.cases;

import org.example.exceptions.NoSalesRegisteredException;
import org.example.exceptions.SalesmanNotFoundException;
import org.example.service.StoreService;

import java.util.Scanner;

public class CalculateCommissionCase {

    private final StoreService storeService;

    public CalculateCommissionCase(StoreService storeService) {
        this.storeService = storeService;
    }

    public void execute(Scanner scanner) {
        try {
            System.out.print("Enter salesman ID: ");
            int salesmanId = Integer.parseInt(scanner.nextLine());

            int commission = storeService.calculateCommission(salesmanId);
            System.out.println("Commission: $" + commission);

        } catch (SalesmanNotFoundException | NoSalesRegisteredException e) {
            System.out.println("❌ " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error calculating commission: " + e.getMessage());
        }
    }
}
