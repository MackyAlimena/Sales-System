package org.example.utils;

import org.example.model.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductFilter {

    //Filter by category
    public static List<Product> filterByCategory(List<Product> products, String category) {
        return products.stream()
                .filter(product -> product.getCategory().name().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    //Filter by price range given a minimum and maximum
    public static List<Product> filterByPriceRange(List<Product> products, int min, int max) {
        return products.stream()
                .filter(product -> product.getPrice() >= min && product.getPrice() <= max)
                .collect(Collectors.toList());
    }

    //Filter by product that contains that name
    public static List<Product> filterByName(List<Product> products, String name) {
        return products.stream()
                .filter(product -> product.getProductName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());

    }
}


