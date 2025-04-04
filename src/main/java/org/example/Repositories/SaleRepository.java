package org.example.Repositories;

import org.example.model.Sale;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaleRepository {
    private Map<Integer, Sale> sales;

    public SaleRepository() {
        this.sales = new HashMap<>();
    }

    public void addSale(Sale sale) {
        sales.put(sale.getSaleId(), sale);
    }

    public void updateSale(Sale updatedSale) {
        int id = updatedSale.getSaleId();
        if (sales.containsKey(id)) {
            sales.put(id, updatedSale);
        }
    }

    public void deleteSale(int saleId) {
        sales.remove(saleId);
    }

    public Sale getSaleById(int saleId) {
        return sales.get(saleId);
    }

    public List<Sale> getAll() {
        return new ArrayList<>(sales.values());
    }

    public boolean existsById(int saleId) {
        return sales.containsKey(saleId);
    }
}
