package org.example.ui.cases;

import org.example.exceptions.InvalidCategoryException;
import org.example.model.Product;
import org.example.model.productCategories.Categories;
import org.example.service.StoreService;
import org.example.ui.cases.consoleUtils.printCategories;
import org.example.utils.ProductFilter;
import org.example.utils.ProductSorter;

import java.util.List;
import java.util.Scanner;

public class SearchProductsCase {

    private final StoreService storeService;

    public SearchProductsCase(StoreService storeService) {
        this.storeService = storeService;
    }

    public void execute(Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("\n Search Products by...");
            System.out.println("1. Category");
            System.out.println("2. Price Range");
            System.out.println("3. Name");
            System.out.println("4. Sort by Price Asc");
            System.out.println("5. Sort by Price Desc");
            System.out.println("6. Sort by Name");
            System.out.println("7. Show All Products");
            System.out.println("8. Back");
            System.out.print("Choose an option: ");

            int option = Integer.parseInt(scanner.nextLine());

            List<Product> result = null;

            try {
                switch (option) {
                    case 1 -> {
                        printCategories.printAvailableCategories();
                        System.out.print("Enter category: ");
                        String category = scanner.nextLine();
                        result = ProductFilter.filterByCategory(storeService.getAllProducts(), category);
                    }

                    case 2 -> {
                        System.out.print("Min price: ");
                        int min = Integer.parseInt(scanner.nextLine());
                        System.out.print("Max price: ");
                        int max = Integer.parseInt(scanner.nextLine());
                        result = ProductFilter.filterByPriceRange(storeService.getAllProducts(), min, max);
                    }
                    case 3 -> {
                        System.out.print("Enter name keyword: ");
                        String name = scanner.nextLine();
                        result = ProductFilter.filterByName(storeService.getAllProducts(), name);
                    }
                    case 4 -> result = ProductSorter.sortByPriceAsc(storeService.getAllProducts());
                    case 5 -> result = ProductSorter.sortByPriceDesc(storeService.getAllProducts());
                    case 6 -> result = ProductSorter.sortByNameAsc(storeService.getAllProducts());
                    case 7 -> result = storeService.getAllProducts();
                    case 8 -> back = true;
                    default -> System.out.println("❌ Invalid option.");
                }

                if (result != null && !result.isEmpty()) {
                    System.out.println("\n Results:");
                    result.forEach(System.out::println);
                } else if (result != null) {
                    System.out.println("⚠️ No results found.");
                }

            } catch (InvalidCategoryException e) {
                System.out.println("❌ " + e.getMessage());
            } catch (Exception e) {
                System.out.println("❌ Unexpected error: " + e.getMessage());
            }
        }
    }


}
