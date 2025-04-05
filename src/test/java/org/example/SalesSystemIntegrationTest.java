package org.example;

import org.example.exceptions.*;
import org.example.model.Product;
import org.example.model.productCategories.Categories;
import org.example.service.StoreService;
import org.example.Repositories.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SalesSystemIntegrationTest {

    @Test
    public void testFullFlow() throws Exception {

        ProductRepository pr = new ProductRepository();
        SalesmanRepository sr = new SalesmanRepository();
        SaleRepository saler = new SaleRepository();
        StoreService service = new StoreService(pr, sr, saler);

        // Add products
        service.addProduct(1, "Laptop", 1500, "ELECTRONICS");
        service.addProduct(2, "Shirt", 500, "CLOTHING");
        service.addProduct(3, "Book", 300, "BOOKS");

        // Add salesman
        service.addSalesman(1, "Alice", 3000);
        service.addSalesman(2, "Bob", 3200);

        // Register sales
        service.registerSale(1, 1, 1);
        service.registerSale(2, 2, 1);
        service.registerSale(3, 3, 1);

        service.registerSale(4, 1, 2);

        // Calculate commissions
        int aliceCommission = service.calculateCommission(1);
        int bobCommission = service.calculateCommission(2);

        Assertions.assertEquals(230, aliceCommission);
        Assertions.assertEquals(75, bobCommission);

        // Filter by category
        List<Product> electronics = service.getAllProducts().stream()
                .filter(p -> p.getCategory() == Categories.ELECTRONICS)
                .toList();

        Assertions.assertEquals(1, electronics.size());
        Assertions.assertEquals("Laptop", electronics.get(0).getProductName());
    }
}
