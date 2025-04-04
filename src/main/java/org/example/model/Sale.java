package org.example.model;

import org.example.model.Product;
import org.example.model.Salesman;

public class Sale {
    private int sale_id;
    private Product product;
    private Salesman salesman;

    public Sale(int sale_id, Product product, Salesman salesman) {
        this.sale_id = sale_id;
        this.product = product;
        this.salesman = salesman;
    }

    // Get the sale id
    public int getSaleId() {
        return sale_id;
    }
    // Set the sale id
    public void setSaleId(int sale_id) {
        this.sale_id = sale_id;
    }
    // Get the product
    public Product getProduct() {
        return product;
    }
    // Set the product
    public void setProduct(Product product) {
        this.product = product;
    }
    // Get the salesman
    public Salesman getSalesman() {
        return salesman;
    }
    // Set the salesman
    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

}
