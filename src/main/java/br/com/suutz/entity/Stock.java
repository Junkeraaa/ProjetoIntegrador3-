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

    public double getFinalValue(){
        switch (name_stock) {
            case "APPL4":
                return Math.round((price_stock-83.2) * 100.0)/100.0;
            case "MGLU3":
                return Math.round((price_stock-1.2) * 100.0) / 100.0;
            case "PETR4":
                return Math.round((price_stock-27.92) * 100.0) / 100.0;
            case "CIEL3":
                return Math.round((price_stock-16.33) * 100.0) / 100.0;
            case "ITUB4":
                return Math.round((price_stock-51.25) * 100.0) / 100.0;
            case "AMER3":
                return Math.round((price_stock-0.11) * 100.0) / 100.0;
            case "CURY3":
                return Math.round((price_stock-14.16 )* 100.0) / 100.0;
            case "CEAB3":
                return Math.round((price_stock-2.27) * 100.0) / 100.0;
            case "GGPS3":
                return Math.round((price_stock-95.8) * 100.0) / 100.0;
            case "TASA4":
                return Math.round((price_stock-22.22) * 100.0) / 100.0;
            default:
                return price_stock-0.0;
        }
    }

    public double getInitialValue(){
        switch (name_stock) {
            case "APPL4":
                return 83.2;
            case "MGLU3":
                return 1.2;
            case "PETR4":
                return 27.92;
            case "CIEL3":
                return 16.33;
            case "ITUB4":
                return 51.25;
            case "AMER3":
                return 0.11;
            case "CURY3":
                return 14.16;
            case "CEAB3":
                return 2.27;
            case "GGPS3":
                return 95.8;
            case "TASA4":
                return 22.22;
            default:
                return 0.0;
        }
    }
}


