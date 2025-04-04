package org.example.model;

public class Salesman {
    //Salesman that works at the store
    private int salesman_id;//primary key, unique
    private String name;
    private int salary;

    public Salesman(int salesman_id, String name, int salary) {
        this.salesman_id = salesman_id;
        this.name = name;
        this.salary = salary;
    }

    //Get salesman id
    public int getSalesmanId() {
        return salesman_id;
    }

    //Set salesman id
    public void setSalesmanId(int salesman_id) {
        this.salesman_id = salesman_id;
    }

    //Get salesman name
    public String getName() {
        return name;
    }

    //Set salesman name
    public void setName(String name) {
        this.name = name;
    }

    //Get salesman salary
    public int getSalary() {
        return salary;
    }

    //Set salesman salary
    public void setSalary(int salary) {
        this.salary = salary;
    }
}
