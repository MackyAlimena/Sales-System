package org.example.model;

import org.example.model.productCategories.Categories;

public class Product {
    //Product at the store
    public int product_id; //primary key, unique
    private String product_name;
    public int price;
    private final Categories category;

    public Product(int product_id, String product_name, int price, Categories category) {
        this.product_id = product_id; //primary key, unique
        this.product_name = product_name;
        this.price = price;
        this.category = category;
    }

    // Get the product id
    public int getProductId() {
        return product_id;
    }

    // Set the product id
    public void setProductId(int product_id) {
        this.product_id = product_id;
    }

    // Get the product name
    public String getProductName() {
        return product_name;
    }

    // Set the product name
    public void setProductName(String product_name) {
        this.product_name = product_name;
    }

    // Get the product price
    public int getPrice() {
        return price;
    }

    // Set the product price
    public void setPrice(int price) {
        this.price = price;
    }

    // Get the product category
    public Categories getCategory() {
        return category;
    }
}