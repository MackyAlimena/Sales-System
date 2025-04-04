package org.example.exceptions;

public class ProductNotFoundException extends AppException {
    public ProductNotFoundException(int id) {
        super("Product with ID " + id + " was not found.");
    }
}
