package org.example;

import org.example.Repositories.*;
import org.example.service.StoreService;
import org.example.ui.ConsoleHandler;

public class Main {
    public static void main(String[] args) {
        ProductRepository pr = new ProductRepository();
        SalesmanRepository sr = new SalesmanRepository();
        SaleRepository saler = new SaleRepository();

        StoreService storeService = new StoreService(pr, sr, saler);
        ConsoleHandler handler = new ConsoleHandler(storeService);
        handler.showMenu();
    }
}
