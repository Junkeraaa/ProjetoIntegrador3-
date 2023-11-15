package br.com.suutz.entity;

public class FixedIncome {

    private int id;
    private double price;
    private String name;
    private String type;
    private double fee;

    public FixedIncome() {
      
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public double getFee() {
        return fee;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setFee(double fee){
        this.fee = fee;
    }
}

