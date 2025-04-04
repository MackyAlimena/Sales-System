package org.example.service;

import org.example.Repositories.ProductRepository;
import org.example.Repositories.SaleRepository;
import org.example.Repositories.SalesmanRepository;
import org.example.exceptions.*;
import org.example.model.Product;
import org.example.model.Sale;
import org.example.model.Salesman;
import org.example.model.productCategories.Categories;

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

    public void registerSale(int saleId, int productId, int salesmanId) throws ProductNotFoundException, SalesmanNotFoundException, SaleAlreadyExistsException {
        if (saleRepository.existsById(saleId)) {
            throw new SaleAlreadyExistsException(saleId);
        }

        Product product = productRepository.getProductById(productId);

        Salesman salesman = salesmanRepository.getSalesmanById(salesmanId);

        Sale newSale = new Sale(saleId, product, salesman);
        saleRepository.addSale(newSale);
    }

    public int calculateCommission(int salesmanId) throws SalesmanNotFoundException, NoSalesRegisteredException {
        // Validate if there are any sales
        if (saleRepository.getAll().isEmpty()) {
            throw new NoSalesRegisteredException("No sales registered.");
        }

        // Validate if there is any Salesman with that id
        salesmanRepository.getSalesmanById(salesmanId);


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
            throw new NoSalesRegisteredException("No sales registered for salesman with id " + salesmanId);
        }

        // Calculate commission
        int total = 0;
        for (int price : prices) {
            total += price;
        }

        //In this model i consider that a sale is a product sold
        //In a further detailed system, i would add a quantity to sale and a stock for product
        return prices.size() > 2 ? total * 10 / 100 : total * 5 / 100;
    }

    public void addProduct(int id, String name, int price, String category) throws InvalidCategoryException {
        Categories cat;
        try {
            cat = Categories.valueOf(category.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidCategoryException(category);
        }

        Product product = new Product(id, name, price, cat);
        productRepository.addProduct(product);
    }

}
