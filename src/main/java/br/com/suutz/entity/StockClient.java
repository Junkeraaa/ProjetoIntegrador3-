package br.com.suutz.entity;

public class StockClient {

    private int id;
    private int user_id;
    private int stock_id;
    private double price_pay;

    public double getPricePay() {
        return this.price_pay;
    }

    public void setPricePay(double price_pay) {
        this.price_pay = price_pay;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return this.user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public int getStockId() {
        return this.stock_id;
    }

    public void setStockId(int stock_id) {
        this.stock_id = stock_id;
    }


}
