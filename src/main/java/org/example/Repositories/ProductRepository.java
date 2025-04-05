package org.example.Repositories;

import org.example.exceptions.ProductAlreadyExistsException;
import org.example.exceptions.ProductNotFoundException;
import org.example.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProductRepository {
    // This class will handle the database operations related to products
    // Porducts is a Map with the product id as the key and the product as the value, because the id is unique
    private Map<Integer, Product> products;

    public ProductRepository() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) throws ProductAlreadyExistsException {
        if (products.containsKey(product.getProductId())) {
            throw new ProductAlreadyExistsException(product.getProductId());
        }
        products.put(product.getProductId(), product);
    }

    public void updateProduct(Product product) {
        int id = product.getProductId();
        if (products.containsKey(id)) {
            products.put(id, product);
        }
        throw new IllegalArgumentException("Product with id " + id + " does not exist.");
    }

    public void deleteProduct(int productId) {
        products.remove(productId);
    }

    public Product getProductById(int productId) throws ProductNotFoundException {
        Product product = products.get(productId);
        if (product == null) {
            throw new ProductNotFoundException(productId);
        }
        return product;
    }


    public List<Product> getAll() {
        return new ArrayList<>(products.values());
    }

    public boolean existsById(int productId) {
        return products.containsKey(productId);
    }
}
