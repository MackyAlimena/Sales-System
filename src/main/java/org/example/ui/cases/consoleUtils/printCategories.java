package org.example.ui.cases.consoleUtils;

import org.example.model.productCategories.Categories;

public class printCategories {

    public static void printAvailableCategories() {
        System.out.println("Available categories:");
        for (Categories category : Categories.values()) {
            System.out.println("- " + category.name());
        }
    }
}

