package org.example.Repositories;

import org.example.exceptions.SalesmanNotFoundException;
import org.example.model.Salesman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesmanRepository {
    // This class is responsible for managing the salesmen in the store
    private Map<Integer, Salesman> salesmen;

    public SalesmanRepository() {
        this.salesmen = new HashMap<>();
    }

    public void addSalesman(Salesman salesman) {
        salesmen.put(salesman.getSalesmanId(), salesman);
    }

    public void updateSalesman(Salesman updatedSalesman) {
        int id = updatedSalesman.getSalesmanId();
        if (salesmen.containsKey(id)) {
            salesmen.put(id, updatedSalesman);
        }
    }

    public void deleteSalesman(int salesmanId) {
        salesmen.remove(salesmanId);
    }

    public Salesman getSalesmanById(int salesmanId) throws SalesmanNotFoundException {
        Salesman salesman = salesmen.get(salesmanId);
        if (salesman == null) {
            throw new SalesmanNotFoundException(salesmanId);
        }
        return salesman;
    }


    public List<Salesman> getAll() {
        return new ArrayList<>(salesmen.values());
    }

    public boolean existsById(int salesmanId) {
        return salesmen.containsKey(salesmanId);
    }
}
