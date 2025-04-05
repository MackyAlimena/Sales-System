package org.example.utils;

import org.example.service.StoreService;

public class DataMocks {

    public static void seed(StoreService service) {
        try {
            //Products
            service.addProduct(1, "Laptop", 1500, "ELECTRONICS");
            service.addProduct(2, "Shirt", 500, "CLOTHING");
            service.addProduct(3, "Book", 300, "BOOKS");

            //Salesmen
            service.addSalesman(1, "Alice", 3000);
            service.addSalesman(2, "Bob", 2800);

            //Sales
            service.registerSale(1, 1, 1);
            service.registerSale(2, 2, 1);
            service.registerSale(3, 3, 1);
            service.registerSale(4, 1, 2);

            System.out.println("✅ Sample data loaded.");

        } catch (Exception e) {
            System.out.println("⚠️ Error loading sample data: " + e.getMessage());
        }
    }
}
