package org.example.exceptions;

public class SalesmanNotFoundException extends Exception {
    public SalesmanNotFoundException(int id) {
        super("Salesman with ID " + id + " was not found.");
    }
}
