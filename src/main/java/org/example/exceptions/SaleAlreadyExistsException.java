package org.example.exceptions;

public class SaleAlreadyExistsException extends Exception {
    public SaleAlreadyExistsException(int saleId) {
        super("Sale with ID " + saleId + " already exists.");
    }
}
