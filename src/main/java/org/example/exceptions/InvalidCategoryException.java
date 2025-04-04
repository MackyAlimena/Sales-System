package org.example.exceptions;

public class InvalidCategoryException extends Exception {
    public InvalidCategoryException(String category) {
        super("Invalid category: " + category);
    }
}
