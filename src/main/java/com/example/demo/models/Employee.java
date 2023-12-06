package com.example.demo.models;

public class Employee {
    private int id;
    private String name;
    private double money;
    public Employee(int i, String name, double v) {
        this.id = i;
        this.name = name;
        this.money = v;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void sumarMoney(double num){
        this.money+=num;
    }
}
