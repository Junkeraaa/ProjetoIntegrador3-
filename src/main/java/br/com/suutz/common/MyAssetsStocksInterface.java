package br.com.suutz.common;

public class MyAssetsStocksInterface {
    private String name_Stock;
    private int qtd;
    private double price_pay;
    private double price_now;

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
        return this.price_pay;
    }

    public void setPricePay(double price_pay) {
        this.price_pay = price_pay;
    }

    public double getPriceNow() {
        return this.price_now;
    }

    public void setPriceNow(double price_now) {
        this.price_now = price_now;
    }

}
