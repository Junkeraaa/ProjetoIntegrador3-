package br.com.suutz.entity;

public class Stock {

    private int id;
    private String name_stock;
    private double price_stock;
    private double initial_price;

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

    public void setId(int id){
        this.id = id;
    }

    public void setNameStock(String name_stock){
        this.name_stock = name_stock;
    }

    public void setPriceStock(double price_stock){
        this.price_stock = price_stock;
    }

    public double getInitial_price() {
        return initial_price;
    }

    public void setInitial_price(double initial_price) {
        this.initial_price = initial_price;
    }
}


