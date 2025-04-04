package org.example.utils;

import org.example.model.Product;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductSorter {

    //Sorts the products by price in ascending order
    public static List<Product> sortByPriceAsc(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());
    }

    //Sorts the products by price in descending order
    public static List<Product> sortByPriceDesc(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());
    }

    //Sorts the products by name in ascending order
    public static List<Product> sortByNameAsc(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(product -> product.getProductName().toLowerCase()))
                .collect(Collectors.toList());
    }

    //Sorts the products by name in ascending order
    public static List<Product> sortByCategoryAsc(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(product -> product.getCategory().toString().toLowerCase()))
                .collect(Collectors.toList());
    }
}
