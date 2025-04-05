package org.example.exceptions;

public class ProductAlreadyExistsException extends Exception {
    public ProductAlreadyExistsException(int id) {
        super("Product with ID " + id + " already exists.");
    }
}

