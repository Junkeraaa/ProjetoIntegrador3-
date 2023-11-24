package br.com.suutz.common;

public class MyAssetsStocksInterface {
    private String name_Stock;
    private int qtd;
    private double price_pay;
    private double price_now;
    private double balance;

    public double getBalance() {
        return (double) Math.round(this.balance * 100) / 100;
    }

    public void setBalance() {
        this.balance = this.price_now - this.price_pay;
    }

    public String getNameStock() {
        return this.name_Stock;
    }

    public void setNameStock(String name_Stock) {
        this.name_Stock = name_Stock;
    }

    public int getQtd() {
        return this.qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getPricePay() {
        return Math.round(this.price_pay *100.0 )/100.0;
    }

    public void setPricePay(double price_pay) {
        this.price_pay = price_pay;
    }

    public double getPriceNow() {
        return Math.round(this.price_now * 100.0)/100.0;
    }

    public void setPriceNow(double price_now) {
        this.price_now = price_now;
    }

}
