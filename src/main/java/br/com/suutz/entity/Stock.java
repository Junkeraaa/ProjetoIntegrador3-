package br.com.suutz.entity;

public class Stock implements StockInterface {

    private int id;
    private String name_stock;
    private double price_stock;

    public Stock() {
    }

    public int getID() {
        return id;
    }

    public String getNameStock() {
        return name_stock;
    }

    public double getPriceStock() {
        return price_stock;
    }
}

