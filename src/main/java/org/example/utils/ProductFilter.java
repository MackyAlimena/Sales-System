package org.example.utils;

import org.example.exceptions.InvalidCategoryException;
import org.example.model.Product;
import org.example.model.productCategories.Categories;

import java.util.List;
import java.util.stream.Collectors;

public class ProductFilter {

    //Filter by category
    public static List<Product> filterByCategory(List<Product> products, String category) throws InvalidCategoryException {
        Categories validCategory;
        try {
            validCategory = Categories.valueOf(category.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidCategoryException(category);
        }
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


