package org.example.service;

import org.example.Repositories.ProductRepository;
import org.example.Repositories.SaleRepository;
import org.example.Repositories.SalesmanRepository;
import org.example.model.Product;
import org.example.model.Sale;
import org.example.model.Salesman;

import java.util.List;
import java.util.ArrayList;

public class StoreService {

    // This class will handle the business logic related to the store
    private ProductRepository productRepository;
    private SalesmanRepository salesmanRepository;
    private SaleRepository saleRepository;

    public StoreService(ProductRepository productRepository, SalesmanRepository salesmanRepository, SaleRepository saleRepository) {
        this.productRepository = productRepository;
        this.salesmanRepository = salesmanRepository;
        this.saleRepository = saleRepository;
    }

    public void registerSale(int saleId, int productId, int salesmanId) {
        if (saleRepository.existsById(saleId)) {
            throw new IllegalArgumentException("Sale with id " + saleId + " already exists.");
        }
        Product product = productRepository.getProductById(productId);
        if (product == null) {
            throw new IllegalArgumentException("Product with id " + productId + " does not exist.");
        }
        Salesman salesman = salesmanRepository.getSalesmanById(salesmanId);
        if (salesman == null) {
            throw new IllegalArgumentException("No one with id" + salesmanId + " works at the store.");
        }
        Sale newSale = new Sale(saleId, product, salesman);
        saleRepository.addSale(newSale);
    }

    public int calculateCommission(int salesmanId) {
        // Validate if there are any sales
        if (saleRepository.getAll().isEmpty()) {
            throw new IllegalArgumentException("No sales registered.");
        }

        // Validate if there is any Salesman with that id
        if (!salesmanRepository.existsById(salesmanId)) {
            throw new IllegalArgumentException("Salesman with id " + salesmanId + " does not exist.");
        }

        // Filter sales by salesman
        List<Sale> allSales = saleRepository.getAll();
        List<Integer> prices = new ArrayList<>();
        for (Sale sale : allSales) {
            if (sale.getSalesman().getSalesmanId() == salesmanId) {
                prices.add(sale.getProduct().getPrice());
            }
        }

        //If there are no sales for that salesman
        if (prices.isEmpty()) {
            throw new IllegalArgumentException("No sales registered for salesman with id " + salesmanId);
        }

        // Calculate commission
        int total = 0;
        for (int price : prices) {
            total += price;
        }

        return prices.size() > 2 ? total * 10 / 100 : total * 5 / 100;
    }

}
