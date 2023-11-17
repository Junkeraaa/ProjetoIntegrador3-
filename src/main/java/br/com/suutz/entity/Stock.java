package br.com.suutz.entity;

public class Stock {

    private int id;
    String name_stock;
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

    public void setId(int id){
        this.id = id;
    }

    public void setNameStock(String name_stock){
        this.name_stock = name_stock;
    }

    public void setPriceStock(double price_stock){
        this.price_stock = price_stock;
    }
}

