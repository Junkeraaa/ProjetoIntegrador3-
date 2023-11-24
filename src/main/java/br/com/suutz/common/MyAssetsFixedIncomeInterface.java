package br.com.suutz.common;

import br.com.suutz.entity.FixedIncome;

public class MyAssetsFixedIncomeInterface {
    private String name;
    private String type;
    private double fee;
    private double price;

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getFee() {
        return this.fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    
}
